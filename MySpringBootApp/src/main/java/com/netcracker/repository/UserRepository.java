package com.netcracker.repository;

import com.netcracker.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserReposutory{
    private List<User> users = new ArrayList<User>();

    public UserRepository() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Ivan");
        user.setSecondName("Ivanovich");
        user.setLastName("Ivanov");
        user.setAge(55);
        user.setSalary(1000);
        user.setEmail("ivanov@mail.ru");
        user.setDepartment("sales");


    }

    public void save(User user) {
        users.add(user);
    }

    public void delete(User user) {
        users.remove(user);
    }

    public List<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }
}
