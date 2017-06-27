<%@page import="com.zzzzzyx.training_management.model.Authentication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="activationLogList"
	type="java.util.List<com.zzzzzyx.training_management.model.log.ConsumeLog>"
	scope="request"></jsp:useBean>
<jsp:useBean id="singleActivationLog"
	class="com.zzzzzyx.training_management.model.log.ConsumeLog"
	scope="page"></jsp:useBean>
	
<jsp:useBean id="attendLogList"
	type="java.util.List<com.zzzzzyx.training_management.model.log.ConsumeLog>"
	scope="request"></jsp:useBean>
<jsp:useBean id="singleAttendLog"
	class="com.zzzzzyx.training_management.model.log.ConsumeLog"
	scope="page"></jsp:useBean>
	
<jsp:useBean id="refundLogList"
	type="java.util.List<com.zzzzzyx.training_management.model.log.ConsumeLog>"
	scope="request"></jsp:useBean>
<jsp:useBean id="singleRefundLog"
	class="com.zzzzzyx.training_management.model.log.ConsumeLog"
	scope="page"></jsp:useBean>

<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="Finace Statistics" /> 
</jsp:include>
<body>
<div class="col-md-6 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;">
	<h1>学院财务统计</h1>
	<table class="table">
		<caption>用户激活缴费记录（每次1000元）</caption>
		<thead>
			<tr>
				<th>用户id</th>
				<th>时间</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>总计缴纳人次</td>
				<td><%=activationLogList.size()%>次</td>
			</tr>
			<tr>
				<td>此项总计收入</td>
				<td><%=1000*activationLogList.size()%>元</td>
			</tr>
		</tfoot>
		<tbody>
			<%
				for (int i = 0; i < activationLogList.size(); i++) {
					pageContext.setAttribute("singleActivationLog", activationLogList.get(i));
			%>
			<tr>
				<td><jsp:getProperty name="singleActivationLog"
						property="user_id" /></td>
				<td><jsp:getProperty name="singleActivationLog" property="time" /></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	
	<table class="table">
		<caption>用户参加课程缴费记录</caption>
		<thead>
			<tr>
				<th>用户id</th>
				<th>开设机构id</th>
				<th>课程id</th>
				<th>缴纳额</th>
				<th>时间</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>总计缴纳人次</td>
				<td><%=attendLogList.size()%>次</td>
			</tr>
			<tr>
				<td>此项总计收入</td>
				<td><%
						int courseIncome = 0;
						for (int i = 0; i < attendLogList.size(); i++) {
							courseIncome += attendLogList.get(i).getMoney();
						}
						out.println(courseIncome);
					%>
				元</td>
			</tr>
		</tfoot>
		<tbody>
			<%
				for (int i = 0; i < attendLogList.size(); i++) {
					pageContext.setAttribute("singleAttendLog", attendLogList.get(i));
			%>
			<tr>
				<td><jsp:getProperty name="singleAttendLog" property="user_id" /></td>
				<td><jsp:getProperty name="singleAttendLog" property="ins_id" /></td>
				<td><jsp:getProperty name="singleAttendLog" property="course_id" /></td>
				<td><jsp:getProperty name="singleAttendLog" property="money" /></td>
				<td><jsp:getProperty name="singleAttendLog" property="time" /></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	
	<table class="table">
		<caption>用户退出课程退款记录</caption>
		<thead>
			<tr>
				<th>用户id</th>
				<th>开设机构id</th>
				<th>课程id</th>
				<th>退款额</th>
				<th>时间</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>总计退款人次</td>
				<td><%=refundLogList.size()%>次</td>
			</tr>
			<tr>
				<td>此项总计损失</td>
				<td><%
						int courseOutcome = 0;
						for (int i = 0; i < refundLogList.size(); i++) {
							courseOutcome += refundLogList.get(i).getMoney();
						}
						out.println(courseOutcome);
					%>
				元</td>
			</tr>
		</tfoot>
		<tbody>
			<%
				for (int i = 0; i < refundLogList.size(); i++) {
					pageContext.setAttribute("singleRefundLog", refundLogList.get(i));
			%>
			<tr>
				<td><jsp:getProperty name="singleRefundLog" property="user_id" /></td>
				<td><jsp:getProperty name="singleRefundLog" property="ins_id" /></td>
				<td><jsp:getProperty name="singleRefundLog" property="course_id" /></td>
				<td><jsp:getProperty name="singleRefundLog" property="money" /></td>
				<td><jsp:getProperty name="singleRefundLog" property="time" /></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
	<p>总共收入为：<%=1000*activationLogList.size()%> + <%=courseIncome%> + <%=courseOutcome %> = <%=courseIncome + 1000*activationLogList.size() - courseOutcome %></p>
</div>
</body>
</html>