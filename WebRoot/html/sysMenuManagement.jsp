<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>设置系统菜单</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<style>
		.sysMenu-con .layui-table-view {
			border: none;
		}
		.sysMenu-con .layui-table-box {
			margin-top: 10px;
		}
		
		.sysMenu-con {
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		.sysMenu-con  .layui-table-tool-self{
			display:none;
		}
		.sysMenu-con .not_border_left {
			border-left: none !important;
		}
		
		.sysMenu-con .sysMenu dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		
		.sysMenu-con .hide {
			display: none;
		}
		
		.sysMenu-con .show {
			display: block;
		}
		
		.sysMenu-con .btn_size {
			height: 28px !important;
			line-height: 28px !important;
		}
		
		.sysMenu-con .layui-table-body table tbody .layui-table-hover {
			background: #fffdd3 !important;
		}
		
		.sysMenu-con .layui-table-body table tbody .layui-table-click {
			background: #fdef9b !important;
		}
		
		.sysMenu-con .layui-table, .layui-table-view {
			border: none;
			margin-top: 0;
		}
		
		#add-sysMenu {
			display: none;
			z-index: 999 !important;
		}
		
		#add-sysMenu .artTypeLayer {
			width: 90%;
			margin-left: auto;
			margin-right: auto;
			padding-top: 20px;
		}
	</style>
</head>
<body>
	<div class="sysMenu-con">
		<table class="layui-hide" name="sysMenu" id="sysMenu" lay-filter="sysMenu"></table>

		<script type="text/html" id="switchTpl">
		  <input type="checkbox" lay-filter="open" name="status" value="{{d.id}}" {{ d.isdelete == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>
		
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table,form = layui.form, 
			layer = layui.layer,$ = layui.jquery,
			laydate = layui.laydate,laytpl = layui.laytpl,
			element = layui.element;

		/*表格信息加载*/
		table.render({
			elem : '#sysMenu',
			id:'sysMenuid',
			url : '../systemmodel/getsystemmodellist?page=1&limit=10',
			title : '系统菜单数据表',
			height: "full-85",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				}, {
					field : 'name',
					title : '菜单名',
					align : 'center'
				}, {
					field : 'chinesename',
					align : 'center',
					title : '菜单中文名',
				}, {
					field : 'navurl',
					align : 'center',
					title : '功能页面'
				},{
					field : 'deepth',
					align : 'center',
					title : '菜单层次',
					templet: function(d){
    					if(d.deepth==1){
    						return "一级菜单";
    					}else if(d.deepth==2){
    						return "二级菜单";
    					}else if(d.deepth==3){
    						return "按钮";
    					}
    				}
				},{
					field : 'parentid',
					align : 'center',
					title : '所属父菜单',
					templet: function(d){
    					if(d.parentid==1){
    						return "信息管理";
    					}else if(d.parentid==2){
    						return "赛事管理";
    					}else if(d.parentid==3){
    						return "赛项安排";
    					}else if(d.parentid==4){
    						return "基本信息";
    					}else if(d.parentid==5){
    						return "比赛管理";
    					}else if(d.parentid==6){
    						return "成绩管理";
    					}else if(d.parentid==24){
    						return "系统管理";
    					}else {
    						return "";
    					}
    				}
				},{
					field : 'displayorder',
					align : 'center',
					title : '显示顺序'
				},{
					field:'status', 
					title:'状态',
					align : 'center',
					templet: '#switchTpl', 
					unresize: true
				}] 
			 ]
		});
		
		form.on('switch(open)', function(data){
  	 		if(data.elem.checked){
  	 			//data.value
  	 			$.ajax({
				type : 'get',
				url : '../systemmodel/changemenustate?id=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {		
						layer.msg('启用成功！请刷新页面', {icon: 1}); 
					} else {
	    	        	layer.msg('启用失败！', {icon: 2});
					}
				},
				error : function() {
					layer.msg('启用失败！请重试', {icon: 2});		
				}
				});
  	 		}else{
  	 			$.ajax({
				type : 'get',
				url : '../systemmodel/changemenustate?id=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {		
						layer.msg('取消启用成功！请刷新页面', {icon: 1}); 
					} else {
	    	        	layer.msg('取消启用失败！', {icon: 2});
					}
				},
				error : function() {
					layer.msg('取消失败！请重试', {icon: 2});		
				}
				});
  	 		}
		});  
	});
	</script>
</body>
</html>