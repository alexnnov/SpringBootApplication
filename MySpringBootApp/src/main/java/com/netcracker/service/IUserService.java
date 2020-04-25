package com.netcracker.service;

import com.netcracker.model.User;

import java.util.List;

public interface IUserService {
    void save(User user);

    void delete(User user);

    List<User> getAll();

    User getById(Integer id);
}
