package com.podval.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String cc = req.getParameter("cc");
        String text = req.getParameter("text");

        try {

            String s = Mailer.send(email, subject, text, cc);

            resp.getWriter().write(s);
            resp.getWriter().flush();

        }catch (RuntimeException re){

            resp.getWriter().write("Error with sending message");
            resp.getWriter().flush();

        }

    }
}
