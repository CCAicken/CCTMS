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
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
     <script src="js/layer.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/echarts.min.js"></script>
    <script src="../layui/layui.all.js" charset="utf-8"></script>
    
</HEAD>

<body>
        
<div class="t2_box_con" style="padding:0px 10px 0px;">
    <!-- 此处加载图像 -->
    <div id="rllfx" style="width: 100%; height: 242px;"></div>
</div>

</body>

<script type="text/javascript">
    var XData = ['周一', '周二', '周三', '周四', '周五', '周六', '周日'];
    var YData = [10, 23, 65, 36, 85, 43, 60];
    var rllfx = echarts.init(document.getElementById("rllfx"));
    var option = {
        /* 线条颜色，可设置多个颜色 */
        color: ['#ffa82f'],
        /* 图像四周边距设置 */
        grid:{
            left:30,
            top:30,
            right:20,
            bottom:30
	 },
	 /* 图例说明 */
	 legend: {
	     // 图例排项 vertical-"竖向"; horizontal-"横向"
             orient: 'horizontal', 
             // 图例组件离容器左侧的距离
            right : 60,
	    top: 0,
	    //图例文字的样式
	    textStyle:{
	    	color:'#6ab2ec',
	    },
            // 与series中每个name一一对应
            data:['人流量']
        },
	 /* 鼠标悬浮时显示数据 */
	 tooltip : {
             trigger: 'axis',
             axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                 type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
             }
         },
        xAxis: {
            type: 'category',
            data: XData,
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    color:'#6ab2ec',
                }
             },
             //调整x轴的lable
             axisLabel:{   
                textStyle:{
                fontSize:10 // 让字体变小
                }
            } 
        },
        yAxis: {
            type: 'value',
            // 控制网格线是否显示
            splitLine: {
                 show: true, 
                 //  改变轴线颜色
                 lineStyle: {
                     // 使用深浅的间隔色
                     color: ['#132a6e']
                 }                            
             },
            //设置轴线的属性
            axisLine:{
                 lineStyle:{
                     color:'#6ab2ec',
                 }
             } 
        },
        /* 数据配置，若有多条折线则在数组中追加{name: , data: } */
        series: [{
            name:'人流量',
            data: YData,
            type: 'line',
            symbol: 'circle',
            // 设置折点大小
            symbolSize: 10,
            // 设置为光滑曲线
            smooth: true
        },]
    };
     rllfx.setOption(option);
</script>


</HTML>