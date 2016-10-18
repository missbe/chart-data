package cn.missbe.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.app.HappyKorea_Activepersonnelrank;
import cn.missbe.app.Icnkr_Activepersonnelrank;
import cn.missbe.app.InckrUpdate;
import cn.missbe.model.HappyKorea;
import cn.missbe.model.Mail;
import cn.missbe.service.UserServiceI;
import cn.missbe.service.impl.UserServiceImpl;
import cn.missbe.util.EmailUtil;
import cn.missbe.util.PropertiesUtil;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final String mailFIleName="mail.properties";
	private String subject;
	private String message;
	/**
	 * 判断用户是否登录 
	 * @return 登录为true 否则为false
	 */
	private boolean isLogin(){
		return null!=ServletActionContext.getRequest().getSession().getAttribute("admin") 
				? true:false;
	}
	/**
	 * 	负责更新论坛数据库-相关活跃用户
	 */
	@Override
	public String execute(){
		System.out.println("Invoke:execute");
		//首先要登录 
		if(!isLogin()){
			return "login";
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				new HappyKorea_Activepersonnelrank().invokeUpdate();///进行更新EnjoyKorea论坛
				try {
					Thread.sleep(3600);
				} catch (InterruptedException e) {
					System.out.println("第一次睡眠线程被打断异常");
					e.printStackTrace();
				}
				new Icnkr_Activepersonnelrank().invokeUpdate();///进行更新Icnkr论坛
				try {
					Thread.sleep(3600);
				} catch (InterruptedException e) {
					System.out.println("第二次睡眠线程被打断异常");
					e.printStackTrace();
				}
				new cn.missbe.app.HappyKorea(30).invokeHappyKorea();
				try {
					Thread.sleep(3600);
				} catch (InterruptedException e) {
					System.out.println("第三次睡眠线程被打断异常");
					e.printStackTrace();
				}
				new InckrUpdate(30).invokeUpdate();
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
		//首先要登录 
		if(!isLogin()){
			return "login";
		}
		    	
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
	/**
	 * 进行邮件发送
	 * @return 返回提示信息是否成功
	 */
	public String sendMail(){
		// 首先要登录
		if (!isLogin()) {
			return "login";
		}
		Mail mail = new Mail();
		PropertiesUtil pro = new PropertiesUtil(mailFIleName);
		mail.setHost(pro.getValue("mail.host")); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender(pro.getValue("mail.sender"));
		mail.setReceiver(pro.getValue("mail.receiver")); // 接收人
		mail.setUsername(pro.getValue("mail.username")); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword(pro.getValue("mail.password")); // 发件人邮箱的登录密码
		if(null==subject){
			subject="^_^请输入邮件标题^_^";
		}
		if(null==message){
			message="^_^请输入邮件正文^_^";
		}
		mail.setSubject(subject);
		mail.setMessage(message);		
		
		boolean flag=new EmailUtil().send(mail);
		String message=flag?"^_^邮件发送成功，将会为您尽快处理^_^":"服务抽风了-请稍后再试!";
		setRequestAttribute("message", message);
		return SUCCESS;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
