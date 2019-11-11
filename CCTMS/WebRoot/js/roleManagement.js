layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'layedit','element' ],function() {
	var table = layui.table;
	form = layui.form, layer = layui.layer,
	laydate = layui.laydate, laytpl = layui.laytpl,
	element = layui.element,layedit=layui.layedit;
	
	layedit.build('content', {
  			height: 180 //设置编辑器高度
  			, tool: ['']
		});
	
	table.render({
			elem: '#backrolesystemmodel',
			id:'backrolesys',
			url: '../adminrole/getrolelist',
			loading: true,
			title: '角色数据表',
			skin: 'line',
			height:'full-125',
			even: true,
			cols: [
				[
				{
					type : 'numbers',
					title: '序号',
					align: 'center',
					field: 'id',
					width: 80
				}, 
				{
					field: 'name',
					align: 'center',
					title: '角色名'						
				} , 
				{
					field: 'description',
					align: 'center',
					title: '角色描述'						
				} ,{
					field: 'isedit',
					align: 'center',
					title: '操作',
					toolbar : '#barDemo',
					width:150
				}]
			]
		});
		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../major/delmajor",
			        		dataType: 'json',
			        		data:{
			        		newid:data.majorid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("backrolesys", { //此处是上文提到的 初始化标识id
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
			        		}
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
				case 'edit': 
				
				 	 $("#oldmajorname").val(data.name);
					 $("#content").text(data.description);
					layer.open({
  						title:"角色信息编辑",
  						type: 1,
  						area: ['380px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editmajor'),
  						btn1: function(index, layero){
    						$.ajax({
			        		type: 'get',
			        		url: "../adminrole/updaterolelist",
			        		dataType: 'json',
			        		data:{
			        			roleid:data.id,
			        			name:$("#newmajorname").val().trim(),
					 			description:$("#content").text()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("backrolesys", { //此处是上文提到的 初始化标识id
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
			        			layer.confirm('出现错误 ，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								});
			        		}
			        	});  
  						},
  						cancel: function(){ 
  							//$("#newcollegename").val("");
  						}
					});
					
				break;
			};
		});
		 form.on('submit(formDemo)', function(data){
    		layer.alert(JSON.stringify(data.field), {
      		title: '最终的提交信息'
    		})
    		return false;
  		 });
 
		//添加按钮事件
  		$("#btn_addmajor").click(function(){
  			//加载表格一级菜单
  			//loadAdminRole("table_body");
  			layer.open({
  				title:"添加角色",
  				type: 1,
  				area: ['500px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addmajor'),
  				btn1: function(index, layero){
  					if($("#addmajorname").val().trim()==null|| $("#addmajorname").val().trim()==""){
  						layer.tips('请选择用户类型！', '#addmajorname', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
  					}
  					if($("#description").val().trim()==null|| $("#description").val().trim()==""){
  							layer.tips('请选择用户类型！', '#description', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
  					}
    				$.ajax({
			        		type: 'get',
			        		url: "../adminrole/addrole",
			        		dataType: 'json',
			        		data:{
			        		name:$("#addmajorname").val().trim(),
			        		 description:$("#description").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("backrolesys", { //此处是上文提到的 初始化标识id
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
			        		}
			        	});  
  				},
  				cancel: function(){ 
  					$('#addmajorname').val("");
  					$('#description').val("");
  				}
			});
  		}) 
	//点击查询，更具角色筛选角色权限
	$("#btnselbackrole").click(function(){ 
		table.reload('backrolesys', {
				method : 'post',
				where : {
					'opreation' : $("#opreation").val().trim()
						},
				page : {
					curr : 1
					}
			});
	});
	
	
	
	//复选框事件
	//checkbox(1);
	//checkbox(2);
	//checkbox(3);
	//checkbox(4);
	//checkbox(5);
	//checkbox(24);
	//function checkbox(filter){
	 //监听复选框事件
//	form.on("checkbox("+filter+")", function(obj) {
//		//alert(obj.elem.checked); //是否被选中，true或者false
//  		//alert(obj.value);
//		//layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
//		//obj代表当前checkbox所在行的数据对象
//		if(obj.elem.checked){ //但obj.elem.checked==true
//			//还要再获取当前行的值
//			//alert("check=" +obj.elem.checked)
//			$.ajax({
//				type : 'get',
//				url : '../systemmodel/getmenubyparentid?parentid=' + obj.value,
//				datatype : 'json',
//				success : function(res) {
//					if (res.code == "0") {		
//						$('#' + obj.value).html("");
//						var str = "";
//						for(var i = 0; i < res.data.length; i++) {
//							
//								str+="<input lay-filter='"+res.data[i].id+"' type='checkbox' value='"+res.data[i].id+"' name='"+res.data[i].name+"' title='"+res.data[i].name+"'/>";
//							
//						}
//						
//						$('#' + obj.value).append(str);
//						form.render();
//					} else {
//	    	        	layer.msg('获取二级菜单失败！', {icon: 2});
//					}
//				},
//				error : function() {
//					layer.msg('获取二级菜单失败！，请重试', {icon: 2});
//				}
//			});
//		}
//		else{
//			$('#' + obj.value).html("");
//		}				
//	});
//		
	//}
	
	//动态加载权限列表
	function loadAdminRole(tempid){
		$.ajax({
				type : 'get',
				url : '../systemmodel/getmenubyparentid?parentid=0',
				datatype : 'json',
				success : function(res) {
					if(res.code == 0) {
						$('#' + tempid).html("");
						var str = "";
						for(var i = 0; i < res.data.length; i++) {
							str+="<tr><td><div class='layui-input-block' style='margin-left:0px;'>";
							
							str+="<input lay-filter='"+res.data[i].id+"' type='checkbox' value='"+res.data[i].id+"' name='"+res.data[i].name+"' title='"+res.data[i].name+"'/>";
							
							str+="</div></td><td><div class='layui-input-block' style='margin-left:0px;' id='"+res.data[i].id+"'></div></td>";
							
						}
						
						$('#' + tempid).append(str);
						form.render();
						} else {
							//layer.msg("未获取到阶段信息！");
							layer.msg('未获取到用户角色信息！', function(){});
						}
				},
				error : function() {
					layer.msg('后台报错！', {icon: 2}); 
				}
			})
	}
	
});