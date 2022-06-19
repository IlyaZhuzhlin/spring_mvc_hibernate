package com.ilyazhuzhlin.spring.mvc_hibernate.entity.dao;

import com.ilyazhuzhlin.spring.mvc_hibernate.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

   public void saveUser(User user);

  public User getUser(int id);

  public void deleteUser(int id);
}
