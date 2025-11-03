package com.dao;

import com.model.User;

import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    public int registerUser(User user)
    {
        try {
            String sql = "insert into users(username, userpassword) values(?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());
            int res = 0;
            res = preparedStatement.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User validateUser(String userName , String userPassword)
    {
        User loggedInUser = null;
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND userpassword = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                loggedInUser = new User();
                loggedInUser.setUserId(resultSet.getInt("userid"));
                loggedInUser.setUserName(resultSet.getString("username"));
                loggedInUser.setUserPassword(resultSet.getString("userpassword"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedInUser;
    }
}
