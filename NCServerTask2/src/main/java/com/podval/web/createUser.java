package com.podval.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class createUser extends HttpServlet {

    private static final String USERS_FILE = "/data/users.txt";

    private Users getUsers() throws IOException {
        return new Users(Files.lines(Paths.get(getServletContext().getRealPath(USERS_FILE)), StandardCharsets.UTF_8).toArray());
    }

    private boolean isKnownUser(User user) throws IOException {
        return getUsers().get(user.getLogin()) != Users.NO_USER;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String cookieCb = req.getParameter("cookieCB");

        User user = new User(login, password);

        if(isKnownUser(user)){
            resp.getOutputStream().print("<h1 align='center'>Username is already taken</h1>");
            resp.getOutputStream().flush();
            return;
        }

        if(login.matches(("(.*)(\\s+)(.*)")) || password.matches("(.*)(\\s+)(.*)")){
            resp.getOutputStream().print("<h3>login and password mustn't contain spaces</h3>");
            resp.getOutputStream().flush();
            return;
        }else {
            StringBuilder sb = new StringBuilder("\r\n").append(login).append(" ").append(password);
            Files.write(Paths.get(getServletContext().getRealPath(USERS_FILE)), sb.toString().getBytes(), StandardOpenOption.APPEND);
            resp.sendRedirect("/static/login.html");
        }

    }
}
