<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="registerStudentNum"
	type="java.util.List<com.zzzzzyx.training_management.model.globalData.ins.user.RegisterStudentNum>"
	scope="request"></jsp:useBean>
<jsp:useBean id="registerCourseNum"
	type="java.util.List<com.zzzzzyx.training_management.model.globalData.ins.user.RegisterCourseNum>"
	scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>管理员后台数据查看</title>

<!-- Bootstrap Core CSS -->
<link href="/training-management/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/training-management/css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/training-management/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="/training-management/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">培训学院管理系统 - 后台统计数据</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> ins2 <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav" style="height: 705px;">
					<li class="active"><a href="index.do"><i
							class="fa fa-fw fa-dashboard"></i> 学员统计</a></li>
					<li><a href="income.do"><i class="fa fa-fw fa-bar-chart-o"></i>
							收入分析</a></li>
							<li><a href="customer.do"><i class="fa fa-fw fa-table"></i> 客户分析</a>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							学员统计<small> 直观观测机构运营情况</small>
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> 选课学员统计
								</h3>
							</div>
							<div id="chart1" class="panel-body" style="height: 400px">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> 开设课程数统计
								</h3>
							</div>
							<div id="chart0" class="panel-body" style="height: 400px">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="/training-management/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/training-management/js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="/training-management/js/plugins/morris/raphael.min.js"></script>
	<script src="/training-management/js/plugins/morris/morris.min.js"></script>
	<script src="/training-management/js/plugins/morris/morris-data.js"></script>
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});
		// 使用
		require(
				[ 'echarts', 'echarts/chart/line', 'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
				],
				function(ec) {
					// 基于准备好的dom，初始化echarts图表
					var myChart = ec.init(document.getElementById('chart1'));

					var option = {
						title : {
							text : '月选课量统计'
						},
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ '月选课量' ]
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								dataZoom : {
									show : true
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						dataZoom : {
							show : true,
							realtime : true,
							start : 0,
							end : 100
						},
						calculable : true,
						xAxis : [ {
							type : 'category',
							boundaryGap : false,
							data : [
	<%for (int i = 0; i < registerStudentNum.size() - 1; i++) {
				out.println("'" + registerStudentNum.get(i).getMonth() + "',");
			}
			out.println("'" + registerStudentNum.get(registerStudentNum.size() - 1).getMonth() + "'");%>
		]
						} ],
						yAxis : [ {
							type : 'value',
							axisLabel : {
								formatter : '{value} 人'
							}
						} ],
						series : [ {
							name : '月选课量',
							type : 'line',
							data : [
	<%for (int i = 0; i < registerStudentNum.size() - 1; i++) {
				out.println("'" + registerStudentNum.get(i).getNum() + "',");
			}
			out.println("'" + registerStudentNum.get(registerStudentNum.size() - 1).getNum() + "'");%>
		],
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								} ]
							}
						} ]
					};

					// 为echarts对象加载数据 
					myChart.setOption(option);

					var myChart0 = ec.init(document.getElementById('chart0'));

					var option0 = {
						title : {
							text : '开设课程数统计'
						},
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ '开设课程数' ]
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								dataZoom : {
									show : true
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						dataZoom : {
							show : true,
							realtime : true,
							start : 0,
							end : 100
						},
						calculable : true,
						xAxis : [ {
							type : 'category',
							boundaryGap : false,

							data : [
	<%for (int i = 0; i < registerCourseNum.size() - 1; i++) {
				out.println("'" + registerCourseNum.get(i).getMonth() + "',");
			}
			out.println("'" + registerCourseNum.get(registerCourseNum.size() - 1).getMonth() + "'");%>
		]
						} ],
						yAxis : [ {
							type : 'value'
						} ],
						series : [ {
							name : '开设课程数',
							type : 'line',
							data : [
	<%for (int i = 0; i < registerCourseNum.size() - 1; i++) {
				out.println("'" + registerCourseNum.get(i).getNum() + "',");
			}
			out.println("'" + registerCourseNum.get(registerCourseNum.size() - 1).getNum() + "'");%>
		],
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								} ]
							}
						} ]
					};

					// 为echarts对象加载数据 
					myChart0.setOption(option0);

				});
	</script>
</body>

</html>
