package com.stackroute.Service;

import com.stackroute.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public Optional<User> getUserById(int id);

    public void delete(int id);

    public void updateUser(User user);

    public User getBYFirstname(String firstname);
}
