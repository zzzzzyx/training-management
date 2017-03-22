<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="classChangeList"
	type="java.util.List<com.zzzzzyx.training_management.model.ClassChange>" scope="request"></jsp:useBean>
<jsp:useBean id="singleClassChange" class="com.zzzzzyx.training_management.model.ClassChange" scope="page"></jsp:useBean>

<jsp:useBean id="waitingPaymentList"
	type="java.util.List<com.zzzzzyx.training_management.model.WaitingPayment>" scope="request"></jsp:useBean>
<jsp:useBean id="singleWaitingPayment" class="com.zzzzzyx.training_management.model.WaitingPayment" scope="page"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>经理首页</title>
</head>
<body>
	<h1>经理首页</h1>
	<table border="1">
	<caption>待审核的课程变动</caption>
		<thead>
			<tr>
				<th>课程名</th>
				<th>教师名</th>
				<th>价格</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>课程状态</th>
				<th>机构id</th>
				<th>描述</th>
				<th>变动类别</th>
				<th>可选操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < classChangeList.size() ; i ++){
		        	pageContext.setAttribute("singleClassChange", classChangeList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleClassChange" property="courseName" /></td>
			<td><jsp:getProperty name="singleClassChange" property="teacherName" /></td>
			<td><jsp:getProperty name="singleClassChange" property="price" /></td>
			<td><jsp:getProperty name="singleClassChange" property="startTime" /></td>
			<td><jsp:getProperty name="singleClassChange" property="endTime" /></td>
			<td><jsp:getProperty name="singleClassChange" property="course_status" /></td>
			<td><jsp:getProperty name="singleClassChange" property="institution_id" /></td>
			<td><jsp:getProperty name="singleClassChange" property="description" /></td>
			<td><jsp:getProperty name="singleClassChange" property="changeKind" /></td>
			<td><a href="allow.do?changeId=<%=classChangeList.get(i).getId()%>"><input type="button" value="同意"></a>
			<a href="deny.do?changeId=<%=classChangeList.get(i).getId()%>"><input type="button" value="拒绝"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	
	<table border="1">
	<caption>待结算的资金流动</caption>
		<thead>
			<tr>
				<th>源账户</th>
				<th>目的账户</th>
				<th>流动金额</th>
				<th>流动描述</th>
				<th>可选操作</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0 ; i < waitingPaymentList.size() ; i ++){
		        	pageContext.setAttribute("singleWaitingPayment", waitingPaymentList.get(i));
		        %>
		<tr>
			<td><jsp:getProperty name="singleWaitingPayment" property="fromCardNumber" /></td>
			<td><jsp:getProperty name="singleWaitingPayment" property="toCardNumber" /></td>
			<td><jsp:getProperty name="singleWaitingPayment" property="money" /></td>
			<td><jsp:getProperty name="singleWaitingPayment" property="description" /></td>
			<td><a href="solve.do?paymentId=<%=waitingPaymentList.get(i).getId()%>"><input type="button" value="结算"></a></td>
		</tr>
		<% } %>
			
		</tbody>
	</table>
	
	
</body>
</html>