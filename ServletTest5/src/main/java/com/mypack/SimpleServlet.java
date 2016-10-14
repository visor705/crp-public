package com.mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by oleg on 14.10.16.
 */
public class SimpleServlet extends HttpServlet {

    private String getResponseTemplate = "<html>\n" +
        "<body>\n" +
        "<b>Hello, {username}!</b>\n" +
        " {0} requests accepted.\n" +
        "</body>\n" +
        "</html>";
    private int requestsCount = 0;

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");

        if (username == null)
        {
            username = "Anonymous";
        }

        requestsCount++;
        response.setStatus(200);

        response.getWriter().write(
                getResponseTemplate
                        .replace("{username}",username)
                        .replace("{0}", String.valueOf(requestsCount)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        requestsCount++;
    }
}