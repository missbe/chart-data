<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<%        
 Properties props = System.getProperties();
        String version= props.getProperty("java.version");
        String vendor= props.getProperty("java.vendor");
        String url= props.getProperty("java.vendor.url");
        String home= props.getProperty("java.home");
        String vmVersion= props.getProperty("java.vm.specification.version");        
        String vmSpecific= props.getProperty("java.vm.specification.name");      
        String vmName= props.getProperty("java.vm.name");        
        String javaVersion= props.getProperty("java.class.version");        
        String osName= props.getProperty("os.name");
        String arch= props.getProperty("os.arch");
        String osVersion= props.getProperty("os.version");
        
%>
</head>
<body>
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

</body>
</html>