<%@page import="com.zzzzzyx.training_management.model.log.StudyLog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="logList"
	type="java.util.List<com.zzzzzyx.training_management.model.log.StudyLog>" scope="request"></jsp:useBean>
<jsp:useBean id="singleLog" class="com.zzzzzyx.training_management.model.log.StudyLog" scope="page"></jsp:useBean>

<jsp:useBean id="consumeLogList"
	type="java.util.List<com.zzzzzyx.training_management.model.log.ConsumeLog>" scope="request"></jsp:useBean>
<jsp:useBean id="singleConsumneLog" class="com.zzzzzyx.training_management.model.log.ConsumeLog" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>我的统计信息</title>
</head>
<body>
<div class="col-md-6 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
	<h1>统计信息</h1>
	<table  class="table">
	<caption>预定/退订/退课/学习记录</caption>
		<thead>
			<tr>
				<th>操作</th>
				<th>课程id</th>
				<th>学员id</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < logList.size() ; i ++){
		        	pageContext.setAttribute("singleLog", logList.get(i));
		        %>
		<tr>
			<td><%=logList.get(i).getTitle()%></td>
			<td><jsp:getProperty name="singleLog" property="course_id" /></td>
			<td><jsp:getProperty name="singleLog" property="user_id" /></td>
			<td><jsp:getProperty name="singleLog" property="time" /></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
		<table class="table">
	<caption>财务记录</caption>
		<thead>
			<tr>
				<th>类型</th>
				<th>课程id</th>
				<th>学员id</th>
				<th>金额</th>
				<th>时间</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < consumeLogList.size() ; i ++){
		        	pageContext.setAttribute("singleConsumneLog", consumeLogList.get(i));
		        %>
		<tr>
			<td><%=consumeLogList.get(i).getTitle()%></td>
			<td><jsp:getProperty name="singleConsumneLog" property="course_id" /></td>
			<td><jsp:getProperty name="singleConsumneLog" property="user_id" /></td>
			<td><jsp:getProperty name="singleConsumneLog" property="money" /></td>
			<td><jsp:getProperty name="singleConsumneLog" property="time" /></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	</div>
</body>
</html>