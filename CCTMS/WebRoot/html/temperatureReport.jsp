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
	<link rel="stylesheet" href="../css/font.css">
	<link rel="stylesheet" href="../css/index.css">
	<link rel="stylesheet" href="../layui/css/layui.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0FuoX30MFf7YMrdS5Wi9GGAcHBblKDuu"></script>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table">
		    <tbody>
		     <tr>
		        <td class="tdbck">线路名称</td>
		        <td><span id="taskname"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">车牌号</td>
		        <td><span id="carNum"></span></td>
		      </tr>
		       <tr>
		        <td class="tdbck">用户名</td>
		        <td><span id="userName"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">温度阈值</td>
		        <td><span id="tthresho"></span></td>
		      </tr>
		      
		      <tr>
		        <td class="tdbck">备注</td>
		        <td><span id="lineRemarks"></span></td>
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
					<input type="text" name="sltaskname" id="sltaskname" placeholder="请输入线路名称" class="layui-input" autocomplete="off">
			    </div>
				
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增线路</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>
		
		<script type="text/html" id="switchTpl">
		  <input type="checkbox" lay-filter="open" name="status" value="{{d.lid}}" {{ d.status == "0" ? 'checked' : '' }} lay-skin="switch" lay-text="启用|停用">
		</script>
		
		<script type="text/html" id="barDemo">
			
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">查看</a>
		</script>

		
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
			url : '../line/getarrange',
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
					field : 'taskname',
					title : '线路名称',
					align : 'center'
				},{
					field : 'carNum',
					title : '车牌号',
					align : 'center'
				},{
					field : 'userName',
					title : '司机',
					align : 'center'
				},{
					field : 'tthresho',
					title : '温度阈值',
					align : 'center'
				},{
					field : 'lineRemarks',
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
		
		
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function(){
			var useridornickname=$("#sltaskname").val().trim();
			
			table.reload('adminUserid', {
				method : 'post',
				where : {
					'carNum' : useridornickname,
					
						},
				page : {
					curr : 1
					}
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
				
				
				//删除按钮操作
				case 'del':
					
				break;
				
			}
			;
		});
	
	});
	</script>
	
</body>
</html>