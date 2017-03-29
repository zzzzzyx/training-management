<%@page import="com.zzzzzyx.training_management.model.Authentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="insList"
	type="java.util.List<com.zzzzzyx.training_management.vo.InstitutionVO>" scope="request"></jsp:useBean>
<jsp:useBean id="singleIns" class="com.zzzzzyx.training_management.vo.InstitutionVO" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>机构统计</title>
</head>
<body>
<div class="col-md-5 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
	<h1>机构统计</h1>
	<table class="table">
	<caption>机构列表</caption>
		<thead>
			<tr>
				<th>机构id</th>
				<th>机构名</th>
				<th>开设课程数</th>
				<th>累计上课人次</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < insList.size() ; i ++){
		        	pageContext.setAttribute("singleIns", insList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleIns" property="id" /></td>
			<td><jsp:getProperty name="singleIns" property="name" /></td>
			<td><jsp:getProperty name="singleIns" property="courseCount" /></td>
			<td><jsp:getProperty name="singleIns" property="studyConnectionCount" /></td>
			<td><a href="showCourse.do?insId=<%=insList.get(i).getId()%>"><input type="button" class="btn btn-primary" value="查看课程列表"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	</div>
</body>
</html>