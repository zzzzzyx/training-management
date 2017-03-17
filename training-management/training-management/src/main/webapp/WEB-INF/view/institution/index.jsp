<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="courseList"
	type="java.util.List<com.zzzzzyx.training_management.model.Course>" scope="request"></jsp:useBean>
<jsp:useBean id="singleCourse" class="com.zzzzzyx.training_management.model.Course" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
    <h2>机构首页</h2>
    <a href="openClass.do"><input type="button" value="开设班级"></a>
    <table border="1">
	<caption>已开设的课程</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>价格</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>状态</th>
				<th>可用操作</th>
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
			<td><jsp:getProperty name="singleCourse" property="status" /></td>
			<td><a href="change.do?courseId=<%=courseList.get(i).getId()%>"><input type="button" value="修改"></a>
			<a href="delete.do?courseId=<%=courseList.get(i).getId()%>"><input type="button" value="删除"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
</body>
</html>