<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<HTML>

<HEAD>
    <TITLE> ZTREE DEMO </TITLE>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="../js/jquery.ztree.all.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=20191112103629"></script>

    <script src="../layui/layui.all.js" charset="utf-8"></script>
    <SCRIPT LANGUAGE="JavaScript">
     
        //进入页面 初始化 位置tab页的地图
    function initMap() {
 
        $("#allmap").empty();
        var map = new BMap.Map("allmap");
        //设置一个 默认的位置。
        var point = new BMap.Point(114.3162001, 30.58108413);
        map.centerAndZoom(point, 12);
        map.enableScrollWheelZoom(true);
 
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function (r) {
            if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
            }
            else {
                alert('failed' + this.getStatus());
            }
        }, {enableHighAccuracy: true});
        map.addEventListener("click", function (e) {
 
            //获取当前点击 位置的经纬度，并显示在文本框中
            document.getElementById('latitude').value = e.point.lat;
            document.getElementById('longitude').value = e.point.lng;
            map.clearOverlays();
            var new_point = new BMap.Point(e.point.lng, e.point.lat);
            var new_mk = new BMap.Marker(new_point);
            map.addOverlay(new_mk);
            map.panTo(new_point);
 
 
            var gc = new BMap.Geocoder();
            gc.getLocation(new_point, function (rs) {
                //获取当前点击 位置的 省市县，街道号 和街道名称。并显示在 文本框中
                //街道号 和街道名称 不一定能获取到，有时候为空。
                var addComp = rs.addressComponents;
                $("#province-map").val(addComp.province);
                $("#city-map").val(addComp.city);
                $("#district-map").val(addComp.district);
                $("#room-address-map").val(addComp.streetNumber);
                $("#map-address").val(addComp.street);
            });
        });
        }
        

    </SCRIPT>
</HEAD>

<BODY>
    
    <div id="allmap" style="height:500px; margin: 0 10px 10px;"></div>
    
   
    <button onclick="zTreeOnClick();send()">确定</button>
</BODY>

</HTML>