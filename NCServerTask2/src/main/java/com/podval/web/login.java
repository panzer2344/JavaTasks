package com.podval.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class login extends HttpServlet {

    private static final String USERS_FILE = "/data/users.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User(req.getParameter("login"), req.getParameter("password"));

        Object[] usersStrAr =  Files.lines(Paths.get(getServletContext().getRealPath(USERS_FILE)), StandardCharsets.UTF_8).toArray();

        Users users = new Users(usersStrAr);

        User u = users.get("admin");

        StringBuilder str = new StringBuilder(Arrays.toString(usersStrAr));
        str.deleteCharAt(0);
        str.deleteCharAt(str.length() - 1);

        resp.getOutputStream().print(Arrays.toString(Files.lines(Paths.get(getServletContext().getRealPath(USERS_FILE)), StandardCharsets.UTF_8).toArray()));
        resp.getOutputStream().flush();

    }
}
