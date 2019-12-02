	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>后台管理</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="../css/font.css">
		<link rel="stylesheet" href="../css/index.css">
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<style type="text/css">
		.layui-tab-title li .layui-tab-close{
			display:none;
		}
		.navacolor{
			margin-left: 3px;
			border-left: 3px solid #4476A7;
			
		}
		
		.left-nav #nav li a:hover{
		margin-left: 3px;
			border-left: 3px solid #4476A7;
		}
		
		#nav li:HOVER {
	border-left: 2px #4476A7;
}
		</style>
	</head>
	<body>
		<!-- 顶部开始 -->
		<div class="container">
			<div class="logo">
				<a href="../html/index.jsp">权限管理系统</a>
			</div>
			<div class="left_open">
				<i title="展开左侧栏" class="iconfont">&#xe699;</i>
			</div>
			<ul class="layui-nav left fast-add" lay-filter=""></ul>
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item" lay-unselect><a href="javascript:;">
					<cite>${loginuser.username }</cite>
			</a>
				<dl class="layui-nav-child">
					<dd>
						<a id="changepwd">修改密码</a>
					</dd>
					<hr>
					<dd layadmin-event="logout" id="loginout" style="text-align: center;">
						<a>退出</a>
					</dd>
				</dl></li>
		</ul>
	</div>
		<!-- 顶部结束 -->
		
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav" style="overflow-x: hidden; width:200px;">
			<div id="side-nav" style="overflow-x: hidden;height:100%">
				<ul id="nav" class="layui-nav-tree">	
				</ul>
			</div>
		</div>
		<!-- 左侧菜单结束 -->
		
		<!-- 右侧主体开始 -->
		<div class="page-content">
			<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
				<ul class="layui-tab-title" id="tabName">
					<li id="liformtitle">我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe id="ifram1" src="../html/homePage.html" frameborder="0" scrolling="yes" class="weIframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		
		<!-- 底部开始 -->
		<div class="footer">
			<center>
			<div class="copyright">Copyright ©2018 云南工商学院.软件技术</div>
			</center>
		</div>
		<!-- 底部结束 -->
		
		<script type="text/javascript" src="../layui/layui.all.js" charset="utf-8"></script>
		<script type="text/javascript" src="../js/jquery-3.3.1.js" ></script>
		<script type="text/javascript" src="../js/admin.js" ></script>
	</body>
</html>