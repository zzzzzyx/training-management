<%@page import="com.zzzzzyx.training_management.model.Authentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="userList"
	type="java.util.List<com.zzzzzyx.training_management.vo.UserVO>" scope="request"></jsp:useBean>
<jsp:useBean id="singleUser" class="com.zzzzzyx.training_management.vo.UserVO" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>用户统计</title>
</head>
<body>
<div class="col-md-6 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
	<h1>用户统计</h1>
	<table class="table">
	<caption>用户列表</caption>
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名</th>
				<th>账户积分</th>
				<th>上次激活距今天数</th>
				<th>参与课程数</th>
				<th>完成课程数</th>
				<th>平均分（若无则为-1）</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < userList.size() ; i ++){
		        	pageContext.setAttribute("singleUser", userList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleUser" property="id" /></td>
			<td><jsp:getProperty name="singleUser" property="name" /></td>
			<td><jsp:getProperty name="singleUser" property="point" /></td>
			<td><jsp:getProperty name="singleUser" property="lastActivationTillToday" /></td>
			<td><jsp:getProperty name="singleUser" property="attendedCourseCount" /></td>
			<td><jsp:getProperty name="singleUser" property="finishedCourseCount" /></td>
			<td><jsp:getProperty name="singleUser" property="averageMark" /></td>
			<td><a href="showAttendingCourse.do?userId=<%=userList.get(i).getId()%>"><input type="button" class="btn btn-info" value="查看已参加课程列表"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	</div>
</body>
</html>