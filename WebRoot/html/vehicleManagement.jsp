<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
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
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table">
		    <tbody>
		      <tr>
		        <td class="tdbck">车牌号</td>
		        <td><span id="carNum"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">状态</td>
		        <td><span id="status"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">风扇开关</td>
		        <td><span id="fanStatus"></span></td>
		      </tr>
		      
		      <tr>
		        <td class="tdbck">备注</td>
		        <td><span id="remarks"></span></td>
		      </tr>
		      
		    </tbody>
		  </table>
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			  	<div class="layui-input-inline">
					<input type="text" name="slcarNum" id="slcarNum" placeholder="请输入车牌号" class="layui-input" autocomplete="off">
			    </div>
			    
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增车辆</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		
		<script type="text/html" id="switchTpl">
		  <input type="checkbox" lay-filter="open" name="status" value="{{d.carId}}" {{ d.status == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>
		<script type="text/html" id="switchTpl2">
		  <input type="checkbox" lay-filter="open" name="fanStatus" value="{{d.carId}}" {{ d.fanStatus == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>
		
		<script type="text/html" id="barDemo">
			
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">待定</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				<div class="layui-form-item">
				      
				      
				    </div>
					<div class="layui-form-item">
						<label class="layui-form-label">车牌号:</label>
						<div class="layui-input-block">
							<input type="text" name="addcarNum" id="addcarNum"
								lay-verify="addcarNum" autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">备注:</label>
						<div class="layui-input-block">
							<input type="addremarks" name="addremarks" id="addremarks"  autocomplete="off" placeholder="请输入用户密码" class="layui-input">
						</div>
					</div> 
										
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		//加载角色类型
		loadRoleType('usertype',form);
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'adminUserid',
			url : '../basic/getcar',
			title : '管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				}, {
					field : 'carNum',
					title : '车牌号',
					align : 'center'
				},{
					field:'status', 
					title:'状态',
					align : 'center',
					templet: '#switchTpl', 
					unresize: true
				},{
					field:'fanStatus', 
					title:'风扇开关',
					align : 'center',
					templet: '#switchTpl2', 
					unresize: true
				},{
					field : 'remarks',
					align : 'center',
					title : '备注'
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		form.on('switch(open)', function(data){
		
  	 		if(data.elem.checked){
  	 			//data.value
  	 			$.ajax({
				type : 'get',
				url : '../basic/changecarstate?id=' + this.value+'&type=1',
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
				url : '../basic/changecarstate?id=' + this.value+'&type=2',
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
		
		form.on('switch2(open)', function(data){
		
  	 		if(data.elem.checked){
  	 			//data.value
  	 			$.ajax({
				type : 'get',
				url : '../basic/changecarstate?id=' + this.value+'&type=2',
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
				url : '../basic/changecarstate?id=' + this.value+'&type=2',
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
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function(){
			var useridornickname=$("#slcarNum").val().trim();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'carNum' : useridornickname,
					'roleid' : '',
						},
				page : {
					curr : 1
					}
			});
		});
		
		/* 添加一个网站用户 */
		$("#addartType").click(function(){
			//加载角色类型
			loadRoleType('addusertype',form);
			$("#addcarNum").val("");
			$("#addremarks").val("");
			
			
			layer.open({
				type : 1,
				title : '管理员用户添加',
				area : [ '460px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var addcarNum = $("#addcarNum").val().trim();
					var addremarks = $("#addremarks").val().trim();
					

					if(addcarNum == "") {
						layer.tips('不能为空', '#adduserid');
						return;
					} 
					if(addremarks==""){
						layer.tips('不能为空', '#addpwd');
						return;
					}
					
					
					$.ajax({
						type : 'get',
						url : '../basic/addcar?carNum=' + addcarNum +'&remarks='+addremarks,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload("adminUserid", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='10001'
						                }
						            });	
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
							}
						},
						error : function() {
							layer.confirm('出现错误，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
						}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
	
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
			var data = obj.data;
			$("#txtclaid").text(data.userid);
			$("#addremarks").text(data.realname);
			$("#txtadminuserusertype").text(data.name);
			$("#txtadminuserdesc").text(data.signed);
			$("#txtadmincreatetime").text(data.createtime);
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '管理员信息详情',
				        area: ['600px', '430px'],
				        shade: 0.8,
				        content: $('#adminuserdetail'),
				        btn: ['返回'], 
				        yes: function(){
				          layer.closeAll();
				          $(".adminuserdetail").css("display","none");
				        },
				        cancel: function(){ 
						  $(".adminuserdetail").css("display","none");
						}
				    });
				break;
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../admin/deladminuser?userid="+data.userid,
			        		dataType: 'json',
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("adminUserid", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
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
					}, function(){ 
						layer.closeAll();
					});
				break;
				
			}
			;
		});
	
	});
	</script>
</body>
</html>