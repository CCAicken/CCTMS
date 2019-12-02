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
		        <td class="tdbck">账号</td>
		        <td><span id="userid"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">姓名</td>
		        <td><span id="userName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">性别</td>
		        <td><span id="sex"></span></td>
		      </tr>
		      
		      <tr>
		        <td class="tdbck">联系方式</td>
		        <td><span id="tel"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">状态</td>
		        <td><span id="status"></span></td>
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
					<input type="text" name="sluserName" id="sluserName" placeholder="请输入用户名或真实姓名" class="layui-input" autocomplete="off">
			    </div>
			    
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增用户</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		
		<script type="text/html" id="switchTpl">
		  <input type="checkbox" lay-filter="open" name="status" value="{{d.userid}}" {{ d.status == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>
		
		<script type="text/html" id="barDemo">
			
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">打电话</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				<div class="layui-form-item">
				      
				      
				    </div>
					<div class="layui-form-item">
						<label class="layui-form-label">账号:</label>
						<div class="layui-input-block">
							<input type="text" name="adduserid" id="adduserid"
								lay-verify="addUserName" autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">用户密码:</label>
						<div class="layui-input-block">
							<input type="password" name="addpwd" id="addpwd"  autocomplete="off" placeholder="请输入用户密码" class="layui-input">
						</div>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="adduserName" id="adduserName" autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">性别:</label>
						<div class="layui-input-block">
							<input type="text" name="addsex" id="addsex" autocomplete="off" placeholder="请输入用户性别" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">联系方式:</label>
						<div class="layui-input-block">
							<input type="text" name="addtel" id="addtel" autocomplete="off" placeholder="请输入联系方式" class="layui-input">
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
			url : '../basic/getuser',
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
					field : 'userid',
					title : '用户名',
					align : 'center'
				}, {
					field : 'userName',
					align : 'center',
					title : '姓名'
				},{
					field : 'sex',
					align : 'center',
					title : '性别'
				},{
					field : 'tel',
					align : 'center',
					title : '联系方式'
				},{
					field:'status', 
					title:'状态',
					align : 'center',
					templet: '#switchTpl', 
					unresize: true
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
				url : '../basic/changestate?id=' + this.value,
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
				url : '../basic/changestate?id=' + this.value,
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
			var useridornickname=$("#sluserName").val().trim();
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'userName' : useridornickname,
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
			$("#adduserid").val("");
			$("#addpwd").val("");
			$("#adduserName").val("");
			$("#addsex").val("");
			$("#addtel").val("");
			
			layer.open({
				type : 1,
				title : '管理员用户添加',
				area : [ '460px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var adduserid = $("#adduserid").val().trim();
					var addpwd = $("#addpwd").val().trim();
					var adduserName = $("#adduserName").val().trim();
					var addsex = $("#addsex").val().trim();
					var addtel = $("#addtel").val().trim();

					if(adduserid == "") {
						layer.tips('不能为空1', '#adduserid');
						return;
					} 
					if(addpwd==""){
						layer.tips('不能为空2', '#addpwd');
						return;
					}
					if(adduserName == "") {
						layer.tips('不能为空3', '#adduserName');
						return;
					}
					
					
					$.ajax({
						type : 'get',
						url : '../basic/adduser?userid=' + adduserid +'&pwd='+addpwd+'&userName='+adduserName+'&sex='+addsex+'&tel='+addtel,
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
			$("#txtadminuserrealname").text(data.realname);
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