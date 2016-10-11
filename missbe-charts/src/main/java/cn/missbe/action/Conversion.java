package cn.missbe.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.model.User;

public class Conversion extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute(){
		User user=(User)ServletActionContext.getRequest().getSession().getAttribute("admin");
		if(null != user)
		  return SUCCESS;
		return "login";
	}

}
