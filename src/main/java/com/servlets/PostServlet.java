package com.servlets;

import com.dao.*;
import com.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.html");
            return;
        }
        User user = (User) session.getAttribute("user");

        Post post = new Post(0 , req.getParameter("posttitle") , req.getParameter("postcontent") , user.getUserId());

        PostDAO postDAO = new PostDAOImpl();
        int res = postDAO.createPost(post);

        if(res == 1)
        {
            resp.sendRedirect("ViewServlet");
        }

        else {
            out.println("Post not uploaded");
        }
    }
}
