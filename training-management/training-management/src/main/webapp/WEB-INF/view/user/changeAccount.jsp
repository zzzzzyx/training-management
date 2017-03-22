<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改银行卡绑定</title>
</head>
<body>
    <h2>更改银行卡绑定</h2>
    
	<form:form method="POST" action="changeBankAccount.do">
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
            <input type="submit" value="更改"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>