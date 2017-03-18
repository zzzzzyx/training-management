<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="course"
	type="com.zzzzzyx.training_management.model.Course" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级</title>
</head>
<body>
    <h2>修改班级信息</h2>
	<form:form method="POST" action="change.do">
   <table>
    <tr>
        <td><form:label path="courseName">课程名：</form:label></td>
        <td><form:input path="courseName" value="<%=course.getCourseName()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="teacherName">教师名：</form:label></td>
        <td><form:input path="teacherName" value="<%=course.getTeacherName()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="price">价格：</form:label></td>
        <td><form:input path="price" value="<%=course.getPrice()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="startTime">开始时间：</form:label></td>
        <td><form:input path="startTime" value="<%=course.getStartTime()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="endTime">结束时间：</form:label></td>
        <td><form:input path="endTime" value="<%=course.getEndTime()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="course_status">课程状态：</form:label></td>
                <td><form:select path="course_status">
                        <form:option value="<%=course.getStatus()%>" label="请选择。。" />
                        <form:options items="${statusList}" />
                    </form:select></td>
    </tr>
    <tr>
        <td colspan="2">
       		<form:input type="hidden" path="course_id" value="${requestScope.courseId}"/>
            <input type="submit" value="申请修改"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>