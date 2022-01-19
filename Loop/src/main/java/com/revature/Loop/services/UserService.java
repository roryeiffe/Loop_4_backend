package com.revature.Loop.services;

import com.revature.Loop.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void addUser(User user);
    public User getUserById(Long id);
    public List<User> getUsersForRoom(Long id);
    public void deleteUser(Long id);
    public User updateUser(Long id, User user);
    public void resetUser(Long id, boolean full);

}
