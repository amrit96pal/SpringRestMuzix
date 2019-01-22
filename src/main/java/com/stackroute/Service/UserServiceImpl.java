package com.stackroute.Service;

import com.stackroute.UserRepository.UserRepository;
import com.stackroute.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User saveUser(User user) {
        User ansObj=userRepository.save(user);
        return ansObj;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> ans=userRepository.findAll();
        return ans;
    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user=userRepository.findById(id);
        return user;
    }

    @Override
    public void delete(int id) {
    Optional<User> user=userRepository.findById(id);
    userRepository.delete(user.get());
    }

    @Override
    public void updateUser(User user) {
    userRepository.save(user);
    }

    @Override
    public User getBYFirstname(String firstname) {
      Optional<User> user=  userRepository.findByFirstname(firstname);
      return user.get();
    }


}
