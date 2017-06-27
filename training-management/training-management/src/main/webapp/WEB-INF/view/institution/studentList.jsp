<%@page import="com.zzzzzyx.training_management.model.StudyConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="studentList"
	type="java.util.List<com.zzzzzyx.training_management.model.StudyConnection>" scope="request"></jsp:useBean>
<jsp:useBean id="singleStudent" class="com.zzzzzyx.training_management.model.StudyConnection" scope="page"></jsp:useBean>

<jsp:useBean id="course" type="com.zzzzzyx.training_management.model.Course" scope="request"></jsp:useBean>
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="student list" /> 
</jsp:include>
<body>
<div class="col-md-4 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>课程“<%=course.getCourseName() %>”的学生列表</h2>
    <table class="table">
	<caption>学生列表</caption>
		<thead>
			<tr>
				<th>会员编号</th>
				<th>学生名</th>
				<th>成绩</th>
				<th>可用操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < studentList.size() ; i ++){
		        	pageContext.setAttribute("singleStudent", studentList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleStudent" property="user_id" /></td>
			<td><jsp:getProperty name="singleStudent" property="username" /></td>
			<td><jsp:getProperty name="singleStudent" property="mark" /></td>
			<td><a href="deleteStudent.do?connectionId=<%=studentList.get(i).getId()%>"><input type="button" class="btn btn-danger" value="退课"></a>
			<a href="registerMark.do?connectionId=<%=studentList.get(i).getId()%>"><input type="button" class="btn btn-primary" value="登记成绩"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	<a href="registerNonUser.do?courseId=<%=course.getId()%>"><input type="button" class="btn btn-warning" value="登记一位非会员"></a>
	</div>
</body>
</html>