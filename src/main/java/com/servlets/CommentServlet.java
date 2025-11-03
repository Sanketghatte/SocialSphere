package com.servlets;

import com.dao.*;
import com.model.Comment;
import com.model.CommentTemplate;
import com.model.PostTemplate;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.html");
            return;
        }

        int postId = Integer.parseInt(req.getParameter("postId"));
        String commentContent = req.getParameter("commentContent");

        CommentDAO commentDAO = new CommentDAOImpl();
        commentDAO.createComment(new Comment(0 , commentContent , postId , user.getUserId()));

        resp.sendRedirect("ViewServlet");
    }
}

