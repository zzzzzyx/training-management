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
<title>登记成绩</title>
</head>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>登记成绩</h2>
	<form:form method="POST" action="registerNonUser.do">
   <table class="table">
    <tr>
        <td><form:label path="username">用户名为:</form:label></td>
        <td><form:input class="form-control" path="username" /></td>
    </tr>
        <tr>
        <td colspan="2">
        <form:input type="hidden" path="course_id" value="${requestScope.courseId}"/>
            <input type="submit" class="btn btn-primary" value="提交"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>