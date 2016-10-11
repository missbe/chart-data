package cn.missbe.service;

import java.sql.SQLException;

import cn.missbe.model.User;

public interface UserServiceI {
     User getUserBean(String name,String password) throws SQLException;
     boolean modifyUserPass(String pass) throws SQLException;
}
