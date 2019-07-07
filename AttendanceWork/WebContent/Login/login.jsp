<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0"> 
		<title>后台登录</title> 
		<link href="css/login.css" type="text/css" rel="stylesheet"> 
	</head> 
	
	<body> 
		<div class="login">
		    <div class="message">贝壳考勤-管理登录</div>
		    <div id="darkbannerwrap"></div>
		    <form action="/AttendanceWork/loginServlet" method="post">
				<input name="action" value="login" type="hidden">
				<input name="username" placeholder="用户名" required="" type="text">
				<hr class="hr15">
				<input name="password" placeholder="密码" required="" type="password">
				<hr class="hr15">
				<input value="登录" style="width:100%;" type="submit">
				<hr class="hr20">
			</form>
		</div>
		<div class="copyright">© 2016贝壳考勤 by ********</a></div>
	</body>
</html>