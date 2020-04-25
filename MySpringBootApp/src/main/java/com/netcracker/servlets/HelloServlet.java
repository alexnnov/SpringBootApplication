package com.netcracker.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter output = resp.getWriter() ;
       StringBuilder sb = new StringBuilder("<html>");

       sb.append("/body").append("<h1>");
       sb.append("Hello from servlet!!!");
       sb.append("</h1>").append("</body>").append("</html>");

       output.write(sb.toString());
   }
}
