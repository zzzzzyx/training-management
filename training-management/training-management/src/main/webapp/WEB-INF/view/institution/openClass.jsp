<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>开设班级</title>
</head>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>开设班级</h2>
	<form:form method="POST" action="openClass.do">
   <table class="table">
    <tr>
        <td><form:label path="courseName">课程名：</form:label></td>
        <td><form:input class="form-control" path="courseName"/></td>
    </tr>
    <tr>
        <td><form:label path="teacherName">教师名：</form:label></td>
        <td><form:input class="form-control" path="teacherName"/></td>
    </tr>
    <tr>
        <td><form:label path="price">价格：</form:label></td>
        <td><form:input class="form-control" path="price" value=""/></td>
    </tr>
    <tr>
        <td><form:label path="startTime">开始时间：</form:label></td>
        <td><form:input class="form-control" path="startTime"/></td>
    </tr>
    <tr>
        <td><form:label path="endTime">结束时间：</form:label></td>
        <td><form:input class="form-control" path="endTime"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" class="btn btn-primary" value="开设"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>