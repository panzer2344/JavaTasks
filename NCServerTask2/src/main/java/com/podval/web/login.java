package com.podval.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;


/*
*
*
* todo: make password validation for servlet like for cookies
*
* */

public class login extends HttpServlet {

    //private static final String USERS_FILE = "/data/users.txt";
    //private static Boolean oldRemember = false;

    private void printEmptyDataPairError(HttpServletResponse resp) throws IOException {
        resp.getOutputStream().print("<html> <center><h3>Login and password mustn't be empty</h3>" +
                "<br><a href='/static/login.html'>back</a></center> </html>");
        resp.getOutputStream().flush();
    }

    private void printInvalidPasswordError(HttpServletResponse resp, User user) throws IOException {
        resp.getOutputStream().print("<html> <center><h3>Pair(" + user.getLogin() + ", " + user.getPassword() + ") isn't valid</h3>" +
                "<br><a href='/static/login.html'>back</a></center> </html>");
        resp.getOutputStream().flush();
    }

    private void printInvalidPasswordError(HttpServletResponse resp, User user, Integer attempts) throws IOException {
        resp.getOutputStream().print("<html> <center><h3>Pair(" + user.getLogin() + ", " + user.getPassword() + ") isn't valid<br>" +
                "You tried" + attempts + "times</h3><br><a href='/static/login.html'>back</a></center> </html>");
        resp.getOutputStream().flush();
    }

    private void enterWelcomePage(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/static/welcome.jsp");
    }

