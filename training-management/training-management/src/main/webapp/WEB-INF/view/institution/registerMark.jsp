<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="register mark" /> 
</jsp:include>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
    <h2>登记成绩</h2>
	<form:form method="POST" action="registerMark.do">
   <table class="table">
    <tr>
        <td><form:label path="mark">成绩为：</form:label></td>
        <td><form:input class="form-control" path="mark" /></td>
    </tr>
        <tr>
        <td colspan="2">
        <form:input type="hidden" path="id" value="${requestScope.connectionId}"/>
            <input type="submit" class="btn btn-primary" value="提交"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>