package com.project.BlogApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.entity.User;
import com.project.BlogApp.paylod.APIResponse;
import com.project.BlogApp.paylod.LoginDto;
import com.project.BlogApp.paylod.UserDto;
import com.project.BlogApp.response.Response;
import com.project.BlogApp.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin

@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // post add

    @PostMapping("/")
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok(new Response("User created Successfully"));
        
    }
    // @PostMapping("/")
    // public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
    //     UserDto dto = userService.createUser(userDto);
    //     return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
        
    // }

    // put - update

//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Integer id) {
//        UserDto updatedUser = userService.updateUser(userDto, id);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

//    // get
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id) {
//        UserDto dto = userService.getUserById(id);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
//
//        userService.deleteUser(id);
//        // return ResponseEntity.ok(Map.of("Message","User DeletedSuccessfully"));
//        return new ResponseEntity<>(new APIResponse("User Deleted Successfully", true), HttpStatus.OK);
//    }
    
//    @PostMapping("/login")
//    public ResponseEntity<Response> loginUser(@Valid @RequestBody LoginDto loginDto) {
//        boolean isAuthenticated = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());
//
//        if (isAuthenticated) {
//            return ResponseEntity.ok(new Response("Login Successful"));
//        } else {
//            return new ResponseEntity<>(new Response("Invalid credentials"), HttpStatus.UNAUTHORIZED);
//        }
//    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto) {
        User user = userService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());

        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("name", user.getName());
            response.put("email", user.getEmail());
            response.put("message", "Login Successful");

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid credentials"));
        }
    }
}
