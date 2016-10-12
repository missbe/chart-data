package cn.missbe.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.app.HappyKorea_Activepersonnelrank;
import cn.missbe.app.Icnkr_Activepersonnelrank;
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
		
		new HappyKorea_Activepersonnelrank().invokeUpdate();///进行更新EnjoyKorea论坛
		new Icnkr_Activepersonnelrank().invokeUpdate();///进行更新Icnkr论坛
		
		List<HappyKorea> userList=list();
		if(null != userList){
			setRequestAttribute("userList", userList);	
			setRequestAttribute("message", "数据更新中ing.......");	
			return SUCCESS;
		}else{
			setRequestAttribute("message", "^_^程序出了点小bug,让管理员修改一下^_^");	
			return "message";
		}		
	}
	/**
	 * 负责实现获取前二十名用户
	 * @return
	 */
	public String userList(){
		System.out.println("Invoke:userList");		

		List<HappyKorea> userList=list();
		if(null != userList){
			setRequestAttribute("userList", userList);		
			return SUCCESS;
		}else{
			setRequestAttribute("message", "^_^数据库出了一些问题，请联系管理员处理^_^");		
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
		return userList!=null ?userList:null;
	}
	private void setRequestAttribute(String msg,Object object){
		ServletActionContext.getRequest().setAttribute(msg, object);
	}
}