    private void enterWelcomePageWithoutSession(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException, ServletException {
        req.setAttribute("login", user.getLogin());
        req.getRequestDispatcher("/static/welcome.jsp").forward(req, resp);
    }

    private void enterCreateUserPage(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/static/createUser.html");
    }

    private void initSession(HttpServletRequest req, User user) {
        HttpSession session = req.getSession(true);
        session.setAttribute("login", user.getLogin());
        session.setMaxInactiveInterval(5 * 60);
    }

    private void badSessionDataError(HttpServletResponse response, String login) throws IOException {
        response.getOutputStream().print("<html> <center><h3>Session login: " + login + " isnt valid </h3>" +
                "<br><a href='/static/login.html'>back</a></center> </html>");
        response.getOutputStream().flush();
    }

    private void printEmptyInputDataError(HttpServletRequest req, HttpServletResponse resp, String login, Boolean isCookie) throws IOException {
        if(login != null) {
            if(isCookie){
                badCookiesError(resp, req.getCookies());

            }else {
                badSessionDataError(resp, login);
            }
        }else{
            printEmptyDataPairError(resp);
        }
    }

    private void passwordAttemptsChecking(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        String remoteIP = request.getRemoteAddr();
        if(loginAttempts.get(remoteIP) < 2){
            loginAttempts.inc(remoteIP);
            printInvalidPasswordError(response, user, loginAttempts.get(remoteIP));
        }else{
            request.getSession().setAttribute("tryLogin", user.getLogin());
            response.sendRedirect("/static/newPassword.html");
        }
    }

    private void loginningHttpSessions(HttpServletRequest req, HttpServletResponse resp, String remember) throws ServletException, IOException {

        User user = new User(req.getParameter("login"), req.getParameter("password"));
        HttpSession session = req.getSession(false);
        Boolean isNeedRemember = "on".equals(remember);
        ServletContext context = getServletContext();


        if (user.equals(Users.EMPTY_USER)) {
            if (session == null) {
                printEmptyDataPairError(resp);
                return;
            } else {
                String login = (String) session.getAttribute("login");
                if (recordsManager.isKnownUser(context, login)) {
                    enterWelcomePage(resp);
                    return;
                } else {
                    printEmptyInputDataError(req, resp, login, false);
                }
            }
        } else {
            if (recordsManager.isKnownUser(context, user)) {
                if (recordsManager.isValidPassword(context, user)) {
                    if(isNeedRemember) {
                        initSession(req, user);
                        enterWelcomePage(resp);
                        return;
                    }
                    else{
                        enterWelcomePageWithoutSession(req, resp, user);
                    }
                } else {
                    passwordAttemptsChecking(req, resp, user);
                    return;
                }
            } else {
                enterCreateUserPage(resp);
            }
        }


    }

    public Optional<String> readCookie(HttpServletRequest request, String key) {
        return Arrays.stream(request.getCookies())
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

    public void changeCookieValue(HttpServletRequest request, String key, String newValue) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(key)) {
                cookie.setValue(newValue);
                cookie.setMaxAge(5 * 60);
            }
        }
    }

    private void badCookiesError(HttpServletResponse response, Cookie[] cookies) throws IOException {
        StringBuilder sb = new StringBuilder("<html> <center><h3>Session cookie isnt valid:<br>");

        for (Cookie cookie : cookies) {
            sb.append(cookie.getName()).append(": ");
            sb.append(cookie.getValue()).append("<br>").append(cookie.getMaxAge()).append("<br>");
        }

        sb.append("<br></h3></center> </html>");
        response.getOutputStream().print(sb.toString());
        response.getOutputStream().flush();
    }

    private void initCookies(HttpServletRequest req, HttpServletResponse resp, User user){
        Cookie[] cookies = req.getCookies();

        if (cookies != null && cookies.length > 1) {
            changeCookieValue(req, "login", user.getLogin());
            //changeCookieValue(req, "password", user.getLogin());

        } else {
            Cookie login = new Cookie("login", user.getLogin());
            login.setMaxAge(5 * 60);
            resp.addCookie(login);
            //Cookie password = new Cookie("password", user.getLogin());
        }
    }

    private void loginningCookies(HttpServletRequest req, HttpServletResponse resp, String remember) throws ServletException, IOException {

        User user = new User(req.getParameter("login"), req.getParameter("password"));
        Cookie[] cookies = req.getCookies();
        Boolean isNeedRemember = "on".equals(remember);
        ServletContext context = getServletContext();


        if (user.equals(Users.EMPTY_USER)) {
            if (cookies != null && cookies.length > 1) {
                String login = readCookie(req, "login").get();
                if (recordsManager.isKnownUser(context, login)) {
                    enterWelcomePage(resp);
                } else {
                    printEmptyInputDataError(req, resp, login, true);
                    return;
                }
            } else {
                printEmptyDataPairError(resp);
                return;
            }
        } else {
            if (recordsManager.isKnownUser(context, user)) {
                if (recordsManager.isValidPassword(context, user)) {
                    if(isNeedRemember) {
                        initCookies(req, resp, user);
                        enterWelcomePage(resp);
                    }else{
                        enterWelcomePageWithoutSession(req, resp, user);
                    }
                } else {
                    passwordAttemptsChecking(req, resp, user);
                    return;
                }
            }
            else{
                enterCreateUserPage(resp);
            }
        }
    }

    private void removeCookieAndSession(HttpServletRequest req, HttpServletResponse resp, String remember) throws IOException{
        StringBuilder sb = new StringBuilder("/logout?login=").append(req.getParameter("login")).append("&password=").append(req.getParameter("password"));
        if(remember != null && !remember.equals("")){
            sb.append("&rememberCB=on");
        }
        resp.sendRedirect(sb.toString());
        return;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean iscookie = "on".equals(req.getParameter("cookieCB"));
        String remember = req.getParameter("rememberCB");

        String remoteIP = req.getRemoteAddr();
        if(!loginAttempts.isContain(remoteIP)){
            loginAttempts.add(remoteIP);
        }

        if(iscookie){
            HttpSession session = req.getSession(false);
            if(session != null){
                if(session.getAttribute("login") != null){
                    session.removeAttribute("login");
                }
            }
            loginningCookies(req, resp, remember);
            return;
        }else{
            if(req.getCookies() != null) {
                if (!readCookie(req, "login").isEmpty()) {
                    removeCookieAndSession(req, resp, remember);
                }
            }

            loginningHttpSessions(req, resp, remember);
        }


    }
}
