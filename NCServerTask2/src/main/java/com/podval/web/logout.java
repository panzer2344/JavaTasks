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

        if(session != null){
            session.invalidate();
        }

        resp.sendRedirect("/static/login.html");

    }
}
