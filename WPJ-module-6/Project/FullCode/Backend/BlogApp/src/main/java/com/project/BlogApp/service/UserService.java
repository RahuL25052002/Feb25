package com.project.BlogApp.service;

import java.util.List;

import com.project.BlogApp.entity.User;
import com.project.BlogApp.paylod.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);
    
    User authenticateUser(String email, String password);
    
//    User authenticateUser(String email, String password);


}
