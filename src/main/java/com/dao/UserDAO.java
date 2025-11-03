package com.dao;

import com.model.User;



public interface UserDAO {
    int registerUser(User user);
    User validateUser(String userName , String userPassword);
}
