<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html id="demo3" lang="zh" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>index</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css3/default.css" />
		
		<!-- Edit Below -->
		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
    	<script type="text/javascript" src="<%=basePath%>js/jquery.flatshadow.js"></script>
    	<link rel="stylesheet" type="text/css" href="<%=basePath%>css3/style.css" />
    	<link href='<%=basePath%>css3/elusive-webfont.css' rel='stylesheet' type='text/css'>
	</head>
	<body id="demo3">
		<div class="container">

			<div class="header">
				<h1>XAUT食堂点餐系统</h1>	
				<p>Tip：更多菜品正在更新，敬请关注...</p>
			</div>

			<div class="menu">
			</div>
		<div class="main">
         	<div class="flat-icon"><a href="/ReservationSystem/food/list.action"> 我要订餐 </div>
         	<div class="flat-icon"><a href="/ReservationSystem/order/list.action"> 我要接单 </div>
	    </div>
	</div><!-- Container -->
		
	
	<script type="text/javascript">
    $(".flat-icon").flatshadow();
  </script>
	</body>
</html>