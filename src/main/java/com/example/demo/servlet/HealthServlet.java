package com.example.demo.servlet;

import jakarta.persistence.*;

@WebServlet(urlPatterns="/health")
public class HealthServlet extends HttpServlet{

    protected void deoGet(HttpServletRequest req,HttpServlet resp) throws IOException
    {
        resp.getWriter().write("OK");
    }
}
