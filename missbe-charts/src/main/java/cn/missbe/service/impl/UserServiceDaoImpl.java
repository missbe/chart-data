package cn.missbe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.missbe.dao.UserDao;
import cn.missbe.service.UserService;

@Service("userService")
public class UserServiceDaoImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
    
//	public UserDao getUserDao() {
//		return userDao;
//	}
//	
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

	public boolean isExist(String username, String password) {	
		if(null != userDao.getUser(username, password))
			return true;
		return false;
	}

}
