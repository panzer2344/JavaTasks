package com.podval.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewPassword extends HttpServlet {

    private void printMessage(HttpServletResponse response, String error) throws IOException{
        response.getOutputStream().print(error);
        response.getOutputStream().flush();
    }

    private void printEmptyPasswordError(HttpServletResponse response) throws IOException {
        String error = "<html><body><h1>Error: empty password!</h1>" +
                "<br><a href='/static/newPassword.html'>back</a></body></html>";
        printMessage(response, error);
    }

    private void printEqualOldPasswordError(HttpServletResponse response) throws IOException {
        String error = "<html><body><h1>Error: new password equals to old!</h1>" +
                "<br><a href='/static/newPassword.html'>back</a></body></html>";
        printMessage(response, error);
    }

    private void printSuccessMessage(HttpServletResponse response) throws IOException {
        String error = "<html><body><h1>password successfully changed</h1>" +
                "<br><a href='/static/login.html'>Login</a></body></html>";
        printMessage(response, error);
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response, User user)
            throws IOException{
        if(RecordsManager.deleteRow(user.getLogin(), getServletContext())) {
            RecordsManager.addRecord(getServletContext(), user);
        }
        request.getSession().removeAttribute("tryLogin");
        LoginAttempts.zeroize(request.getRemoteAddr());
        response.sendRedirect("/static/login.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = (String) req.getSession().getAttribute("tryLogin");
        User user = new User(login, password);
        Boolean success = false;

        // isValidPass use there to check if new pass equal to old
        if(!password.isEmpty()){
            if(!RecordsManager.isValidPassword(getServletContext(), user)) {
                changePassword(req, resp, user);
                return;
            }else{
                printEqualOldPasswordError(resp);
            }
        }else{
            printEmptyPasswordError(resp);
        }

    }
}
