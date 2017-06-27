<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="login" /> 
</jsp:include>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
<h2>登录</h2>
	<form:form method="POST" action="login.do">
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
        <td>
            <input type="submit" class="btn btn-primary" name="type" value="登录"/>
            
			<a href="register.do"><input type="button" class="btn btn-warning" value="注册"></a>
        </td>
        <td>
        	<input type="submit" class="btn btn-danger" name="type" value=">后台登录<"/>
        	<a href="illustration.do"><input type="button" class="btn btn-info pull-right" value="查看说明"></a>
        </td>
    </tr>
    
</table>  
</form:form>
</div>
</body>
</html>