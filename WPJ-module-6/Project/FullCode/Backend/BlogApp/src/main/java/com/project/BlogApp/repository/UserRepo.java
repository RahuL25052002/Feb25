package com.project.BlogApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {
//	User findByEmail(String email);
	Optional<User> findByEmail(String email);

}
