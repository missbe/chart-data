package cn.missbe.action;

import java.sql.SQLException;
import java.util.ArrayList;
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
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				new HappyKorea_Activepersonnelrank().invokeUpdate();///进行更新EnjoyKorea论坛
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e) {
					System.out.println("线程被打断异常");
					e.printStackTrace();
				}
				new Icnkr_Activepersonnelrank().invokeUpdate();///进行更新Icnkr论坛
			}
		}).start();
		//		List<HappyKorea> userList=list();
//		if(null != userList){
//			setRequestAttribute("userList", userList);	
//			setRequestAttribute("message", "数据更新中完成");	
//			
//			return SUCCESS;
//		}else{
//			setRequestAttribute("message", "^_^程序出了点小bug,让管理员修改一下^_^");	
//			return "message";
//		}	
		setRequestAttribute("message", "^_^数据在后台进行更新哦^_^");
		return "message";
	}
	/**
	 * 负责实现获取前二十名用户
	 * @return
	 */
	public String userList(){
		System.out.println("Invoke:userList");		

		List<HappyKorea> userList=list();
		if(null == userList){
			
			HappyKorea temp=new HappyKorea();
			temp.setAuthor("暂时无数据");
			temp.setPostNumber("暂时无数据");
			temp.setPostNumber("暂时无数据");
			temp.setWebSiteName("暂时无数据");
			userList=new ArrayList<HappyKorea>();
			userList.add(temp);
		}	
		setRequestAttribute("userList", userList);	
		return SUCCESS;
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
