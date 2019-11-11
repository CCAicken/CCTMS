<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layuiAdmin 网站用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
 <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<style>
	body .demo-class .layui-layer-title{background:#4476A7; color:#fff; border: none;}
body .demo-class .layui-layer-btn{border-top:1px solid #4476A7}
body .demo-class .layui-layer-btn a{background:#4476A7;}
body .demo-class .layui-layer-btn .layui-layer-btn1{background:#4476A7;}
body .demo-class .layui-layer-page .layui-layer-content {background-color: #e13e4;}
</style>
<body>

  <div class="layui-fluid" style="margin-top: 10px">
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form" id="se_from">
				<div class="layui-inline">
					<select id="collegeselect" lay-filter="college">
						<option value="">请选择学院</option>
					</select>
				</div>
				<div class="layui-inline">
					<select id="majorselect" lay-filter="major">
						<option value="">请选择专业</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_wherecondition" placeholder="请输入条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				
			</form>
		</blockquote>
      
      <div class="layui-card-body">
       <table id="classlist" style="text-align: center;" class="layui-table" lay-filter="tool">
        </table> 
      
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo">
         
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
  <script src="../js/jquery-1.4.4.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/access.js" charset="utf-8"></script>
	
  <script>
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,form=layui.form;
		//alert(sessionStorage.getItem("sysid")); 
		var allcols=
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'collegename',
     				align : 'center',
     				title : '学院名称',
   
    			},{
     				field : 'majorname',
     				align : 'center',
     				title : '专业名称',
   
    			},{
     				field : 'classname',
     				align : 'center',
     				title : '班级名称',
   
    			},{
    				field:'tool',
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}] ;
		
		//var arr= getCompClos().data;
		//处理表头，根据权限去掉相关列
   		//var arr=["collegename","classname","majorname"];
   		//var btns= getCompClos().data1;
   		
  		//加载学院、专业下拉框信息
  		loadSelect("college","collegeselect", form); 
  		loadSelect("major","majorselect", form); 
  		
  		/*加载表格*/
		table.render({
			elem : '#classlist',
			id:'classlist',
			url : '../classes/getclasses',
			title : '班级数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [returnNewCols(allcols,getCompClos().data,getCompClos().data1)],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [1, 4, 5, 10, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对专业进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('classlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_wherecondition").val().trim(),
					'collegeid':$("#collegeselect").val(),
					'majorid':$("#majorselect").val()
						},
				page : {
					curr : 1
					}
			});
		})
		//学院下拉框改变
  		form.on('select(college)', function(data){
  			table.reload('classlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_wherecondition").val().trim(),
					'collegeid':data.value,
					'majorid':$("#majorselect").val()
						},
				page : {
					curr : 1
					}
			});
			loadMajorSelectByCollegeid("majorselect",data.value, form);
			form.render('select', 'major');
		});
		
		//专业下拉框改变
  		form.on('select(major)', function(data){
  			table.reload('classlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_wherecondition").val().trim(),
					'collegeid':$("#collegeselect").val(),
					'majorid': data.value
						},
				page : {
					curr : 1
					}
			});
		});
		
		//添加班级学院下拉框改变
  		form.on('select(addcollege)', function(data){
  			loadMajorSelectByCollegeid("addclassmajor",data.value, form);
		});
		
  		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('即将删除'+data.classname+',确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../classes/delclasses",
			        		dataType: 'json',
			        		data:{
			        		classid:data.classid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("classlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	
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
					}, function(){ 
						layer.closeAll();
					});
				break;
				case 'edit':
				//alert(data.collegename);
					$("#oldcollegename").val(data.classname);
					loadmajoridSelected("newcollegeid",data.majorid,form);
					layer.open({
  						title:"班级信息编辑",
  						type: 1,
  						area: ['400px', '300px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editcollege'),
  						btn1: function(index, layero){
    						$.ajax({
			        		type: 'get',
			        		url: "../classes/edclasses",
			        		dataType: 'json',
			        		data:{
			        			majorid:$("#newcollegeid").val(),
								classid:data.classid, 
							    classname:$("#newcollegename").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("classlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	
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
			        			layer.confirm('出现错误，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});  
  						},
  						cancel: function(){ 
  							$("#newcollegename").val("");
  						}
					});
					
				break;
			};
		});
  	
  		//添加班级按钮事件
  		$("#btn_addcollege").click(function(){
  		
  			loadSelect("college","addclasscollege", form); 
  			layer.open({
  				title:"添加班级",
  				type: 1,
  				area: ['400px', '600px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addcollege'),
  				btn1: function(index, layero){
    				$.ajax({
			        		type: 'get',
			        		url: "../classes/addclasses",
			        		dataType: 'json',
			        		data:{
			        		majorid:$("#addclassmajor").val(),
			        		 classname:$("#addclassname").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("classlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	
							                },page: {
							                curr:1
							                }
							            });	
							            $('#addclassname').val("");
							            loadMajorSelectByCollegeid("addclassmajor",'-1', form);
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
			        			layer.confirm('出现错误，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});  
  				},
  				cancel: function(){ 
  					$('#addclassname').val("");
  					loadMajorSelectByCollegeid("addclassmajor",'-1', form);
  				}
			});
  		})
	
	}); 
  </script>
	 <!--班级添加div  -->
	<div id="div_addcollege"
		style="display: none;text-align: center; margin-top: 15%;">
		<form class="layui-form" action=""  lay-filter="addform">
			<div class="layui-form-item">
				 <label class="layui-form-label">所属学院:</label>
				<div class="layui-input-inline">
					<select id="addclasscollege" lay-filter="addcollege">
						<option value="0">请选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">所属专业:</label>
				<div class="layui-input-inline">
					<select id="addclassmajor">
						<option value="0">请先选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">班级名称:</label>
				<div class="layui-input-inline">
					<input type="text" style="width:250px;border-radius: 5px;"
						name="sysmothed" id="addclassname" placeholder="请输入班级名称"
						class="layui-input" autocomplete="off">
				</div>
			</div>
		</form>
	</div>
	 <!--班级编辑div  -->
	<div id="div_editcollege"
		style="display: none;text-align: center; margin-top: 15%;">
		<form class="layui-form" action=""  lay-filter="addform">
		<div class="layui-form-item">
			<label class="layui-form-label">班级原名称:</label>
			<div class="layui-input-inline">
				<input id="oldcollegename" type="text" name="title" disabled="disabled" autocomplete="off" class="layui-input layui-btn-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">专业:</label>
			<div class="layui-input-inline">
				<select id="newcollegeid" lay-filter="major">
						<option value="">请选择专业</option>
					</select>
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">班级新名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="title"  id="newcollegename"
					placeholder="请输入新名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		</form>
	</div>
</body>
		   
</html>
