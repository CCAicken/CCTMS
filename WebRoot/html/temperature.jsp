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
		<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.js'></script>
    
</head>
<body>
    <div class="bar-chart" style="width:80% !important;height:400px!important;float:left; position:relative">
       
        <canvas id="currentWeekChart" width="400" height="300"></canvas>
    </div>
    
            
</body>    
 	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
    
<script>
    window.onload=function(){
    	var laid = GetRequest().laid;
    	var reqURL = '../report/getloacd?laid='+laid;
    	var reqType = 'post';
    	var reqPara = {};
    	var stageData = callAJAX(reqType, reqURL, reqPara);
        var data = {
            //定义数据集合
            labels: [stageData.data[6].createTime,
            		 stageData.data[5].createTime,
            		 stageData.data[4].createTime, 
            		 stageData.data[3].createTime, 
            		 stageData.data[2].createTime, 
            		 stageData.data[1].createTime, 
            		 stageData.data[0].createTime
            		 ],
            datasets: [
                {
                    label: "1号车温度",
                    backgroundColor: "rgba(0, 0, 0, 0.1)",//线条填充色
                    pointBackgroundColor:"rgba(255,48,48,0.2)",//定点填充色
                    data: [stageData.data[6].realtimet,
            		 stageData.data[5].realtimet,
            		 stageData.data[4].realtimet, 
            		 stageData.data[3].realtimet, 
            		 stageData.data[2].realtimet, 
            		 stageData.data[1].realtimet, 
            		 stageData.data[0].realtimet]
                },
                
            ]
        };
        var options = {
            //
        };
        //配置options选项，创建一个空的options选项

        var ctx = document.getElementById("currentWeekChart").getContext("2d");
        //获取canvas画布
        var currentWeekChart = new Chart(ctx,{
            type: 'line',
            data: data,
            options:options
        });

    }
    /**
 * ajax调用方法
 * @param {Object} reqType 请求的类型（get，post）
 * @param {Object} reqURL 要请求的路径
 * @param {Object} reqPara 要传递的参数列表，如{ op: 1, key: 2 }
 * @return {Object} returndata 查询结果
 */
function callAJAX(reqType, reqURL, reqPara) {
	var returndata = '';
	$.ajax({
		type: reqType,
		url: reqURL,
		datatype: 'json',
		async: false,//不做异步刷新，解决执行顺讯问题
		data: reqPara,
		success: function(data) {
			returndata = data;
		},
		error: function() {
			returndata = '';
		}
	});
	return returndata;
}

function GetRequest() {   
   var url = window.location.search; //获取url中"?"符后的字串   
   var theRequest = new Object();   
   if (url.indexOf("?") != -1) {   
      var str = url.substr(1);   
      strs = str.split("&");   
      for(var i = 0; i < strs.length; i ++) {   
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
      }   
   }   
   return theRequest;   
} 
    </script>
   
</body>

</html>