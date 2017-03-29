<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="courseList"
	type="java.util.List<com.zzzzzyx.training_management.model.Course>" scope="request"></jsp:useBean>
<jsp:useBean id="singleCourse" class="com.zzzzzyx.training_management.model.Course" scope="page"></jsp:useBean>

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
<title>学员首页</title>
</head>
<body>
<div class="col-md-6 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;
    padding-top : 5em;">
	<h1>学员首页</h1>
	<table class="table">
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
			<td><a href="attend.do?courseId=<%=courseList.get(i).getId()%>"><input type="button" class="btn btn-success" value="预定"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	
	<table class="table">
	<caption>已参加的课程</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>价格</th>
				<th>课程状态</th>
				<th>是否完成课程</th>
				<th>成绩</th>
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
			<td><jsp:getProperty name="singleAttendingCourse" property="finished" /></td>
			<td><jsp:getProperty name="singleAttendingCourse" property="mark" /></td>
			<td><a href="cancel.do?courseId=<%=attendingCourseList.get(i).getId()%>"><input type="button" class="btn btn-danger" value="退订/退课"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	<a href="changeBankAccount.do"><input type="button" class="btn btn-default" value="修改银行卡绑定"></a>
	<a href="showCardLevel.do"><input type="button" class="btn btn-default" value="查看会员卡积分"></a>
	<a href="showStatistics.do"><input type="button" class="btn btn-default" value="查看统计信息"></a>
	<a href="withdraw.do"><input type="button" class="btn btn-default" value="取消会员资格"></a>
</div>
</body>
</html>