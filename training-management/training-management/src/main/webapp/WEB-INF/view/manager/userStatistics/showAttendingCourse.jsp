<%@page import="com.zzzzzyx.training_management.vo.Course4UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:useBean id="attendingCourseList"
	type="java.util.List<com.zzzzzyx.training_management.vo.Course4UserVO>" scope="request"></jsp:useBean>
<jsp:useBean id="singleAttendingCourse" class="com.zzzzzyx.training_management.vo.Course4UserVO" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>此学员已参加的课程</title>
</head>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
	<h1>此学员已参加的课程</h1>
	
	<table class="table">
	<caption>已参加的课程</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>课程状态</th>
				<th>是否完成课程</th>
				<th>成绩</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < attendingCourseList.size() ; i ++){
		        	pageContext.setAttribute("singleAttendingCourse", attendingCourseList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleAttendingCourse" property="courseName" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="teacherName" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="status" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="finished" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="mark" /></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	</div>
</body>
</html>