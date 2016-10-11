<%@page import="cn.missbe.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("Login:" + basePath);
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Missbe-data</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${basePath}/static/adminLte/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${basePath}/static/adminLte/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${basePath}/static/adminLte/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<!-- ADD THE CLASS sidedar-collapse TO HIDE THE SIDEBAR PRIOR TO LOADING THE SITE -->
<body class="hold-transition skin-black  sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="${basePath}/WEB-INF/jsp/index.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>M</b>e</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Miss</b>be</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
           <nav class="navbar navbar-static-top">
              <!-- Sidebar toggle button-->
              <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                 <span class="sr-only">Toggle navigation</span>
              </a>
              <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">        
          
          <li class="user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${basePath}static/adminLte/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                      
            </a>            
          </li>  
          <li class="user user-menu pull-right">
            <a href="${basePath}index.action" class="btn btn-lg btnapp">退出</a>
          </li>
          <li></li>
          <li></li>
        </ul>
      </div>
      </nav>
  </header>

  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${basePath}static/adminLte/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Admin</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        
        <li class="treeview active">
          <a href="#">
            <i class="fa fa-user"></i>
            <span>用户管理</span> 
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>			
          </a>
          <ul class="treeview-menu">           
            <li><a href="${basePath}modify"><i class="fa fa-circle-o"></i> 密码更改</a></li>            
            </li>
          </ul>
        </li>
       
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>报表管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}chartPie"><i class="fa fa-pie-chart"></i> 饼状图</a></li>
            <li><a href="${basePath}chartColumn"><i class="fa fa-bar-chart"></i> 柱形图</a></li>
            <li><a href="${basePath}chartLine"><i class="fa fa-line-chart"></i> 拆线图</a></li>            
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>报表相关设置</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> General</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Icons</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Buttons</a></li>            
          </ul>
        </li>
       
        <li class="treeview">
          <a href="#">
            <i class="fa fa-envelope"></i> <span>联系我们</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}email"><i class="fa  fa-paper-plane-o"></i> 邮箱联系</a></li>                 
          </ul>
        </li>        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        系统相关信息
        <small>操作系统等相关信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>        
      </ol>
    </section>
			<%
				Properties props = System.getProperties();
				String version = props.getProperty("java.version");
				String vendor = props.getProperty("java.vendor");
				String url = props.getProperty("java.vendor.url");
				String home = props.getProperty("java.home");
				String vmVersion = props.getProperty("java.vm.specification.version");
				String vmSpecific = props.getProperty("java.vm.specification.name");
				String vmName = props.getProperty("java.vm.name");
				String javaVersion = props.getProperty("java.class.version");
				String osName = props.getProperty("os.name");
				String arch = props.getProperty("os.arch");
				String osVersion = props.getProperty("os.version");
			%>
	<!-- Main content -->
    <section class="content">
      <div class="callout callout-info">
        <%  User user=(User)session.getAttribute("admin"); 
            System.out.println("index:"+user.getUpdate_time()+user.getUsername());
        %>
        <c:if test="<%=user!=null%>">
        <h3>欢迎管理员：<b style="font-size:24px;"><%=user.getUsername() %></b> 再次登录^_^</h3>
            <h5>你上次登录时间:&nbsp;&nbsp;<b><%=user.getUpdate_time() %></b></h5>            
        </c:if>        
      </div>
      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">系统相关信息</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>            
          </div>
        </div>
        <div class="box-body">
          <p>操作系统的名称： <%=osName %> </p>
          <p>操作系统的构架： <%=arch %> </p>
          <p>操作系统的版本： <%=osVersion %> </p>  
          <p>Java的运行环境版本： <%=version %> </p>
          <p>Java的运行环境供应商： <%=vendor %> </p>
          <p>Java供应商的URL： <%=url %> </p>
          <p>Java的安装路径：<%=home %> </p>
          <p>Java的虚拟机规范版本： <%=vmVersion %> </p>
          <p>Java的虚拟机规范名称： <%=vmSpecific %> </p>
          <p>Java的虚拟机实现名称： <%=vmName %> </p>
          <p>Java的类格式版本号： <%=javaVersion %> </p>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
                   ----操作系统相关信息
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.6
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://www.missbe.cn">Miss-be</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <!--delete -->
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="${basePath}/static/adminLte/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${basePath}/static/adminLte/bootstrap/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${basePath}/static/adminLte/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${basePath}/static/adminLte/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/static/adminLte/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${basePath}/static/adminLte/dist/js/demo.js"></script>
</body>
</html>
