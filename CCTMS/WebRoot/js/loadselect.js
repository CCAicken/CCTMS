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

/**
 * 线路信息下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadline(selectId, form, reqURL){
	var reqType = 'post';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara)
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value='0'>请选择线路</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i].lid + '>' + stageData.data[i].taskname + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到线路信息！', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到线路信息！', function(){});
	}
	
}

/**
 * 管理员角色信息下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadAdminRole(selectId, form){
	var reqType = 'post';
	var reqURL = '../adminrole/getrole';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara)
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择管理员角色类型</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i].id + '>' + stageData.data[i].name + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到用户角色信息！', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到用户角色信息！', function(){});
	}
	
}

/**
 * 系统日志操作类型下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadSystemOperType(selectId, form){
	var reqType = 'post';
	var reqURL = '../adminsystem/getopertype';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择日志类型</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i] + '>' + stageData.data[i] + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到日志类型', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到日志类型！', function(){});
	}
}


/**
 * 下拉框加载
 * @param type college class major
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadSelect(type,selectId, form){
	var reqType = 'post';
	var reqURL = '';
	if(type=="college"){
		reqURL = '../select/selectcollege';
	}if(type=="class"){
		reqURL = '../select/selectclasses';
	}if(type=="major")
	{
		reqURL = '../select/selectmajor';
		
	}
	
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			if(type=="college"){
				var str = "<option value=''>请选择学院</option>";
			}if(type=="class"){
				var str = "<option value=''>请选择班级</option>";
			}if(type=="major")
			{
				var str = "<option value=''>请选择专业</option>";
			}
			
			for(var i = 0; i < stageData.data.length; i++) {
				 if(type=="college"){
					str += '<option value=' + stageData.data[i]['collegeid'] + '>' + stageData.data[i]['collegename'] + '</option>';
				}if(type=="class"){
					str += '<option value=' + stageData.data[i]['classid'] + '>' + stageData.data[i]['classname'] + '</option>';
					
				}if(type=="major")
				{
					str += '<option value=' + stageData.data[i]['majorid'] + '>' + stageData.data[i]['majorname'] + '</option>';
				}
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取信息', function(){});
	}
}


/**
 * 学院下拉框默认值
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadCollegeSelected(selectId,collegeid, form){
	var reqType = 'post';
	var reqURL = '../select/selectcollege';
	var reqPara = {collegeid:collegeid};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择学院</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				if(collegeid==stageData.data[i]['collegeid'])
				{
						str += '<option value=' + stageData.data[i]['collegeid'] + " selected='selected'"+'>' + stageData.data[i]['collegename'] + '</option>';
				}else{
						str += '<option value=' + stageData.data[i]['collegeid'] + '>' + stageData.data[i]['collegename'] + '</option>';
				}	
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到专业信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到专业信息', function(){});
	}
}



/**
 * 根据学院id 专业下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadMajorSelectByCollegeid(selectId,collegeid, form){
	var reqType = 'post';
	var reqURL = '../select/selectmajorbycollegeid';
	var reqPara = {collegeid:collegeid};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择专业</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i]['majorid'] + '>' + stageData.data[i]['majorname'] + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到专业信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到专业信息', function(){});
	}
}


/**
 * 根据专业id 班级下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadClassSelectByMajor(selectId,majorid, form){
	var reqType = 'post';
	var reqURL = '../select/selectclassesbymajor';
	var reqPara = {majorid:majorid};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择班级</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i]['classid'] + '>' + stageData.data[i]['classname'] + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到班级信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到班级信息', function(){});
	}
}
/**
 * 根据学院id  班级下拉框动态加载
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadclassSelectByCollegeid(selectId, collegeid,form){
	var reqType = 'post';
	var reqURL = '../select/selectclassesbycollegeid';
	var reqPara = {collegeid:collegeid};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择班级</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i]['classid'] + '>' + stageData.data[i]['classname'] + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到班级信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到班级信息', function(){});
	}
}


/**
 * 加载管理员用户类型下拉框
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadRoleType(selectId,form){
	var reqType = 'post';
	var reqURL = '../adminrole/getrole';
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara);
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择用户类型</option>";
			for(var i = 0; i < stageData.data.length; i++){
						str += '<option value=' + stageData.data[i].id + '>'+ stageData.data[i].name +'</option>';
			 }
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到用户类型信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到用户类型信息', function(){});
	}
}


/**
 * 获取比赛项目下拉框
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadSelectProject(selectId,type, form){
	var reqType = 'post';
	var reqURL = '';
	var reqPara = {};
	if(type=="all"){
		 reqURL = '../select/selectproject';
	}else if(type=="now"){
		 reqURL = '../select/selectprojectnow';
	} else{
	 	reqURL = '../select/selectprojectbysportid';
		reqPara = {sportid:type}
	}
	var stageData = callAJAX(reqType, reqURL, reqPara)
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择项目</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				str += '<option value=' + stageData.data[i].proid + '>' + stageData.data[i].proname + '</option>';
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到用户角色信息！', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到用户角色信息！', function(){});
	}
	
}


/**
 * 获取比赛项目下拉框
 * @param {Object} selectId 要加载到的select控件的id属性名称
 * @param {Object} form layui表单依赖参数form.render("select")，重新渲染
 */
function loadSport(selectId,type, form){
	var reqType = 'post';
	var reqURL = '';
	var reqPara = {};
	if(type=="all"){
		 reqURL = '../select/selectsport';
	}else if(type=="now"){
		 reqURL = '../select/selectsportnow';
	}
	var stageData = callAJAX(reqType, reqURL, reqPara)
	if(stageData != '' && stageData != undefined) {
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value='0'>请选择运动会</option>";
			//alert(stageData.data.length);
			for(var i = 0; i < stageData.data.length; i++) {
				if(stageData.data.length==1)
				{
					str += '<option value=' + stageData.data[i].sportid + ' selected >' + stageData.data[i].sportname + '</option>';
				}else{
					str += '<option value=' + stageData.data[i].sportid + '>' + stageData.data[i].sportname + '</option>';
				}
				
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到用户角色信息！', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到用户角色信息！', function(){});
	}
	
}

function loadmajoridSelected(selectId,majorid, form){
	var reqType = 'post';
	var reqURL = '../select/selectmajor'; 
	var reqPara = {};
	var stageData = callAJAX(reqType, reqURL, reqPara);  
	if(stageData != '' && stageData != undefined) { 
		if(stageData.code == 0) {
			$('#' + selectId).html(""); //获取id为selectId指定的控件内容
			var str = "<option value=''>请选择专业</option>";
			for(var i = 0; i < stageData.data.length; i++) {
				if(majorid==stageData.data[i]['majorid'])
				{
						str += '<option value=' + stageData.data[i]['majorid'] + " selected='selected'"+'>' + stageData.data[i]['majorname'] + '</option>';
				}else{
						str += '<option value=' + stageData.data[i]['majorid'] + '>' + stageData.data[i]['majorname'] + '</option>';
				}	
			}
			$('#' + selectId).append(str);
			form.render("select");
		} else {
			//layer.msg("未获取到阶段信息！");
			layer.msg('未获取到信息', function(){});
		}
	} else {
		//layer.msg("阶段信息获取失败！");
		layer.msg('未获取到信息', function(){});
	}
}

