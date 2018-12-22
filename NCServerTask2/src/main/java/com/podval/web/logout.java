package com.podval.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class logout extends HttpServlet {

    public static void removeCookies(Cookie[] cookies, HttpServletResponse resp){

            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        Cookie[] cookies = req.getCookies();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String remember = req.getParameter("rememberCB");

        if(session != null){
            session.invalidate();
        }

        if(cookies != null){
            removeCookies(cookies, resp);
        }

        if(login != null){
            StringBuilder sb = new StringBuilder("/login?login=").append(login).append("&password=").append(password);
            if(remember != null && !remember.equals("")){
                sb.append(remember);
            }
            resp.sendRedirect(sb.toString());
        }else {
            resp.sendRedirect("/static/login.html");
        }

    }
}
