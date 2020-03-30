package com.github.dzeko14.models.dao;

import com.github.dzeko14.models.User;

public interface UserDao {
    boolean saveUser(User user);
    User getUserByNumber(String phoneNumber);
}
