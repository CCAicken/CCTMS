<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" href="../layui/css/layui.css" />
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: rgb(209, 207, 207);
	overflow: hidden;
	overflow-y: scroll;
}

body::-webkit-scrollbar {
	display: none;
}
</style>
</head>

<body>
	<div class="layui-container">
		<div style="margin:10px auto;width:800px;">
			<div class="layui-card">
				<div class="layui-card-header"
					style="color: cornflowerblue;padding: 5px 0;">
					<h1 style="margin-left:20px">修改密码</h1>
				</div>
				<div class="layui-card-body">
					<div class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">账号</label>
							<div class="layui-input-block">
								<input type="text" disabled="disabled" id="userid"
									value="${loginuser.userid }" required lay-verify="required"
									placeholder="请输入账号" autocomplete="off"
									class="layui-input layui-bg-gray">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">旧密码</label>
							<div class="layui-input-block">
								<input type="password" id="oldpwd" required
									lay-verify="required" placeholder="请输入原登录密码" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">新密码</label>
							<div class="layui-input-block">
								<input type="password" id="newpwd" required
									lay-verify="required" placeholder="请输入新登录密码" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">密码确认</label>
							<div class="layui-input-block">
								<input type="password" id="confirmpwd" required
									lay-verify="required" placeholder="请再次输入新登录密码"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" id="btnSubmit">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../layui/layui.all.js" charset="utf-8"></script>
		<script type="text/javascript" src="../js/jquery-3.3.1.js" ></script>
<script>
	layui.use('layer',function() {
		var layer = layui.layer;
		$("#btnSubmit").click(function() {
			var newpwd = $("#newpwd").val();
			var confirmpwd = $("#confirmpwd").val();
			var oldpwd = $("#oldpwd").val();
			if (newpwd == oldpwd) {
				layer.msg("新密码与旧密码不能一致");
			} else if (newpwd != confirmpwd) {
				layer.msg("两次输入的密码不正确");
			} else {
				$.ajax({
					type : "POST",
					url : "../user/changepwd",
					contentType : 'application/x-www-form-urlencoded;charset=utf-8',
					data : {
						userid : $("#userid").val(),
						oldpwd : oldpwd,
						newpwd : newpwd
					},
					dataType : "text",
					success : function(data) {
						if (data == "修改成功") {
							layer.alert('修改成功，即将跳到主页',{
								skin : 'layui-layer-lan',
								closeBtn : 0
							},function() {
								if (top.location !== self.location) {
									top.location = "index.jsp";//跳出框架，并回到首页
								}
							});

						} else {
							layer.msg(data);
						}
					},
					error : function(e) {
						console.log(e);
					}
				});
			}
		})
	});
</script>
</html>