package org.service1.dao;

import org.service1.domain.User;
import org.service1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    
    @Autowired
    private UserMapper userMapper;
    
    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }
    
//    public int insertUserWithBackId(User user){    
//        return userMapper.insertUserWithBackId(user);
//    }
    
}