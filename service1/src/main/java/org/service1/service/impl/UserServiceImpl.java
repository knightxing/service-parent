package org.service1.service.impl;

import org.service1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;


@Service
public class UserServiceImpl {
	
	@Autowired
	private UserDao userDao;

	public boolean addUser(String username, String password) {
		return userDao.insertUser(username, password) == 1 ? true : false;
	}

//	public User addUserWithBackId(String username, String password) {
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		userDao.insertUserWithBackId(user);// 该方法后，主键已经设置到user中了
//		return user;
//	}
}
