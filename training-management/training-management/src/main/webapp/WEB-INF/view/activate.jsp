<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>激活</title>
</head>
<body>
    <h2>首次注册会员，需要缴纳1000元才能激活，请输入银行卡号和密码交钱。</h2>
    
	<form:form method="POST" action="activate.do">
   <table>
    <tr>
        <td><form:label path="cardNumber">卡号：</form:label></td>
        <td><form:input path="cardNumber" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密码：</form:label></td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="点击即缴纳1000元入会费"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>