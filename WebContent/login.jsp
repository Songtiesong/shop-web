<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";        
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/login.css" ></link>
  </head>
<body>
	<form action="LoginServlet" method="post">
				<div id="div_center">
 				<div id="div_inputbox">
 					<input type="text" id="adminName" name="adminName" />
 					<input type="password" id="password" name="password"/>
 					<div style="color: red;margin-top: 9px;">${msg }</div>
 				</div>
 				<input id="btn_img" type="image" src="images/bg_login_btn.jpg" />
 	 	 </div>
 	 	 </form>
</body>
</html>