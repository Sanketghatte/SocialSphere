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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        User user = new  User( 0 ,req.getParameter("username"), req.getParameter("password"));
        UserDAO userDAO = new UserDAOImpl();
        int res = userDAO.registerUser(user);



        if(res == 1)
        {
            resp.sendRedirect("login.html");
        }

        else{

            out.println("Registration failed");

        }

    }


}
