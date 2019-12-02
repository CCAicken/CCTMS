<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>后台权限管理界面</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
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
						<input type="text" name="sysmothed" id="opreation"
							placeholder="请输入条件" class="layui-input" autocomplete="off">
					</div>
					<div class="layui-inline">
						<button id="btnselbackrole" type="button"
							class="layui-btn layui-bg-blue">查询</button>
					</div>
					<div class="layui-inline">
						<button class="layui-btn layuiadmin-btn-useradmin" type="button"
							id="btn_addmajor">添加</button>
					</div>
				</div>
			</form>
		</blockquote>

		<table class="layui-hide" id="backrolesystemmodel"
			lay-filter="tool"></table>
		<script type="text/html" id="barDemo"> 
				  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          		
        	 </script>
		<script type="text/html" id="selectbar">
				<input type="checkbox" name="{{d.deepth}}" value="{{d.id}}" title="授予" lay-filter="lockDemo" {{ d.isedit == "1" ? 'checked' : '' }}>
			</script>

		<script type="text/html" id="menuTypebar">
				<span>{{ d.deepth <= "1" ? '展开菜单' : '子菜单' }}</span>
			</script>

	</div>

	<!--添加div  -->
	<div id="div_addmajor"
		style="display: none;text-align: center; margin-top: 1%;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">角色名称:</label>
				<div class="layui-input-inline">
					<input type="text" style="width:250px;border-radius: 5px;"
						name="sysmothed" id="addmajorname" placeholder="请输入角色名称"
						class="layui-input" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">描述</label>
				<div class="layui-input-block">
					<textarea name="desc" id="description" placeholder="请输入对该角色的描述" class="layui-textarea"></textarea>
				</div>

				<!--  <table class="layui-table" id="table_addrole" lay-skin="line">
					<thead>
						<tr>
							<td>一级菜单</td> 
							<td>二级菜单</td> 
						</tr>
					</thead>
					<tbody id="table_body">
						<tr>
							<td>
								<div class="layui-input-block" style="margin-left:0px; ">
									<input lay-filter="addform" type="checkbox" name="game" title="游戏">
								</div>
							</td>
							<td>
								<div class="layui-input-block" style="margin-left:0px; ">
									<div class="layui-input-block" style="margin-left:0px; ">
									<input type="checkbox" name="game1" title="游戏1">
									<input type="checkbox" name="game2" title="游戏2">
								</div>
								<div class="layui-input-block" style="margin-left:0px; ">
									<input type="checkbox" name="game1" title="游戏1">
									<input type="checkbox" name="game2" title="游戏2">
								</div>
								<div class="layui-input-block" style="margin-left:0px; ">
									<input type="checkbox" name="game1" title="游戏1">
									<input type="checkbox" name="game2" title="游戏2">
								</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>-->
			</div>
			 
		</form>
	</div>
	<!--编辑div  -->
	<div id="div_editmajor"
		style="display: none;text-align: center; margin-top: 10px;">
		<form class="layui-form" action="">
			 
			<div class="layui-form-item">
				<label class="layui-form-label">角色原名称:</label>
				<div class="layui-input-inline">
					<input type="text" name="title" id="oldmajorname"
						disabled="disabled" autocomplete="off"
						class="layui-input layui-btn-disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色新名称:</label>
				<div class="layui-input-inline">
					<input type="text" id="newmajorname" placeholder="请输入新名称"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色新名称:</label>
				<div class="layui-input-inline">
					<textarea id="content" style="display: none;"></textarea>
				</div>
			</div>
		</form>
	</div>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/roleManagement.js"></script>
</body>
</html>