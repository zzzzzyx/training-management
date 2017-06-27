<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="point"
	type="java.lang.Long" scope="request"></jsp:useBean>

<jsp:include page="/WEB-INF/layout/header.jsp">
  <jsp:param name="title" value="My card" /> 
</jsp:include>
<body>
<div class="col-md-3 center"  style="
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;padding-top : 5em;">
	<h2>您的积分信息</h2>
	<table class="table">
    <tr>
        <td>您当前的积分值：</td>
        <td><%=point%></td>
    </tr>
    <tr>
        <td>享受优惠幅度为：</td>
        <td><%
        if(point < 100)
        	out.println("无优惠");
        else if(point < 1000)
        	out.println("95折优惠");
        else
        	out.println("9折优惠");
        %></td>
    </tr>
    
</table>  
<a href="pointToCash.do"><input type="button" class="btn btn-primary" value="将积分全部换成银行卡内现金"></a>
<div style="padding : 2em 0px;"><p>注：积分（达到100可享受95折优惠，达到1000可享受9折优惠，也可直接兑换现金：每2积分兑换1块钱（向下取整）），且每消费10元获得1积分</p>
</div></div>
</body>
</html>