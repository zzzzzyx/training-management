<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
					<li><a href="ins.do"><i
							class="fa fa-fw fa-edit"></i> 机构分析</a></li>
					<li class="active"><a href="customer.do"><i class="fa fa-fw fa-table"></i> 客户分析</a>
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
                            客户分析
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <h2>重要保持</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>客户编号</th>
                                        <th>消费周期</th>
                                        <th>消费次数</th>
                                        <th>消费金额</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1011001</td>
                                        <td>6天</td>
                                        <td>7</td>
                                        <td>1426元</td>
                                    </tr>
                                    <tr>
                                        <td>1016005</td>
                                        <td>7天</td>
                                        <td>5</td>
                                        <td>1014元</td>
                                    </tr>
                                    <tr>
                                        <td>1712681</td>
                                        <td>15天</td>
                                        <td>12</td>
                                        <td>3221元</td>
                                    </tr>
                                    <tr>
                                        <td>1911398</td>
                                        <td>21天</td>
                                        <td>11</td>
                                        <td>2186元</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h2>重要价值</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>客户编号</th>
                                        <th>消费周期</th>
                                        <th>消费次数</th>
                                        <th>消费金额</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1065442</td>
                                        <td>6天</td>
                                        <td>2</td>
                                        <td>1146元</td>
                                    </tr>
                                    <tr>
                                        <td>2516005</td>
                                        <td>1天</td>
                                        <td>2</td>
                                        <td>2444元</td>
                                    </tr>
                                    <tr>
                                        <td>1319981</td>
                                        <td>12天</td>
                                        <td>3</td>
                                        <td>2411元</td>
                                    </tr>
                                    <tr>
                                        <td>1911398</td>
                                        <td>1天</td>
                                        <td>7</td>
                                        <td>2301元</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                        <h2>重要发展</h2>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>客户编号</th>
                                        <th>消费周期</th>
                                        <th>消费次数</th>
                                        <th>消费金额</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1025127</td>
                                        <td>1天</td>
                                        <td>2</td>
                                        <td>346元</td>
                                    </tr>
                                    <tr>
                                        <td>1566781</td>
                                        <td>3天</td>
                                        <td>2</td>
                                        <td>175元</td>
                                    </tr>
                                    <tr>
                                        <td>1378681</td>
                                        <td>5天</td>
                                        <td>3</td>
                                        <td>232元</td>
                                    </tr>
                                    <tr>
                                        <td>1911238</td>
                                        <td>3天</td>
                                        <td>2</td>
                                        <td>809元</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h2>重要挽留</h2>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>客户编号</th>
                                        <th>上次登录时间距今</th>
                                        <th>总消费次数</th>
                                        <th>总消费金额</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1011978</td>
                                        <td>73天</td>
                                        <td>12</td>
                                        <td>2334元</td>
                                    </tr>
                                    <tr>
                                        <td>1588123</td>
                                        <td>62天</td>
                                        <td>6</td>
                                        <td>1109元</td>
                                    </tr>
                                    <tr>
                                        <td>1784681</td>
                                        <td>45天</td>
                                        <td>12</td>
                                        <td>3221元</td>
                                    </tr>
                                    <tr>
                                        <td>1384108</td>
                                        <td>43天</td>
                                        <td>6</td>
                                        <td>1086元</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->


            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
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
</body>

</html>
