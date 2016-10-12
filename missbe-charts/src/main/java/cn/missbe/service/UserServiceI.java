package cn.missbe.service;

import java.sql.SQLException;
import java.util.List;

import cn.missbe.model.HappyKorea;
import cn.missbe.model.User;
/**
 * 用户服务接口
 * @author Administrator
 *
 */
public interface UserServiceI {
	/**
	 * 负责获取用户详细信息
	 * @param name 用户姓名
	 * @param password 用户密码
	 * @return 查询用户，有则返回User模型对象
	 * @throws SQLException 抛出SQL异常
	 */
     User getUserBean(String name,String password) throws SQLException;
     /**
      * 负责更改用户密码
      * @param pass 用户输入的新密码
      * @return  成功返回true，失败返回false
      * @throws SQLException  抛出SQL异常
      */
     boolean modifyUserPass(String pass) throws SQLException;
     /**
      * 获取前20个用户对象
      * @return 返回用户列表 
      * @throws SQLException 抛出异常
      */
     List<HappyKorea> getUserList() throws SQLException;
}
