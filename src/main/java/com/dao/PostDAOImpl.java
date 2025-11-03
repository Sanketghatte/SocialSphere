package com.dao;

import com.model.Post;
import com.model.User;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.PostTemplate;

public class PostDAOImpl implements PostDAO{

    public int createPost(Post post)
    {
        try {
            String sql = "insert into posts(posttitle, postcontent , userid) values(?, ? , ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, post.getPostTitle());
            preparedStatement.setString(2, post.getPostContent());
            preparedStatement.setInt(3, post.getUserId());

            int res = 0;
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public List<PostTemplate> viewPosts()
    {
        List<PostTemplate> postTemplates= new ArrayList<>();
        try {
            String sql = "SELECT  postid ,username , posttitle , postcontent FROM Posts LEFT JOIN Users WHERE Posts.userid = Users.userid";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                PostTemplate postTemplate = new PostTemplate( resultSet.getInt(1), resultSet.getString(2) ,
                                              resultSet.getString(3) , resultSet.getString(4));
                postTemplates.add(postTemplate);
            }

            return postTemplates;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postTemplates;
    }

}
