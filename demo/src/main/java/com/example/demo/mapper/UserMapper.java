package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	@Select("select * from users")
	List<User> findAll();
	
	@Select("select * from users where id=#{id}")
	User findById(int id);

	@Insert("insert into users (name,password) values(#{user.name} , #{user.password})")
	void insertUser(@Param("user")User user);

	@Select("select count(*) from users where name=#{name} and password=#{password}")
	int login(String name, String password);
}
