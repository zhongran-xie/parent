<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery-1.7.2.min.js" type="text/javascript"></script>

</head>

<body>

<div class="admin_main">
		<div class="admin_bg">
			<img src="/images/admin_bg.jpg" alt="">
		</div>
		<div class="admin_inner">
			<div class="admin_left">
				<img src="/images/admin_logo.png" alt="">
			</div>
			<div class="admin_right">
				<div class="login_top">
					<h3>用户登录</h3>
				</div>
				<div class="login_box">
					<div class="login_inner">
            	        <p class="pp1">
            	            用户名：<input type="text" id="username" placeholder="请输入用户名">
            	        </p>
            	        <p class="pp2">
            	            密&nbsp;码：<input type="password" id="password" placeholder="请输入密码">
            	        </p>
            	        <p class="pp3 f_cf">
            	            <span>
            	            	验证码：<input type="text" id="authCode" placeholder="请输入验证码">
            	            </span>
            	            <a href="javascript:changeImage('/createCaptcha');" title="点击可刷新图片">
            	                <img id="yzmImg" src="/createCaptcha" style="width:90px; height: 100%;" alt="">
            	            </a>
            	        </p>
            	        <p id="msg" style="color:red;"></p>
            	        <p class="pp4">
            	        	<a href="javascript:;" id="submitBtn">登录</a>
            	        </p>
            	    </div>
				</div>
			</div>
		</div>
	</div>
<script src="/js/plugins/ligerUI/js/ligerui.min.js" type="text/javascript"></script>	
 <script type="text/javascript">
	$(function(){
		$("#submitBtn").click(function() {
			var name = $("#username").val().replace(/\t+/g, "").replace(/\n+/g, "").replace(/\r+/g, "").replace(/\s+/g, "");
			var pwd = $("#password").val().replace(/\t+/g, "").replace(/\n+/g, "").replace(/\r+/g, "").replace(/\s+/g, "");
			if (name == '') {
				$("#msg").html("用户名不能为空！");
				return;
			}
			if (pwd == '') {
				$("#msg").html("密码不能为空！");
				return;
			}
			var _authCode = $("#authCode").val().replace(/\t+/g, "").replace(/\n+/g, "").replace(/\r+/g, "").replace(/\s+/g, "");
			if (_authCode.length == 0) {
				$("#authCode").focus();
				$("#msg").html("验证码不能为空！");
			} else {
/* 				validateUser(name,pwd);
 */				 var isSuccess = validateAuthCode(_authCode);
				//验证码验证通过
				if(isSuccess){
					validateUser(name,pwd);
				} 
			}
		});
		document.onkeydown = function(e) {
			e = e || window.event;
			if (e.keyCode === 13) {
				$('#submitBtn').click();
			}
		};
		$("#yzmImg").click(function() {
			changeImage('/createCaptcha');
		});
		//不在iframe框架里登录，直接转到登录页面
		if (window != top) {
			top.location.href = location.href; 
		} 
		
	});

	//验证验证码
	 function validateAuthCode(_authCode){
		 var isSuccess = true;
		 var isSuccess = false;
		$.ajax({
			url:"/validateCaptcha",
			type:"post",
			async:false,
			data:{
				"authCode" : _authCode
				},
			success:function(data){
				if(data == 0){
					isSuccess = true;
				}else if(data == 1){
					$("#authCode").focus();
					$("#msg").html("验证码不正确！");
					changeImage('/createCaptcha');
				}else{
					$("#msg").html("系统出现错误！");
				}
			},error:function(){
				$("#msg").html("异步请求出错！");
			}
		}); 
		return isSuccess;
	} 

	//验证用户
	function validateUser(name,pwd){
		 $.ajax({
		    	url : "/login",
				type : "post",
				cache : false,
				data : {
					"userName" : name,
					"password" : pwd
				},
				 success : function(data) {
					 if (data == 0) {
						$("#submitBtn").attr('disabled', 'false'); //禁用提交按钮
						$("#submitBtn").attr("class",'resetbtn');
						window.location.href="/";
					}else if(data == "-1"){
						var msg = '用户不存在';
						$("#msg").html(msg);
						changeImage('/createCaptcha');
					}else if(data == "-2"){
						var msg = '用户名或密码错误';
						$("#msg").html(msg);
						changeImage('/createCaptcha');
					}else{
						var msg = '系统出现错误';
						$("#msg").html(msg);
						changeImage('/createCaptcha');
					} 
				},
				error : function(e) {
					$("#msg").text("系统出现异常!");
				}
			});
	}
	
	
	function cleanMsg() {
		$("#msg").text("");
	}
	/*刷新验证码图片*/
	function changeImage(_url) {
		$("#yzmImg").attr("src", _url+"?yzmtime="+new Date().getTime());
		
	}
</script> 

</body>


</html>