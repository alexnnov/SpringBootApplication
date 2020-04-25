package com.netcracker.repository;

import com.netcracker.model.User;
import java.util.List;

public interface IUserReposutory {

    void save(User user);

    void delete(User user);

    List<User> getAll();

    User getById(Integer id);
}
