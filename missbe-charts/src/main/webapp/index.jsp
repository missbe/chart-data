<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("Login:" + basePath);
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> 
<html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Missbe-Login</title>
        <meta content="width=device-width, initial-scale=1,minimum-scale=1.0, maximum-scale=1, user-scalable=no" name="viewport">
 
        <meta name="description" content="missbe login" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="missbe" />
        <link rel="shortcut icon" href="favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="${basePath }static/login/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="${basePath }static/login/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }static/login/css/animate-custom.css" />
    </head>
    <body style="background:url(${basePath }static/login/images/background.png);
            width=auto;background-repeat:none;background-size:100% 100%;">
        <div class="container" >           
            
            <section>				
                <div id="container_demo" >                    
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="${basePath }signin.action"  method="post"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 你的用户名 </label>
                                    <input id="username" name="username" required="required" type="text"  style="font-size:14px;"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 你的密码 </label>
                                    <input id="password" name="userpass" required="required" type="password" style="font-size:14px;"/> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">保持登录状态</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>  
								<p style="color:red;">
								  <%String message=(String)request.getAttribute("message"); %>
								  <c:if test="<%= (null!=message) %>">
								     <%=message %>
								  </c:if>
								</p>                              
                            </form>
                        </div>                       
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>