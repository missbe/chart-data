package cn.missbe.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.app.HappyKorea_Activepersonnelrank;
import cn.missbe.model.HappyKorea;
import cn.missbe.service.UserServiceI;
import cn.missbe.service.impl.UserServiceImpl;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 	负责更新论坛数据库-相关活跃用户
	 */
	@Override
	public String execute(){
		System.out.println("Invoke:execute");
		new HappyKorea_Activepersonnelrank().invokeUpdate();
		return SUCCESS;
	}
	/**
	 * 负责实现获取前二十名用户
	 * @return
	 */
	public String userList(){
		System.out.println("Invoke:userList");		
		List<HappyKorea> userList=list();
		
		if(null != userList){
			return SUCCESS;
		}else{		
			return "message";
		}		
	}
	private List<HappyKorea> list(){
		UserServiceI serviceImpl=new UserServiceImpl();
		List<HappyKorea> userList=null;
		try {
			userList=serviceImpl.getUserList();
		} catch (SQLException e) {			
			System.out.println("userList:"+e.getMessage());
			e.printStackTrace();
		}
		if(null != userList){
			ServletActionContext.getRequest().setAttribute("userList", userList);		
			
		}else{
			ServletActionContext.getRequest().setAttribute("message", "^_^数据库出了一些问题，请联系管理员处理^_^");		
			
		}	
		return userList!=null ?userList:null;
	}
}
