	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>地图选择</title>
    <meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- <link rel="stylesheet" href="../layui/css/layui.css" media="all"> -->
    <link rel="stylesheet" href="../css/font.css">
		<link rel="stylesheet" href="../css/index.css">
		<link rel="stylesheet" href="../layui/css/layui.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=0FuoX30MFf7YMrdS5Wi9GGAcHBblKDuu"></script>
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
        .search_form{
            margin-top: 15px;
        }
       .format2{
           float: left;
           line-height: 40px;
           color: #1E9FFF;
           font-weight: 600;
           margin-top: 10px;
       }
       .box_input{
	        width: 210px;
		    float: left;
		    margin-top: 10px;
       }
	</style>
</head>
<body>
    <div class="layui-container">          
                <form class="layui-form" action="">
                        <div class="layui-form-item search_form">
                                <div class="layui-input-inline">
                                  <input type="text" name="address" value="" id="where" placeholder="请输入地点"  class="layui-input">
                                </div>
                                <button onClick="sear(document.getElementById('where').value);" type="button" class="layui-btn layui-btn-normal">确定</button>
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
                
                    
             <script src="layui/layui.js"></script>
    
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
    
layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
			
			
	loadline("slline",form,"../line/getlinelist");
	
    
   });
</script>
</body>

</html>