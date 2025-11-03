package com.dao;
import com.model.Comment;
import com.model.CommentTemplate;
import com.model.PostTemplate;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{

    public int createComment(Comment comment)
    {
        try {
            String sql = "insert into comments(commentcontent , postid , userid) values(?, ? , ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, comment.getCommentContent());
            preparedStatement.setInt(2, comment.getPostId());
            preparedStatement.setInt(3, comment.getUserId());

            int res = 0;
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CommentTemplate> viewComments(int postId)
    {
        {
            List<CommentTemplate> commentTemplates= new ArrayList<>();
            try {
                String sql = "SELECT u.username, c.commentcontent FROM Comments c JOIN Users u ON c.userid = u.userid WHERE c.postid = ?";
                PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, postId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next())
                {
                    CommentTemplate commentTemplate = new CommentTemplate(resultSet.getString(1) ,
                            resultSet.getString(2));
                    commentTemplates.add(commentTemplate);
                }

                return commentTemplates;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return commentTemplates;
        }
    }

}
