/**
 * 权限js
 */

/**
 * 加载添加按钮
 */
function addbtn(){
	var se_from=  document.getElementById("se_from");
		
		var elem = document.createElement("div");  
		elem.setAttribute("class","layui-inline"); 
		elem.setAttribute("id","add_btnsearch");
		
		var addbutton = document.createElement("button");  
		addbutton.setAttribute("class","layui-btn layuiadmin-btn-useradmin"); 
		addbutton.setAttribute("type","button"); 
		addbutton.setAttribute("id","btn_addcollege");
		addbutton.innerHTML="添加";
		elem.appendChild(addbutton);
		se_from.appendChild(elem);
};

/**
 * 是否加载编辑和删除按钮
 * @param type all加载所有 del/删除 edit/编辑
 */
function toolbar(type){
		if(type=="del"){
			var main="<a class='layui-btn layui-btn-danger layui-btn-xs' lay-event='del'><i class='layui-icon layui-icon-delete'></i>删除</a>";
			  
		}else if(type=="edit")
		{
			var main=" <a class='layui-btn layui-btn-normal layui-btn-xs' lay-event='edit'><i class='layui-icon layui-icon-edit'></i>编辑</a>";
			  
		}else if(type=="all")
		{
			var main=" <a class='layui-btn layui-btn-normal layui-btn-xs' lay-event='edit'><i class='layui-icon layui-icon-edit'></i>编辑</a><a class='layui-btn layui-btn-danger layui-btn-xs' lay-event='del'><i class='layui-icon layui-icon-delete'></i>删除</a>";
				  
		}
		$("#barDemo").html(main);
}

/**
 * 获取该页面当前角色可操作的列
 * @returns
 */
function getCompClos(){
	
	var reqdata={
			sysid:sessionStorage.getItem("sysid")
	};
	var resdata= callAJAX("post", "../roleaccess/geteditclosandbtn",reqdata );
	return resdata;
}


/**
 * 加载表格表头和列
 * @param oldColsAry 所有表头数组
 * @param compAryCols 权限表头数组
 * @returns {Array} 新的表头数组
 */
function returnNewCols(oldColsAry,compAryCols,btns){
	var type="";
	for(i in btns)
	{
   			if(btns[i]=="添加"){
   				addbtn();
   			}
   			else if(btns[i]=="编辑")
   			{
   				if(type!=null &&type!=""){
   					type="all";
   				}else {
   					type="edit";
   				}
   			}
   			else if(btns[i]=="删除"){
   				if(type!=null &&type!=""){
   					type="all";
   				}else {
   					type="del";
   				}
   			}
	} 
	//加载工具列的内容
	if(type!=null &&type!=""){
		toolbar(type);
	}
	 taskInfoColsAryNew = [];
     //console.log(oldAry);
     for (i in oldColsAry ) {
             //项目编号不显示
             //console.log(arr.indexOf(oldColsAry[i]["field"]))
    	 if(oldColsAry[i]["title"]=="序号"){
             taskInfoColsAryNew.push(oldColsAry[i]);
         }
         if(type!=null &&type!=""){ 
            if(oldColsAry[i]["title"]=="操作" ){
            	
            	taskInfoColsAryNew.push(oldColsAry[i]);
            }
         }
             if (compAryCols.indexOf(oldColsAry[i]["field"]) == -1) {
                 continue;
             }
            	 
         taskInfoColsAryNew.push(oldColsAry[i]);
     }
     return taskInfoColsAryNew;
}
