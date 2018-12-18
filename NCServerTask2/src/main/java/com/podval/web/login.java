package com.podval.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class login extends HttpServlet {

    private static final String USERS_FILE = "/data/users.txt";

    private Users getUsers() throws IOException {
        return new Users(Files.lines(Paths.get(getServletContext().getRealPath(USERS_FILE)), StandardCharsets.UTF_8).toArray());
    }

    private boolean isKnownUser(User user) throws IOException {
        return getUsers().get(user.getLogin()) != Users.NO_USER;
    }

    private boolean isValidPassword(User user) throws IOException {
        return getUsers().get(user.getLogin()).getPassword().equals(user.getPassword());
    }

    private void printEmptyDataPairError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getOutputStream().print("<html> <center><h3>Login and password mustn't be empty</h3></center> </html>");
        resp.getOutputStream().flush();
    }

    private void printInvalidPasswordError(HttpServletRequest req, HttpServletResponse resp, User user) throws IOException {
        resp.getOutputStream().print("<html> <center><h3>Pair(" + user.getLogin() + ", " + user.getPassword() + ") isn't valid</h3></center> </html>");
        resp.getOutputStream().flush();
    }

    private void enterWelcomePage(HttpServletRequest req, HttpServletResponse resp, String login) throws ServletException, IOException {
        req.setAttribute("login", login);
        resp.sendRedirect("/static/welcome.jsp");
    }

    private void enterCreateUserPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/static/createUser.html");
    }

    private void initSession(HttpServletRequest req, User user){
        HttpSession session = req.getSession(true);
        session.setAttribute("login", user.getLogin());
        session.setAttribute("password", user.getPassword());
    }

    private void loginningHttpSessions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User(req.getParameter("login"), req.getParameter("password"));
        HttpSession session = req.getSession(false);


        if(user.equals(Users.EMPTY_USER)){
            if(session == null){
                printEmptyDataPairError(req, resp);
            }else{
                enterWelcomePage(req, resp, (String) session.getAttribute("login"));
                return;
            }
        }else{
            if(isKnownUser(user)){
                if(isValidPassword(user)){
                    initSession(req, user);
                    enterWelcomePage(req, resp, user.getLogin());
                    return;
                } else{
                    printInvalidPasswordError(req, resp, user);
                }
            } else{
                enterCreateUserPage(req, resp);
            }
        }


    }

    private void loginningCookies(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean iscookie = "on".equals(req.getParameter("cookieCB"));

        if(!iscookie) {
            loginningHttpSessions(req, resp);
            return;
        }

    }
}
