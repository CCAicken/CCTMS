<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>后台用户管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<style>
		.blogUser-con .layui-table-view {
			border: none;
		}
		
		.blogUser-con .layui-table-box {
			margin-top: 10px;
		}
		
		.blogUser-con {
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		.blogUser-con  .layui-table-tool-self{
			display:none;
		}
		.blogUser-con .not_border_left {
			border-left: none !important;
		}
		
		.blogUser-con .blogUser dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		
		.blogUser-con .hide {
			display: none;
		}
		
		.blogUser-con .show {
			display: block;
		}
		
		.blogUser-con .btn_size {
			height: 28px !important;
			line-height: 28px !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-hover {
			background: #fffdd3 !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-click {
			background: #fdef9b !important;
		}
		
		.blogUser-con .layui-table, .layui-table-view {
			border: none;
			margin-top: 0;
		}
		
		#add-blogUser {
			display: none;
			z-index: 999 !important;
		}
		
		#add-blogUser .artTypeLayer {
			width: 90%;
			margin-left: auto;
			margin-right: auto;
			padding-top: 20px;
		}
		.adminuserdetail{
			padding:20px;
			display: none;
		}
		.adminuserdetail table tr td{
			padding: 15px;text-align: center;
		}
		.adminuserdetail .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
	</style>
</head>
<body>

	<div class="blogUser-con" style="margin-top: 10px">
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="admin/getuser">
				<div class="layui-inline">
					<select id="systemtype">
						<option value="">请选择日志类型</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入操作的系统方法" class="layui-input" autocomplete="off">
			    </div>
			    <div class="layui-input-inline">
					<input type="text" name="userid" id="userid" placeholder="请输入操作的用户名" class="layui-input" autocomplete="off">
			    </div>
				<span class="layui-input-inline">操作时间：</span> 
				<div class="layui-input-inline">
					
					<input type="text" name="starttime"
						id="starttime" placeholder="yyyy-MM-dd" class="layui-input"
						autocomplete="off">
				</div>
				<span class="layui-input-inline">--</span> 
				<div class="layui-input-inline">
					 <input type="text" name="endtime" id="endtime"
						placeholder="yyyy-MM-dd" class="layui-input" autocomplete="off">
				</div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>

			</form>
		</blockquote>

		<!-- 表格开始 -->
		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		<!-- 表格结束 -->
		
	</div>
	<!-- 表格工具栏开始 -->
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
    		<button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="getCheckData">删除选中的数据</button> 
  		</div>
	</script>
	<!-- 表格工具栏结束 -->
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer',  'laytpl', 'element','laydate' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			element = layui.element,  laydate = layui.laydate;
	/*加载管理员用户*/
		loadSystemOperType("systemtype",form);
		laydate.render({
   			 	elem: '#starttime'
 			 });
 			 laydate.render({
   			 	elem: '#endtime'
 			 });
	
		
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminuser',
			url : '../adminsystem/getsystemlog',
			title : '后台用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			toolbar: '#toolbarDemo',
			cols : [ 
			     [ 
			     {type: 'checkbox', fixed: 'left'},
			     {
					type : 'numbers',
					title : '序号',
					align : 'center'
				}, {
     field : 'opertype',
     align : 'center',
     title : '操作类型',
     width:100
     
    }, {
     field : 'description',
     align : 'center',
     title : '描述',
      width:100
    }, {
     field : 'opermethod',
     title : '操作方法',
     align : 'center',
     width:350
    },{
     field : 'params',
     align : 'center',
     title : '操作参数'
    },{
     field : 'createdate',
     title : '执行时间',
     align : 'center',
     width:200
    },{
     field : 'createby',
     align : 'center',
     title : '执行人',
     width:80
    }] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [1, 4, 5, 10, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('adminuser', {
				method : 'post',
				where : {
					'sysmothed' : $("#sysmothed").val().trim(),
					'userid' : $("#userid").val().trim(),
					'starttime': $("#starttime").val(),
					'systemtype':$("#systemtype").val(),
					'endtime': $("#endtime").val()
						},
				page : {
					curr : 1
					}
			});
		});
		
	 	//头工具栏事件
  		table.on('toolbar(blogUser)', function(obj){
    		var checkStatus = table.checkStatus(obj.config.id);
   		    switch(obj.event){
      			case 'getCheckData':
        			var data = checkStatus.data;
        				//layer.alert(JSON.stringify(data));
        			 layer.confirm('此操作是不可逆的,确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
        				$.ajax({
			        		type: 'get',
			        		url: "../adminsystem/dellog",
			        		dataType: 'json',
			        		data:{
			        		data:JSON.stringify(data)
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("adminuser", { //此处是上文提到的 初始化标识id
							                where: {
							                	'sysmothed' : $("#sysmothed").val().trim(),
												'userid' : $("#userid").val().trim(),
												'starttime': $("#starttime").val(),
												'systemtype':$("#systemtype").val(),
												'endtime': $("#endtime").val()
							                },page: {
							                curr:1
							                }
							            });	
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
			        				icon: 7,
										  btn: ['确定']
									});
			        			}
			        		},
			        		error:function(){
			        			layer.confirm('出现错误，删除失败，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});
			        })
   		 	 };
 		 });
		
	});
	</script>
</body>
</html>