package com.servlets;

import com.dao.*;
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

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        PostDAO postDAO = new PostDAOImpl();
        List<PostTemplate> postTemplates = postDAO.viewPosts();
        CommentDAO commentDAO = new CommentDAOImpl();

        for (PostTemplate postTemplate : postTemplates)
        {
            out.println( "Username: " + postTemplate.getUserName() + "<br>");
            out.println("Post Title: " + postTemplate.getPostTitle() + "<br>");
            out.println("Post Content : " + postTemplate.getPostContent() + "<br>");
            int postId = postTemplate.getPostId();

            out.println("Comments" + "<br>");

            List<CommentTemplate> commentTemplates = commentDAO.viewComments(postId);
            for(CommentTemplate commentTemplate : commentTemplates)
            {
                out.println("username:" + commentTemplate.getUserName() + "<br>");
                out.println("comment:" + commentTemplate.getCommentContent() + "<br>");
            }

            out.println("<form action='CommentServlet' method='get'>");
            out.println("<input type='hidden' name='postId' value='" + postId + "' />");
            out.println("<label>Add comment:</label><br>");
            out.println("<input type='text' name='commentContent' required/><br>");
            out.println("<input type='submit' value='Post Comment'/>");
            out.println("</form>");

            out.println("<br>");
            
        }
    }
}
