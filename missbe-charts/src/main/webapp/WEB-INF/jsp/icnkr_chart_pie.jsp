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
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>饼状图</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" href="favicon.ico"> 
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
    <a href="${basePath}home.action" class="logo">
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
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-user"></i>
            <span>用户管理</span> 
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>			
          </a>
          <ul class="treeview-menu">           
            <li><a href="${basePath}modify.action"><i class="fa fa-circle-o"></i> 密码更改</a></li>            
            </li>
          </ul>
        </li>
       
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Korea</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}chartPie.action"><i class="fa fa-pie-chart"></i> 饼状图</a></li>
            <li><a href="${basePath}chartColumn.action"><i class="fa fa-bar-chart"></i> 柱形图</a></li>
            <li><a href="${basePath}chartLine.action"><i class="fa fa-line-chart"></i> 拆线图</a></li> 
            <li><a href="${basePath}koreaTotal.action"><i class="fa fa-line-chart"></i> 统计报表</a></li>           
          </ul>
        </li>
        <li class="treeview active">
			   <a href="#"> <i
						class="fa fa-pie-chart"></i> <span>Icnkr</span> <span
						class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="${basePath}IcnkrChartPie.action"><i
								class="fa fa-pie-chart"></i> 饼状图</a></li>
						<li><a href="${basePath}IcnkrColumn.action"><i
								class="fa fa-bar-chart"></i> 柱形图</a></li>
						<li><a href="${basePath}IcnkrChartLine.action"><i
								class="fa fa-line-chart"></i> 拆线图</a></li>
						<li><a href="${basePath}icnkrTotal.action">
						   <i class="fa fa-line-chart"></i> 统计报表</a></li>
					</ul>
			   </li>
         <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>报表更新</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${basePath}list.action"><i class="fa fa-circle-o"></i> 重新抓取数据</a></li>                     
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
            <li><a href="${basePath}email.action"><i class="fa  fa-paper-plane-o"></i> 邮箱联系</a></li>                 
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
         Icnkr--饼状图统计相关信息
      </h1> 
      <ol class="breadcrumb">
        <li><a href="${basePath}index">
        <i class="fa fa-dashboard"></i>主页</a></li>        
        <li class="active">饼状图</li>
      </ol>	  
    </section>			
	<!-- Main content -->
    <section class="content">     
      <!-- Default box -->
      <iframe id="mainiframe"  width="100%" height="720px"
         frameborder="0" scrolling="no" marginwidth="0" marginheight="0"         
         src="${basePath }ReportServer?reportlet=icnkr-chart-pie.cpt">
      </iframe>	  
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
