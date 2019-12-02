<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>后台权限管理界面</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<!--<link rel="stylesheet" href="../css/systemManagement.css" media="all">
		<link rel="stylesheet" href="../css/public.css" media="all">  -->
	</head>
	<body>
		<div class="backRoleSysModel-con">
			<blockquote class="layui-elem-quote not_border_left">
				<form class="layui-form" action="">	
					<div class="layui-inline">
						<div class="layui-input-inline">
							<select name="backrolemodel" id="backrolemodel" lay-filter="backrolemodel">	
								<option value="00">请选择角色</option>							
						    </select>
						</div>
						<div class="layui-inline">
							<button id="btnselbackrole" type="button" class="layui-btn layui-bg-blue">查询</button>							
						</div>
						<div class="layui-inline">
							<a href="roleSystemModelDefault2.jsp"><button type="button" class="layui-btn layui-bg-blue">切换树形</button></a>						
						</div>
					</div>		
				</form>
			</blockquote>
			
			<table class="layui-hide" id="backrolesystemmodel" lay-filter="backrolesystemmodel"></table>

			<script type="text/html" id="selectbar">
				<input type="checkbox" name="{{d.deepth}}" value="{{d.id}}" title="授予" lay-filter="lockDemo" {{ d.isedit == "1" ? 'checked' : '' }}>
			</script>
			
			<script type="text/html" id="menuTypebar">
				<span>{{ d.deepth <= "1" ? '展开菜单' : '子菜单' }}</span>
			</script>			

		</div>
		<script src="../layui/layui.js" charset="utf-8"></script>
		<script src="../js/jquery-3.3.1.js"></script>
		<script src="../js/roleSystemModelDefault.js"></script>
	</body>
</html>