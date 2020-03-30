package com.github.dzeko14.models.dao;

import com.github.dzeko14.models.User;

import javax.ejb.Local;

@Local
public interface UserDao {
    boolean saveUser(User user);
    User getUserByNumber(String phoneNumber);
}
