package com.java.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class IdFetcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("xml");
        String roll = req.getParameter("searchroll");
        req.setAttribute("data", StudentServlet.map.get(roll));

    }
}
