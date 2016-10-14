package cn.missbe.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.model.User;
/**
 * 负责将JSP页面和Action进行转化
 * @author Administrator
 *
 */
public class Conversion extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("admin");
		
		if(null != user){			
			System.out.println("测试session:"+user.getUsername());
			return SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("message", "^_^你还未登录或者会话过期^_^");
			return "login";
		}		
	}
//	public String koreatUpdate(){
//		new HappyKorea_Activepersonnelrank().invokeUpdate();
//		return SUCCESS;
//	}
//	public String icnkrtUpdate(){
//		new HappyKorea_Activepersonnelrank().invokeUpdate();
//		return SUCCESS;
//	}

}
