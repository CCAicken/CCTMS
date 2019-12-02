layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ],function() {
	var table = layui.table;
	form = layui.form, layer = layui.layer,
	laydate = layui.laydate, laytpl = layui.laytpl,
	element = layui.element;

	//加载角色类型
	$.ajax({
		type : 'get',
		url : '../adminrole/getrole',
		datatype : 'json',
		success : function(roledata) {
			//alert(roledata.msg +","+roledata.resultObject)
			if (roledata.code == 0) {
				var str = "";
				for(var i = 0; i < roledata.data.length; i++){
					str += '<option value=' + roledata.data[i].roleid + '>'+ roledata.data[i].name +'</option>';
				}
				$("#backrolemodel").append(str);
				form.render();
			}
			else{
				layer.msg("角色信息获取失败");
			}
		},
		error : function() {
	 		layer.msg("角色信息获取失败");
		}
	});
	
	//点击查询，更具角色筛选角色权限
	$("#btnselbackrole").click(function(){ 
		var roleid = $("#backrolemodel").val();
		alert(roleid);
		var roletext=$("#backrolemodel  option:selected").text();
		
		if(roleid==00){
			layer.msg("请选择角色");
			return;
		}
		table.render({
			elem: '#backrolesystemmodel',
			id:'backrolesys',
			url: '../systemmodel/getsystemmodelbyrole2?roleid=' + roleid,
			loading: true,
			title: '角色权限表数据表',
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
					field: 'rolename',
					align: 'center',
					title: '角色名'						
				}, 
				{
					field: 'chinesename',
					align: 'center',
					title: '菜单名称'
				}, {
					field: 'deepth',
					align: 'center',
					templet: '#menuTypebar',
					title: '菜单层次'					
				}, 
				{
					field: 'parentName',
					align: 'center',
					title: '父菜单名称'
				}, {
					field: 'isedit',
					align: 'center',
					title: '设置权限',
					templet: '#selectbar',
					width:150
				}]
			]
		});
	});
	
	//取消或授予权限
	//此处为每当
	form.on('checkbox(lockDemo)', function(obj) {
		//layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
		//obj代表当前checkbox所在行的数据对象
		if(obj.elem.checked){ //但obj.elem.checked==true
			//还要再获取当前行的值
			//alert("check=" +obj.elem.checked)
			$.ajax({
				type : 'get',
				url : '../systemmodel/changerolemodel?rolemodelid=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {		
						layer.msg('授权成功！请刷新页面', {icon: 1}); 
						//加载表格一级菜单
			  			//loadAdminRole("table_body");
					} else {
	    	        	layer.msg('授权失败！', {icon: 2});
					}
				},
				error : function() {}
			});
		}
		else{
			$.ajax({
				type : 'get',
				url : '../systemmodel/changerolemodel?rolemodelid=' + this.value,
				datatype : 'json',
				success : function(data) {
					if (data.code == "0") {	
						layer.msg('取消授权成功！请刷新页面', {icon: 6}); 				
					} else {
						layer.msg('取消授权失败！', {icon: 2}); 
					}
				},
				error : function() {}
			});
		}				
	});
});