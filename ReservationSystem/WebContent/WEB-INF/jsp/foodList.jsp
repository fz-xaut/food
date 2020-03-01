<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="xaut.meal.system.pojo.Student" %>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://xaut.fengzhuo.crm/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Student stu = (Student) request.getSession().getAttribute("stu");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>

<meta name="description" content=""/>
<meta name="author" content=""/>

<title>xaut_table_reservation</title>

<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet"/>
<!-- MetisMenu CSS -->
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet"/>
<!-- DataTables CSS -->
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet"/>
<!-- Custom CSS -->
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet"/>
<!-- Custom Fonts -->
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css"/>
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
	type="text/css"/>
</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">XAUT在线订餐系统</a>
		</div>
		<ul class="nav navbar-top-links navbar-right">
			
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="modal" href="#" data-target="#ShowMyData"> <i class="fa fa-envelope fa-fw"></i>
					<i class="fa fa-caret-down"></i></a>
			</li>
			
			
			<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i></a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#" data-toggle="modal" data-target="#EditPersonalData"><i class="fa fa-sign-out fa-fw"></i>
								修改资料</a></li>
					<li><a href="/ReservationSystem/login.jsp"><i class="fa fa-sign-out fa-fw"></i>
								退出登录</a></li>
				</ul>
			</li> 
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="帮助..."/>
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li><a href="list.action" class="active"><i
							class="fa fa-edit fa-fw"></i> 所有餐厅</a></li>
					<li><a href="list.action?fId=1"><i
							class="fa fa-dashboard fa-fw"></i> 一号餐厅</a></li>
					<li><a href="list.action?fId=2"><i
							class="fa fa-dashboard fa-fw"></i> 二号餐厅</a></li>
					<li><a href="list.action?fId=3"><i
							class="fa fa-dashboard fa-fw"></i> 三号餐厅</a></li>
					<li><a href="list.action?fId=4"><i
							class="fa fa-dashboard fa-fw"></i> 四号餐厅</a></li>


				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">订餐管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline"
						action="${pageContext.request.contextPath }/food/list.action"
						method="get">
						<div class="form-group">
							<label for="foodname">餐品搜索</label> <input type="text"
								class="form-control" id="fName" value="${vo.fName }"
								name="fName"/>
						</div>
						<div class="form-group">
							<label for="customerFrom">店家筛选</label> <select
								class="form-control" id="fWindow" placeholder="店家选择"
								name="fWindow">
								<option value="">--请选择--</option>
								<c:forEach items="${window}" var="item">
									<option value="${item}"
										<c:if test="${item == vo.fWindow}"> selected</c:if>>${item}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="custIndustry">口味筛选</label> <select
								class="form-control" id="fTaste" name="fTaste">
								<option value="">--请选择--</option>
								<c:forEach items="${taste}" var="item">
									<option value="${item}"
										<c:if test="${item == vo.fTaste}"> selected</c:if>>${item}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="custLevel">价格筛选</label> <select class="form-control"
								id="fPrice" name="fPrice">
								<option value="">--请选择--</option>
								<c:forEach items="${price}" var="item">
									<option value="${item}"
										<c:if test="${item == vo.fPrice}"> selected</c:if>>${item}</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">餐品信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>店家</th>
									<th>餐品名称</th>
									<th>口味</th>
									<th>价格</th>
									<th>查看图片</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.rows}" var="row">
									<tr>
										<td>${row.food_id}</td>
										<td>${row.food_sell_window}</td>
										<td>${row.food_name}</td>
										<td>${row.food_taste}</td>
										<td>${row.food_price}</td>
										<td>暂无图片</td>
										<td><a href="#" class="btn btn-primary btn-xs"
											data-toggle="modal" data-target="#customerEditDialog" 
											onclick="foodOrder('${row.food_id}','${row.food_sell_window}','${row.food_name}',
											'${row.food_taste}','${row.food_price}')">立即订餐</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-12 text-right">
							<itcast:page
								url="${pageContext.request.contextPath }/food/list.action" />
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<div class="modal fade" id="customerEditDialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">确认订餐信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="order_book_form">
						<input type="hidden" id="food_id" name="food_id" />
						<div class="form-group">
							<label for="edit_foodname" class="col-sm-2 control-label">餐品名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food_name"
									readonly="readonly" name="food_name"></input>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_customerFrom"
								style="float: left; padding: 7px 15px 0 27px;">店家信息</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food_sell_window"
									readonly="readonly" name="food_sell_window"></input>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">口味</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food_taste"
									readonly="readonly" name="food_taste"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="food_price"
									readonly="readonly" name="food_price"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stuName"
									readonly="readonly" name="stuName" value="<%=stu.getStuName()%>"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">学号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stuNo"
									readonly="readonly" name="stuNo" value="<%=stu.getStuNo()%>"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_mobile" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stuCall"
									readonly="readonly" name="stuCall" value="<%=stu.getStuCall()%>"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_address" class="col-sm-2 control-label">地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="stuAddress"
									readonly="readonly" name="stuAddress" value="<%=stu.getStuAddress()%>"/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="foodBook()">订餐</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
	<!-- edit personal data -->
	<div class="modal fade" id="EditPersonalData" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改个人信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="personal_data_form">
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">学号</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="PersonalstuNo"
									readonly="readonly" name="PersonalstuNo" value="<%=stu.getStuNo()%>"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_foodname" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="PersonalstuName" name="PersonalstuName" value="<%=stu.getStuName()%>"></input>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="PersonalstuAdderss" name="PersonalstuAdderss" value="<%=stu.getStuAddress()%>"></input>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="PersonalstuCall" name="PersonalstuCall" value="<%=stu.getStuCall()%>"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_address" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="Personalpassword" name="Personalpassword"/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="PersonalChange()">确认</button>
				</div>
			</div>
		</div>
	</div>
	<!-- edit personal data -->
	
	<!-- show my data -->
	<div class="modal fade" id="ShowMyData" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">我的订单</h4>
				</div>
				<div class="modal-body">
				
					<c:choose>
						<c:when test="${empty myorder}"><label>你目前尚未下单</label></c:when>
						<c:when test="${not empty myorder}">
							<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>订单号</th>
									<th>店家</th>
									<th>餐品名称</th>
									<th>口味</th>
									<th>价格</th>
									<th>接单人 + 电话</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${myorder}" var="row">
									<tr>
										<td>${row.orderId}</td>
										<td>${row.foodSellWindow}</td>
										<td>${row.foodName}</td>
										<td>${row.foodTaste}</td>
										<td>${row.foodPrice}</td>
										<td>
											<c:choose>
												<c:when test="${empty row.stuName}">暂无人接单</c:when>
												<c:when test="${not empty row.stuName}">${row.stuName} + ${row.stuCall}</c:when>
											</c:choose>
									    </td>
										<td>
											<c:choose>
												<c:when test="${empty row.stuName}">
													<a href="#" class="btn btn-danger btn-xs"
													onclick="consealFood('${row.orderId}')">退订</a>
												</c:when>
												<c:when test="${not empty row.stuName}">
													<a href="#" class="btn btn-primary btn-xs"
													onclick="confirmFood('${row.orderId}')">确认取餐</a>
												</c:when>
											</c:choose>
											<!-- data-toggle="modal" data-target="#customerEditDialog"  -->
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:when>
					</c:choose>
					
				</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- show my data -->

	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>

	<script type="text/javascript">
		
		function PersonalChange(id) {
			
			var fields = $("#personal_data_form").serializeArray();
	        var obj = {};
	        $.each(fields, function(index, field) {
	            obj[field.name] = field.value;
	        })
	        console.log(obj);
			$.ajax({
				async:true,
				type:"post",
				url:"<%=basePath%>change.action",
				contentType:"application/json; charset=UTF-8",
				dataType: "text",
				data:JSON.stringify(obj),
				success:function(msg) {
					console.log("success");
					if (msg == "success"){
						alert("成功")
					window.location.reload();
					}else{
						alert("失败")
					}
				},
			});
			
		}
		function foodOrder(food_id,food_sell_window,food_name,food_taste,food_price) {
			
			$("#food_id").val(food_id);
			$("#food_name").val(food_name);
			$("#food_sell_window").val(food_sell_window);
			$("#food_taste").val(food_taste);
			$("#food_price").val(food_price)
			
		}
		function foodBook() {
			
			var fields = $("#order_book_form").serializeArray();
	        var obj = {};
	        $.each(fields, function(index, field) {
	            obj[field.name] = field.value;
	        })
	        console.log(obj);
	        //第一个同步请求作用是准确无误的将数据放到消息队列中
			$.ajax({
				async:false,
				type:"post",
				url:"<%=basePath%>food/book.action",
				contentType:"application/json; charset=UTF-8",
				dataType: "text",
				data:JSON.stringify(obj),
				success:function(msg) {
					if (msg == "success"){
							//回调函数中第二个异步请求的作用是讲消息队列中的数据放到数据库中
							$.ajax({
								async:true,
								type:"post",
								data:$("#food_id"),
								url:"<%=basePath%>food/submit.action",
								success:function() {},
							});
						alert("成功")
						window.location.reload();
					}else{
						alert("失败")
					}
				},
			});
		}
		
		function confirmFood(orderId){
			
			$.ajax({
				async:false,
				type:"post",
				url:"<%=basePath%>food/confirm.action",
				contentType:"application/json; charset=UTF-8",
				dataType: "text",
				data:orderId,
				success:function(msg) {
					if (msg == "success"){
						alert("确认收餐成功")
						window.location.reload();
					}else{
						alert("确认失败")
					}
				},
			});
			
			
		}
		
		function consealFood(orderId){
			
			$.ajax({
				async:false,
				type:"post",
				url:"<%=basePath%>food/conseal.action",
				contentType:"application/json; charset=UTF-8",
				dataType: "text",
				data:orderId,
				success:function(msg) {
					if (msg == "success"){
						alert("退订成功")
					}else{
						alert("退订失败，已被接单")
					}
					window.location.reload();
				},
			});
			
		}
	</script>
</body>
</html>
