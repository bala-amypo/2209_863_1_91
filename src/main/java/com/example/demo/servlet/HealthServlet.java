package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet(urlPatterns="/health")
public class HealthServlet extends HttpServlet{

    @Override
    protected void deoGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,
    {
        resp.getWriter().write("OK");
    }
}
