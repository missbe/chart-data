package cn.missbe.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.dyhack.db.DBConnection;
import cn.missbe.app.HappyKorea_Activepersonnelrank;
import cn.missbe.model.HappyKorea;
import cn.missbe.service.UserServiceI;
import cn.missbe.service.impl.UserServiceImpl;

public class ManagerTest {
  
	@Test
	public void testGetUserList(){
		UserServiceI serviceI=new UserServiceImpl();
		List<HappyKorea> userList=null;
		try {
			 userList=serviceI.getUserList();
		} catch (SQLException e) {
			System.out.println("测试错误-testGetUserList");
			e.printStackTrace();
		}
		if(null!=userList){
			for (HappyKorea happyKorea : userList) {
				System.out.println(happyKorea.getAuthor()+":"+happyKorea.getPostNumber());
			}
		}
		assertNotNull(userList);
	}
	@Test
	public void testConnection(){
		System.out.println("testConnection:测试conn");
		assertNotNull(new DBConnection().getConnection());
	}
	
	@Test
	public void testUpdate(){
		new HappyKorea_Activepersonnelrank().invokeUpdate();
		System.out.println("testUpdate:测试更新");
	}
	
}
