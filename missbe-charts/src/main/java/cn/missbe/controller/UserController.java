package cn.missbe.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.missbe.service.UserService;

@Controller
public class UserController {
	
	@Resource(name="userService")
    private UserService userService;
    
//    public UserService getUserService() {
//    	System.out.println("UserController-getUserService");
//		return userService;
//	}
//
//	public void setUserService(UserService userService) {
//		System.out.println("UserController-setUserService");
//		this.userService = userService;
//	}

	@RequestMapping(value = "/login")
    public String login(Model model,@RequestParam("username")String username, 
    		                 @RequestParam("password") String password) {
		System.out.println(username+":"+password);
    	 boolean flag=true;
//    	 flag=userService.isExist(username, password);
    	 
    	 if(flag){
    		 return "index";
    	 }
//    	 if(username.equals("root") && password.equals("root")){
//             model.addAttribute("message", username+"+"+password);
//         }else{
//        	 model.addAttribute("message", "是否能够实现，这是一个测试");
//         }    	
        return "login";
    }    
   
}
