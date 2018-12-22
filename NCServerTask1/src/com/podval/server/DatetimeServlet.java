package com.podval.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String responseTemplate = "<html> <body>" +
                "<p> <h1> Server datetime: %s </h1> </p>" +
                "<p> <h1> Browser: %s </h1> </p> " +
                "  </body> </html> ";

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43


        resp.getWriter().write(
                String.format(
                        responseTemplate,
                        dateFormat.format(date),
                        req.getHeader("User-Agent")
                )
        );

        resp.getWriter().flush();

    }
}
