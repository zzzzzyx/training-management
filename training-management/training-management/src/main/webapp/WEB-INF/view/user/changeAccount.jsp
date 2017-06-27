<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="change account" /> 
</jsp:include>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>更改银行卡绑定</h2>
    
	<form:form method="POST" action="changeBankAccount.do">
   <table class="table">
    <tr>
        <td><form:label path="cardNumber">卡号：</form:label></td>
        <td><form:input class="form-control" path="cardNumber" /></td>
    </tr>
    <tr>
        <td><form:label path="password">密码：</form:label></td>
        <td><form:password class="form-control" path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" class="btn btn-primary pull-left" value="更改"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>