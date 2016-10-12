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
	private String username;
	private String userpass;
	private String loginkeeping;
	private String repeatUserpass;
	/**
	 * 负责用户登录处理，成功进入首页
	 */
	@Override
	public String execute(){
		System.out.println(username+":"+userpass);
		UserServiceI service=new UserServiceImpl();
		User admin=null;
		try {
			admin = service.getUserBean(username, userpass);
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
		if(!userpass.equals(repeatUserpass)){
			setRequestAttribute("message", "^_^请确认两次密码相同哦^_^");
			setRequestAttribute("pass",userpass);
			return INPUT;
		}
		UserServiceI service=new UserServiceImpl();
		boolean flag=false;
		try {
			flag=service.modifyUserPass(userpass);
		} catch (SQLException e) {
			System.out.println("产生异常：modifyPassword");
			e.printStackTrace();
		}
		if(flag){
			setRequestAttribute("message", "^_^密码更新完成^_^");
			return SUCCESS;
		}else{
			setRequestAttribute("message", "^_^程序有点儿问题，稍后再试^_^");
		    return INPUT;	
		}
		 
	}
	private void setRequestAttribute(String msg,Object object){
		ServletActionContext.getRequest().setAttribute(msg, object);
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getLoginkeeping() {
		return loginkeeping;
	}
	public void setLoginkeeping(String loginkeeping) {
		this.loginkeeping = loginkeeping;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRepeatUserpass() {
		return repeatUserpass;
	}
	public void setRepeatUserpass(String repeatUserpass) {
		this.repeatUserpass = repeatUserpass;
	}

}
