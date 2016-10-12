package cn.missbe.action;

import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.model.User;
import cn.missbe.service.UserServiceI;
import cn.missbe.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//用户
	private User user;
	private String userpass;
	
	/**
	 * 负责用户登录处理，成功进入首页
	 */
	@Override
	public String execute(){
		System.out.println(user.getUsername()+":"+user.getUserpass());
		UserServiceI service=new UserServiceImpl();
		User admin=null;
		try {
			admin = service.getUserBean(user.getUsername(), user.getUserpass());
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		if(null!=admin){
//			ServletActionContext.getRequest().setAttribute("key", user.getUpdate_time());			
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
			ServletActionContext.getRequest().getSession().setMaxInactiveInterval(3600*3);
			return SUCCESS;
		}else{
			System.out.println("未查询到该用户");
			ServletActionContext.getRequest().setAttribute("message","用户名或者密码不正确^_^");
			 return INPUT;
		}	  
	}
	/**
	 * 用户密码修改处理
	 * @return 结果-向前台发送提示信息
	 */
	public String modifyPassword(){
//		System.out.println("userpass:"+userpass);
		UserServiceI service=new UserServiceImpl();
		boolean flag=false;
		try {
			flag=service.modifyUserPass(userpass);
		} catch (SQLException e) {
			System.out.println("产生异常：modifyPassword");
			e.printStackTrace();
		}
		if(flag){
			ServletActionContext.getRequest().setAttribute("message", "密码更新完成^_^");
			return SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("message", "会话已经过期^_^");
		    return INPUT;	
		}
		 
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

}
