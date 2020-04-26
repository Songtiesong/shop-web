<%@ page language="java" import="java.util.*,com.beans.*,com.dao.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="js/jquery.easing.js"></script>
	<script type="text/javascript" src="js/jquery.accordion.js"></script>		
	<script type="text/javascript">
	$(function(){
		$('#navigation').accordion({
			active:1,   /* 第三个被激活 */
			header: '.head',
			/*navigation1: false,  */
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'   /*slide,bounceslide ,bounceslide,easeslide'*/
		});
	});
	</script>
	<link rel="stylesheet" type="text/css" href="css/menu.css">
  </head>
<body>
	<% 
	MenuDao dao=new MenuDao();
	List<MenuInfo> menuList= dao.getMenuList(0);
	request.setAttribute("menuList", menuList);
	%>
<ul id="navigation">
	 	 		 <c:forEach var="menu" items="${menuList }">
	 	 		<li>
	 	 		  <a class="head">${menu.menuName }</a>
	 	 		  <ul>
	 	 		  	<li>
		 	 		  	<c:forEach var="m_sub" items="${menu.subMenulist }">
		 	 		  		<a href="${m_sub.url }" target="${m_sub.target }"><img src="images/${m_sub.icon }" /><label>${m_sub.menuName }</label></a>
		 	 		  	</c:forEach>
	 	 		  	</li>
	 	 		  
	 	 		  </ul>
	 	 		</li>
	 	 		</c:forEach>
	 	 						
			    <li> <a class="head">网站前台</a>
			      <ul>
			        <li><a href="http://localhost:8080/shop" target="_blank"><img src="images/main_50.gif" /><label>网站前台</label></a></li>
			      </ul>
			    </li>
			    
	 	 	</ul>			  
</body>
</html>