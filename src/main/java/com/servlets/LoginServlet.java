package com.servlets;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int res = 0;

        User user;

        UserDAO userDAO = new UserDAOImpl();
        user = userDAO.validateUser( req.getParameter("username"), req.getParameter("password"));

        if(user != null)
        {
            HttpSession session = req.getSession();

            session.setAttribute("user", user);

            resp.sendRedirect("home.html");

        }

        else {
            resp.sendRedirect("register.html");
        }

    }
}
