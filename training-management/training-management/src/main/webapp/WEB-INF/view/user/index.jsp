<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="courseList"
	type="java.util.List<com.zzzzzyx.training_management.model.Course>" scope="request"></jsp:useBean>
<jsp:useBean id="singleCourse" class="com.zzzzzyx.training_management.model.Course" scope="page"></jsp:useBean>

<jsp:useBean id="attendingCourseList"
	type="java.util.List<com.zzzzzyx.training_management.model.Course>" scope="request"></jsp:useBean>
<jsp:useBean id="singleAttendingCourse" class="com.zzzzzyx.training_management.model.Course" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员首页</title>
</head>
<body>
	<h1>学员首页</h1>
	<table border="1">
	<caption>可参加的尚未开课的课程</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>价格</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>开设机构id</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < courseList.size() ; i ++){
		        	pageContext.setAttribute("singleCourse", courseList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleCourse" property="courseName" /></td>
			<td><jsp:getProperty name="singleCourse" property="teacherName" /></td>
			<td><jsp:getProperty name="singleCourse" property="price" /></td>
			<td><jsp:getProperty name="singleCourse" property="startTime" /></td>
			<td><jsp:getProperty name="singleCourse" property="endTime" /></td>
			<td><jsp:getProperty name="singleCourse" property="institution_id" /></td>
			<td><a href="attend.do?courseId=<%=courseList.get(i).getId()%>"><input type="button" value="预定"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	
	<table border="1">
	<caption>已参加的课程</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>价格</th>
				<th>课程状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < attendingCourseList.size() ; i ++){
		        	pageContext.setAttribute("singleAttendingCourse", attendingCourseList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleAttendingCourse" property="courseName" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="teacherName" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="price" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="status" /></td>
			<td><a href="cancel.do?courseId=<%=attendingCourseList.get(i).getId()%>"><input type="button" value="退订/退课"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	<a href="changeBankAccount.do"><input type="button" value="修改银行卡绑定"></a>
	<a href="showCardLevel.do"><input type="button" value="查看会员卡级别"></a>
	<a href="withdraw.do"><input type="button" value="取消会员资格"></a>
	
</body>
</html>