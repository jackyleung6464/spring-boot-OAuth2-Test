package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUser() {
		return userMapper.findAll();
	}
	
	public User getUserById(int id) {
		return userMapper.findById(id);
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public String login(String name, String password) {
		int count = userMapper.login(name,password);
		if(count == 1) return "OK";
		else return "ERR";
	}
}
