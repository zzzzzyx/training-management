<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="course"
	type="com.zzzzzyx.training_management.model.Course" scope="request"></jsp:useBean>
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="change class" /> 
</jsp:include>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>修改班级信息</h2>
	<form:form method="POST" action="change.do">
   <table class="table">
    <tr>
        <td><form:label path="courseName">课程名：</form:label></td>
        <td><form:input path="courseName" class="form-control" value="<%=course.getCourseName()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="teacherName">教师名：</form:label></td>
        <td><form:input path="teacherName" class="form-control" value="<%=course.getTeacherName()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="price">价格：</form:label></td>
        <td><form:input path="price" class="form-control" value="<%=course.getPrice()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="startTime">开始时间：</form:label></td>
        <td><form:input path="startTime" class="form-control" value="<%=course.getStartTime()%>"/></td>
    </tr>
    <tr>
        <td><form:label path="endTime">结束时间：</form:label></td>
        <td><form:input path="endTime" class="form-control" value="<%=course.getEndTime()%>"/></td>
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
            <input type="submit" class="btn btn-primary" value="申请修改"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>