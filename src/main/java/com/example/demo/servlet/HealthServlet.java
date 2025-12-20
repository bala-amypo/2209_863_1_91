package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet(urlPatterns="/health")
public class HealthServlet extends HttpServlet{

    protected void deoGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException  {
        resp.getWriter().write("OK");
    }
}
