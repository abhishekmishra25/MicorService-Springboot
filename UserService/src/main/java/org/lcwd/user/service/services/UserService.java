package org.lcwd.user.service.services;

import org.lcwd.user.service.entity.User;

import java.util.List;

public interface UserService {

    // user operation


    // create
    User saveUser(User user);

    // get all user
    List<User> getAllUser();

    // get single user of given userID
    User getUser(String userID);

    // delete user of given userID
    boolean deleteUser(String userID);

     // update user of given userID;
    boolean updateUser(String userID);
}
