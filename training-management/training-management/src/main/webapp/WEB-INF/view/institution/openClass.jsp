<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="open class" /> 
</jsp:include>
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