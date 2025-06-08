package com.project.BlogApp.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.User;
import com.project.BlogApp.exception.ResourceNotFoundException;
import com.project.BlogApp.paylod.UserDto;
import com.project.BlogApp.repository.UserRepo;
import com.project.BlogApp.service.UserService;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDtoToUser(userDto);
        return userToUserDto(userRepo.save(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        userRepo.save(user);
        return userToUserDto(user);

    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId));
        return userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepo.findAll();
        // List<UserDto> userDto = new ArrayList<>();
        // for (User user : users) {
        // userDto.add(userToUserDto(user));
        // }
        // return userDto;
        // or
        return users.stream().map(e -> userToUserDto(e)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId));
        userRepo.delete(user);
    }

    private User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToUserDto(User user) {
        UserDto userdto = new UserDto();
//        userdto.setId(user.getId());
        userdto.setEmail(user.getEmail());
        userdto.setName(user.getName());
        userdto.setPassword(user.getPassword());
        userdto.setAbout(user.getAbout());
        return userdto;
    }
    
    @Override
    public User authenticateUser(String email, String password) {
        return userRepo.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
    
//    public Optional<User> getUserIfAuthenticated(String email, String password) {
//        Optional<User> user = UserRepo.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }


}
