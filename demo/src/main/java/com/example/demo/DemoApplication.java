package com.example.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;


@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	UserMapper userMapper;
	
	@PostMapping(path="/login2")
	public ResponseEntity<String> login2(@RequestBody User user) {
		int result = userMapper.login(user.getName(), user.getPassword());
		if(result == 1) return new ResponseEntity<String>("Login Success", HttpStatus.OK);
		else return new ResponseEntity<String>("Login Fail", HttpStatus.UNAUTHORIZED);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
