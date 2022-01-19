package com.revature.Loop.services;

import com.revature.Loop.entities.User;
import com.revature.Loop.repositories.UserRepository;
import com.revature.Loop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> temp = userRepository.findById(id);
        if(temp.isEmpty()) {
            return null;
        }
        else {
            return temp.get();
        }
    }

    @Override
    public List<User> getUsersForRoom(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
        return user;
    }

    @Override
    public void resetUser(Long id, boolean full) {
        User userdb = userRepository.getById(id);
        userdb.setVote_count(0);
        userdb.setCurrent_score(0);
        // if full reset, reset the total score as well:
        if(full) userdb.setTotal_score(0);
        userRepository.save(userdb);
    }
}
