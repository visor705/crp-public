package com.mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleServlet extends HttpServlet {

    private static final String RESPONSE_TEMPLATE = "<html>\n" +
        "<body>\n" +
        "<b>Hello, {username}!</b>\n" +
        " {0} requests accepted.\n" +
        "</body>\n" +
        "</html>";

    private final Object REQUESTS_COUNT_MONITOR = new Object();
    private int requestsCount = 0;


    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");
        int localRequestsCount = 0;

        if (username == null) {
            username = "Anonymous";
        }

        synchronized (REQUESTS_COUNT_MONITOR) {
            requestsCount++;
            localRequestsCount = requestsCount;
        }

        response.setStatus(200);

        response.getWriter().write(
                RESPONSE_TEMPLATE
                        .replace("{username}",username)
                        .replace("{0}", String.valueOf(localRequestsCount)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        synchronized (REQUESTS_COUNT_MONITOR) {
            requestsCount++;
        }
    }
}