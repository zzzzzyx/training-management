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
<title>注册</title>
</head>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <div class="col-md-3"><h2>注册</h2></div>
	<form:form method="POST" action="register.do">
   <table class="table">
    <tr>
        <td><form:label path="username">用户名：</form:label></td>
        <td><form:input class="form-control" path="username" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密码：</form:label></td>
        <td><form:password class="form-control" path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="password">注册类别：</form:label></td>
        <td><form:radiobutton path="userKind" value="User" label="学员" />
<form:radiobutton path="userKind" value="Institution" label="机构" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" class="btn btn-primary pull-left" value="提交"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>