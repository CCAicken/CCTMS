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
		        <td class="tdbck">起点</td>
		        <td><span id="startpoint"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">终点</td>
		        <td><span id="endpoint"></span></td>
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
			
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
				<div class="layui-form-item">				      				      
				    </div>
					<div class="layui-form-item">
						<label class="layui-form-label">线路名称:</label>
						<div class="layui-input-block">
							<input type="text" name="addtaskname" id="addtaskname"
								lay-verify="addtaskname" autocomplete="off" placeholder="请输入线路名称" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">选择起点:</label>
						<a class="layui-btn layui-btn-normal" id="intomap">进入地图</a>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">起点:</label>
						<div class="layui-input-block">
							<input type="text" name="addstartpoint" id="addstartpoint"
								lay-verify="addxcoordinate" autocomplete="off" readonly class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">选择终点:</label>
						<a class="layui-btn layui-btn-normal" id="intoENDmap">进入地图</a>
					</div> 
					<div class="layui-form-item">
						<label class="layui-form-label">终点:</label>
						<div class="layui-input-block">
							<input type="text" name="addendpoint" id="addendpoint"
								lay-verify="addycoordinate" autocomplete="off" readonly class="layui-input">
						</div>
					</div>							
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
		<!-- 地图起点选择弹窗Start -->
		<div id="add-map" style="display:none;">
			<div class="layui-container">          
                <form class="layui-form" action="">
                        <div class="layui-form-item search_form">
                                <div class="layui-input-inline">
                                  <input type="text" name="address" value="" id="where" placeholder="请输入线路名称"  class="layui-input">
                                </div>
                                <button onClick="sear(document.getElementById('where').value);" type="button" class="layui-btn layui-btn-normal">定位</button>
                              </div>
                              
                              <div class="layui-form-item">
                                <div class="zerocard_add_ys">
                                        <div class="format2">
                                   
                                    <span><img src="../image/p3.png" style="height: 25px; width: 25px;"> 经度：</span>
                                        </div>
                                    <div class="box_input">
                                        <input name="longitude" value=""id="lng" class="layui-input case_text" type="text">
                                    </div>
                                    <div class="format2">
                                       
                                        <span><img src="../image/p2.png" style="height: 25px; width: 25px;"> 纬度：</span>
                                    </div>
                                    <div class="box_input">
                                        <input name="latitude" value=""id="lat"  class="layui-input case_text" type="text">
                                    </div>
                                     
                                </div>
                              </div>
                        </form>
                
                
                <br />
                
                
                <div style="width:100%;height:450px;border:1px solid gray" id="container"></div>
    </div>
		</div>
		<!-- 地图坐标点选择弹窗End -->
		
		<!-- 地图终点选择弹窗Start -->
		<div id="addENDmap" style="display:none;">
			<div class="layui-container">          
                <form class="layui-form" action="">
                        <div class="layui-form-item search_form">
                                <div class="layui-input-inline">
                                  <input type="text" name="address" value="" id="where2" placeholder="请输入地点"  class="layui-input">
                                </div>
                                <button onClick="sear(document.getElementById('where').value);" type="button" class="layui-btn layui-btn-normal">定位</button>
                              </div>
                              
                              <div class="layui-form-item">
                                <div class="zerocard_add_ys">
                                        <div class="format2">
                                   
                                    <span><img src="../image/p3.png" style="height: 25px; width: 25px;"> 经度：</span>
                                        </div>
                                    <div class="box_input">
                                        <input name="longitude" value=""id="lng2" class="layui-input case_text" type="text">
                                    </div>
                                    <div class="format2">
                                       
                                        <span><img src="../image/p2.png" style="height: 25px; width: 25px;"> 纬度：</span>
                                    </div>
                                    <div class="box_input">
                                        <input name="latitude" value=""id="lat2"  class="layui-input case_text" type="text">
                                    </div>
                                     
                                </div>
                              </div>
                        </form>
                
                
                <br />
                
                
                <div style="width:100%;height:450px;border:1px solid gray" id="container2"></div>
    </div>
		</div>
		<!-- 地图坐标点选择弹窗End -->
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
			url : '../linecontoller/getline',
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
				},{
					field : 'taskname',
					title : '线路名称',
					align : 'center'
				},{
					field : 'startpoint',
					title : '起点',
					align : 'center'
				},{
					field : 'endpoint',
					title : '终点',
					align : 'center'
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
		
		
		
		form.on('switch(open)', function(data){
		
  	 		if(data.elem.checked){
  	 			//data.value
  	 			$.ajax({
				type : 'get',
				url : '../linecontoller/changestate?id=' + this.value,
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
				url : '../linecontoller/changestate?id=' + this.value,
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
		
		/* 添加一个网站用户 */
		$("#addartType").click(function(){
			//加载角色类型
			loadRoleType('addusertype',form);
			$("#addtaskname").val("");
			$("#addstartpoint").val("");
			$("#addendpoint").val("");
			
			
			
			layer.open({
				type : 1,
				title : '管理员用户添加',
				area : [ '650px', '450px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var addtaskname = $("#addtaskname").val().trim();
					var addstartpoint = $("#addstartpoint").val().trim();
					var addendpoint = $("#addendpoint").val().trim();
					
					

					if(addtaskname == "") {
						layer.tips('不能为空', '#addtaskname');
						return;
					} 
					if(addstartpoint==""){
						layer.tips('不能为空', '#addxcoordinate');
						return;
					}
					if(addendpoint==""){
						layer.tips('不能为空', '#addycoordinate');
						return;
					}
					
					
					
					$.ajax({
						type : 'get',
						url : '../linecontoller/addline?taskname=' + addtaskname +'&startpoint='+addstartpoint+'&endpoint='+addendpoint,
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
		
		/* 打开地图选择经纬度*/
		$("#intomap").click(function(){
			//加载角色类型					
			var laji = layer.open({
				type : 1,
				title : '经纬度添加',
				area : [ 100, 100 ],
				shade : 0.4,
				content : $('#add-map'),
				btn : [ '保存'],
				yes: function(){
					var str1 = document.getElementById("where").value;
					var str2 = document.getElementById("lng").value;
					var str3 = document.getElementById("lat").value;
					document.getElementById("addstartpoint").value = '地点名称:'+str1+' 经度:'+str2+' 纬度:'+str3;
         			layer.close(laji);
        		},
			});
		});
		
		/* 打开地图选择终点*/
		$("#intoENDmap").click(function(){
			//加载角色类型					
			var laji = layer.open({
				type : 1,
				title : '经纬度添加',
				area : [ 100, 100 ],
				shade : 0.4,
				content : $('#addENDmap'),
				btn : [ '保存'],
				yes: function(){
					var str1 = document.getElementById("where2").value;
					var str2 = document.getElementById("lng2").value;
					var str3 = document.getElementById("lat2").value;
					document.getElementById("addendpoint").value = '地点名称:'+str1+' 经度:'+str2+' 纬度:'+str3;
         			layer.close(laji);
        		},
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
	<script>
    var is_empty =0
    lng = 116.404;
    lat = 39.915;
    var map = new BMap.Map("container");//在指定的容器内创建地图实例
    map.setDefaultCursor("crosshair");//设置地图默认的鼠标指针样式
    map.enableScrollWheelZoom();//启用滚轮放大缩小，默认禁用。
    var point =new BMap.Point(lng,lat)
    map.centerAndZoom(point, 15);
    map.addControl(new BMap.NavigationControl());
    var marker = new BMap.Marker(point);        // 创建标注
    this.map.addOverlay(marker);
    map.addEventListener("click", function(e){//地图单击事件
        var geocoder = new BMap.Geocoder();
        var point = new BMap.Point(e.point.lng,e.point.lat);
        geocoder.getLocation(point,function(geocoderResult,LocationOptions){
            map.clearOverlays()
            map.addControl(new BMap.NavigationControl());
            var marker = new BMap.Marker(point);        // 创建标注
            this.map.addOverlay(marker);
            //定位成功
            var address = geocoderResult.address;
            document.getElementById("where").value =address
            layer.msg('定位成功');
            // $('#suggestId').val(geocoderResult.address);
        });
        document.getElementById("lng").value = e.point.lng;
        document.getElementById("lat").value = e.point.lat;
       
    });
    function iploac(result){//根据IP设置地图中心
        var cityName = result.name;
        map.setCenter(cityName);
    }
    if(is_empty ==0){
        // var myCity = new BMap.LocalCity();
        // myCity.get(iploac);
        dingwei()
    }
    function dingwei() {
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
                document.getElementById("lng").value = r.point.lng;
                
                document.getElementById("lat").value = r.point.lat;
              
                var city_name =r.address.province + r.address.city;
                document.getElementById("where").value = city_name
            }
            else {
                console.log('获取失败');
            }
        });
    }
    function sear(result){//地图搜索
        if(result.length ==0){
            dingwei();
            return false
        }
        var local = new BMap.LocalSearch(map, {
            renderOptions:{map: map}
        });
        local.search(result);
    }
</script>
<script>
    var is_empty =0
    lng = 116.404;
    lat = 39.915;
    var map = new BMap.Map("container2");//在指定的容器内创建地图实例
    map.setDefaultCursor("crosshair");//设置地图默认的鼠标指针样式
    map.enableScrollWheelZoom();//启用滚轮放大缩小，默认禁用。
    var point =new BMap.Point(lng,lat)
    map.centerAndZoom(point, 15);
    map.addControl(new BMap.NavigationControl());
    var marker = new BMap.Marker(point);        // 创建标注
    this.map.addOverlay(marker);
    map.addEventListener("click", function(e){//地图单击事件
        var geocoder = new BMap.Geocoder();
        var point = new BMap.Point(e.point.lng,e.point.lat);
        geocoder.getLocation(point,function(geocoderResult,LocationOptions){
            map.clearOverlays()
            map.addControl(new BMap.NavigationControl());
            var marker = new BMap.Marker(point);        // 创建标注
            this.map.addOverlay(marker);
            //定位成功
            var address = geocoderResult.address;
            document.getElementById("where2").value =address
            layer.msg('定位成功');
            // $('#suggestId').val(geocoderResult.address);
        });
       
        document.getElementById("lng2").value = e.point.lng;
        document.getElementById("lat2").value = e.point.lat; 
    });
    function iploac(result){//根据IP设置地图中心
        var cityName = result.name;
        map.setCenter(cityName);
    }
    if(is_empty ==0){
        // var myCity = new BMap.LocalCity();
        // myCity.get(iploac);
        dingwei()
    }
    function dingwei() {
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function(r){
            if(this.getStatus() == BMAP_STATUS_SUCCESS){
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
             
                document.getElementById("lng2").value = r.point.lng;
               
                document.getElementById("lat2").value = r.point.lat;
                var city_name =r.address.province + r.address.city;
                document.getElementById("where2").value = city_name
            }
            else {
                console.log('获取失败');
            }
        });
    }
    function sear(result){//地图搜索
        if(result.length ==0){
            dingwei();
            return false
        }
        var local = new BMap.LocalSearch(map, {
            renderOptions:{map: map}
        });
        local.search(result);
    }
</script>
</body>
</html>