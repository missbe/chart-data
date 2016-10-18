package cn.missbe.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.missbe.model.Mail;
import cn.missbe.util.EmailUtil;
import cn.missbe.util.PropertiesUtil;

public class MailSenderTest {
  @Test
  public void testSend(){
	  Mail mail = new Mail();  
	  PropertiesUtil pro=new PropertiesUtil("mail.properties");
//      mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
//      mail.setSender("love_tt_1208@163.com");  
//      mail.setReceiver("1195317565@qq.com"); // 接收人  
//      mail.setUsername("love_tt_1208@163.com"); // 登录账号,一般都是和邮箱名一样吧  
//      mail.setPassword("lovett1208.."); // 发件人邮箱的登录密码  
//      mail.setSubject("aaaaaaaaa");  
//      mail.setMessage("bbbbbbbbbbbbbbbbb");  
	    mail.setHost(pro.getValue("mail.host")); // 设置邮件服务器
        mail.setSender(pro.getValue("mail.sender"));  
        mail.setReceiver(pro.getValue("mail.receiver")); // 接收人  
        mail.setName(pro.getValue("mail.name"));
        mail.setUsername(pro.getValue("mail.username")); // 登录账号,一般都是和邮箱名一样吧  
        mail.setPassword(pro.getValue("mail.password")); // 发件人邮箱的登录密码  
        mail.setSubject("aaaaaaaaa");  
        mail.setMessage("bbbbbbbbbbbbbbbbb");  
      
        assertEquals(true,new EmailUtil().send(mail));
  }
}
