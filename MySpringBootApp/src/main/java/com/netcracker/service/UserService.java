package com.netcracker.service;

import com.netcracker.model.User;
import com.netcracker.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    private static UserRepository userRepository = new UserRepository();

    public void save(User user) {
        if(user!=null) {
            List<User> users = userRepository.getAll();
            if(!users.isEmpty()) {
                User lastUser = users.get(users.size() - 1);
                user.setId(lastUser.getId()+1);
                userRepository.save(user);
            }
        }
    }

    public void delete(User user) {
        if(user!=null) {
            userRepository.delete(user);
        }
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User getById(Integer id) {
        if(id!=null) {
            return userRepository.getById(id);
        }
        return null;
    }
}
