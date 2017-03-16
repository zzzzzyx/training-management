<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
    <h2>登录</h2>
	<form:form method="POST" action="login.do">
   <table>
    <tr>
        <td><form:label path="username">用户名：</form:label></td>
        <td><form:input path="username" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密码：</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="登录"/>
        </td>
        <td>
        	<a href="register.do"><input type="button" value="注册"></a>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>