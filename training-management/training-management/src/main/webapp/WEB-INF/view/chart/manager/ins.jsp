<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="markToIns"
	type="java.util.List<com.zzzzzyx.training_management.model.globalData.manager.ins.MarkToIns>"
	scope="request"></jsp:useBean>
<jsp:useBean id="studentToIns"
	type="java.util.List<com.zzzzzyx.training_management.model.globalData.manager.ins.StudentToIns>"
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
					data-toggle="dropdown"><i class="fa fa-user"></i> manager <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav" style="height: 705px;">
					<li><a href="index.do"><i class="fa fa-fw fa-dashboard"></i>
							学员统计</a></li>
					<li><a href="income.do"><i class="fa fa-fw fa-bar-chart-o"></i>
							收入分析</a></li>
					<li><a href="course.do"><i class="fa fa-fw fa-table"></i>
							课程分析</a></li>
					<li class="active"><a href="ins.do"><i
							class="fa fa-fw fa-edit"></i> 机构分析</a></li>
					<li><a href="customer.do"><i class="fa fa-fw fa-table"></i> 客户分析</a>
                    </li>
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
							机构分析<small> 基于总选课人数和平均分数的分析</small>
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> 总选课人数与机构的关系
								</h3>
							</div>
							<div id="chart0" class="panel-body" style="height: 400px">
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> 平均分与机构的关系
								</h3>
							</div>
							<div id="chart1" class="panel-body" style="height: 400px">
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

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
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
     // 使用
        require(
            [
                'echarts',
                'echarts/chart/line',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                
				var myChart0 = ec.init(document.getElementById('chart0')); 
                
                var option0	 = {
                	    title : {
                	        text: '总选课人数与机构的关系分析'
                	    },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	        data:['平均退课率','学员平均分']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {show: true, type: ['line', 'bar']},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    xAxis : [
                	        {
                	            type : 'category',
                	            data : [
                	            	<% for(int i = 0 ; i < studentToIns.size() - 1 ; i ++){
                			        	out.println("'" + studentToIns.get(i).getStudent() + "',");
                	            	}
                	            	out.println("'" + studentToIns.get(studentToIns.size() - 1).getStudent() + "'");
                			        %>]
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'平均退课率',
                	            type:'bar',
                	            itemStyle : { normal: {label : {show: true, position: 'top'}}},
                	            data:[
                	            	<% for(int i = 0 ; i < studentToIns.size() - 1 ; i ++){
                			        	out.println("'" + studentToIns.get(i).getCancelRate() + "',");
                	            	}
                	            	out.println("'" + studentToIns.get(studentToIns.size() - 1).getCancelRate() + "'");
                			        %>]
                	        },
                	        {
                	            name:'学员平均分',
                	            type:'bar',
                	            itemStyle : { normal: {label : {show: true, position: 'top'}}},
                	            data:[
                	            	<% for(int i = 0 ; i < studentToIns.size() - 1 ; i ++){
                			        	out.println("'" + studentToIns.get(i).getAverageMark() + "',");
                	            	}
                	            	out.println("'" + studentToIns.get(studentToIns.size() - 1).getAverageMark() + "'");
                			        %>]
                	        }
                	    ]
                	};
                	                    
        
                // 为echarts对象加载数据 
                myChart0.setOption(option0); 
                
				var myChart1 = ec.init(document.getElementById('chart1')); 
                
                var option1	 = {
                	    title : {
                	        text: '学员平均分与机构的关系分析'
                	    },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	        data:['平均选课人数','平均退课率']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {show: true, type: ['line', 'bar']},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    xAxis : [
                	        {
                	            type : 'category',
                	            data : [
                	            	<% for(int i = 0 ; i < markToIns.size() - 1 ; i ++){
                			        	out.println("'" + markToIns.get(i).getAverageMark() + "',");
                	            	}
                	            	out.println("'" + markToIns.get(markToIns.size() - 1).getAverageMark() + "'");
                			        %>]
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'平均选课人数',
                	            type:'bar',
                	            itemStyle : { normal: {label : {show: true, position: 'top'}}},
                	            data:[
                	            	<% for(int i = 0 ; i < markToIns.size() - 1 ; i ++){
                			        	out.println("'" + markToIns.get(i).getAttendNum() + "',");
                	            	}
                	            	out.println("'" + markToIns.get(markToIns.size() - 1).getAttendNum() + "'");
                			        %>]
                	        },
                	        {
                	            name:'平均退课率',
                	            type:'bar',
                	            itemStyle : { normal: {label : {show: true, position: 'top'}}},
                	            data:[
                	            	<% for(int i = 0 ; i < markToIns.size() - 1 ; i ++){
                			        	out.println("'" + markToIns.get(i).getCancelRate() + "',");
                	            	}
                	            	out.println("'" + markToIns.get(markToIns.size() - 1).getCancelRate() + "'");
                			        %>]
                	        }
                	    ]
                	};
                	                    
        
                // 为echarts对象加载数据 
                myChart1.setOption(option1);
                
            }
        );
    </script>
</body>

</html>
