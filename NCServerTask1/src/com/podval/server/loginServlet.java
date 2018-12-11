package com.podval.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    private void createAndSendResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if( !req.getParameter("password").equals(req.getParameter("login") + "123") ){

            sendResponse(req, resp, " <h1> Bad password </h1>");

            return;

        }

        sendResponse(req, resp, " <h1> Hello, " + req.getParameter("login") +  "</h1>");

        resp.getWriter().flush();

    }

    private void sendResponse(HttpServletRequest req, HttpServletResponse resp, String respMessage)
            throws ServletException, IOException {

        String respBegin = "<body style='background: #ccffe6; color: #00b35c; margin-top: 20%; text-align: center;'>";
        String respEnd = "</body>";

        resp.getWriter().write( respBegin + respMessage + respEnd );

        resp.getWriter().flush();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        createAndSendResponse(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        createAndSendResponse(req, resp);

    }
}
