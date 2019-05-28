<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>后台管理系统</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link href="/js/plugins/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />

<script src="/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<style type="text/css">
.l-link {
	display: block; 
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
	text-decoration: underline;
	color: #333; 
}

.l-link2 {
	text-decoration: underline;
	color: white;
	margin-left: 2px;
	margin-right: 2px;
}

.l-layout-top {
	background: #102A49;
	color: White;
}

.l-layout-bottom {
	background: #E5EDEF;
	text-align: center;
}

#pageloading {
	position: absolute;
	left: 0px;
	top: 0px;
	background: white url('${ctx}/images/loading.gif') no-repeat center;
	width: 100%;
	height: 100%;
	z-index: 99999;
}

.l-link {
	display: block;
	line-height: 22px;
	height: 22px;
	padding-left: 16px;
	border: 1px solid white;
	margin: 4px;
}

.l-link-over {
	background: #FFEEAC;
	border: 1px solid #DB9F00;
}

.l-winbar {
	background: #2B5A76;
	height: 30px;
	position: absolute;
	left: 0px;
	bottom: 0px;
	width: 100%;
	z-index: 99999;
}

.space {
	color: #E7E7E7;
}
/* 顶部 */
.l-topmenu {
    background: url("${ctx}/images/top.jpg") repeat-x scroll center bottom ;
    border-top: 1px solid #1D438B;
    height: 43px;
    line-height: 43px;
    margin: 0;
    padding: 0;
    position: relative;
}

.l-topmenu-logo {
    background: url("${ctx}/images/logo.png") no-repeat 10px 5px ;
    color: #E7E7E7;
    font-size: 14px;
    line-height: 37px;
    padding-left: 50px;
}


.l-topmenu-welcome {
	position: absolute;
	height: 24px;
	line-height: 24px;
	right: 30px;
	top: 2px;
	color: #070A0C;
}

.l-topmenu-welcome a {
	color: #E7E7E7;
	text-decoration: underline
}
</style>
</head>
<body style="padding: 0px; background: #EAEEF5;">
	<div id="pageloading"></div>
	<div id="topmenu" class="l-topmenu">
		<div class="l-topmenu-logo">后台管理系统</div>
		<div class="l-topmenu-welcome">
			<span class="space"></span>
			<input type="image" src="${ctx}/images/limg03.jpg" style="height:40px;width:46px;" onclick="openDefaultPage()"/>
			<input type="image" src="${ctx}/images/limg04.jpg" style="height:40px;width:46px;" onclick="$.ligerDialog.open({ height: 700,width:600,url: '${ctx}/system/user/displayUserInfo.do?id=${adminUser.id}'});"/>
			<input type="image" src="${ctx}/images/limg05.jpg" style="height:40px;width:46px;" onclick="window.location.href = '${ctx}/loginOut'"/>
		</div>
	</div>
	<div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" title="主要菜单" id="accordion1">
			<div title="功能列表" class="l-scroll">
				<ul id="tree1" style="margin-top: 3px;"/>
			</div> 
		</div>
		<div position="center" id="framecenter">
		</div>

	</div>
	<div style="height: 40px; line-height: 15px; text-align: center;background:url(${ctx}/images/bottom.jpg) repeat-x;">
		<p style="color:#FFFFFF;">
		</br>
		</p>
    </div>
	<div style="display: none"></div>
<script src="/js/plugins/ligerUI/js/ligerui.min.js" type="text/javascript"></script>	
<script src="/js/indexdata.js" type="text/javascript"></script>


<script type="text/javascript">

    var gridArray$ = new Array();

	var tab = null;
	var accordion = null;
	var tree = null;
	var folded  = null;
	$(function() {

		//布局  
		$("#layout1").ligerLayout({
			leftWidth : 190,
			height : '100%',
			heightDiff : -44,
			space : 4,
			onHeightChanged : f_heightChanged
		});
		var height = $(".l-layout-center").height();
		
		//Tab
		$("#framecenter").ligerTab({
			height : height
		});

		//面板
		$("#accordion1").ligerAccordion({
			height : height - 24,
			speed : null
		});

		$(".l-link").hover(function() {
			$(this).addClass("l-link-over");
		}, function() {
			$(this).removeClass("l-link-over");
		});
		
		//树
		folded = $("#tree1").ligerTree({
			url : '/index',
			textFieldName : 'name',
			idFieldName : "id",
			checkbox : false,
			slide : true,
			nodeWidth : 120,
			method : 'post',
			parentIDFieldName : "parentId",
			onAfterAppend: function () {
				//folded.collapseAll();
			},
			onSelect : function(node) {
				if (!node.data.url)
					return;
// 				if(node.data.url.indexOf("/page/system/user.jsp") > 0){
// 					var tabid ='default';
// 					$(node.target).attr("tabid", tabid);
// 				}
				var tabid = node.data.name;
				if (!tabid) {
					tabid = new Date().getTime();
					$(node.target).attr("tabid", tabid);
				}
				
				
				var href=window.location.href;
				var nodeUrl=node.data.url;
				if (href.indexOf(".t.sandegy")>-1) {
					nodeUrl=nodeUrl.replace("admin.sandegy.com","admin.t.sandegy.com");
				}  
				f_addTab(tabid, node.data.name,nodeUrl);
			}
		});
		tab = $("#framecenter").ligerGetTabManager();
		accordion = $("#accordion1").ligerGetAccordionManager();
		tree = $("#tree1").ligerGetTreeManager();
		$("#pageloading").hide();
// 		f_addTab("default", "操作日志", "${ctx}/page/system/operationlog.jsp");
		
		openDefaultPage();
		
		//不在iframe框架里打开首页
		if (window != top) {
			top.location.href = location.href; 
		}
		
	});
	
	function openDefaultPage(){
		$.ajax({
			url : "/getRoleIndex",
			async : false,
			type : "post",
			success : function(data){
				 //var msg = eval("(" + data + ")"); //转换为json
				 
				f_addTab("default", "首页", '${ctx}'+data.indexUrl);
			},
			error: function(){alert("请求服务错误")}
		});
	}
	
	function f_heightChanged(options) {
		if (tab)
			tab.addHeight(options.diff);
		if (accordion && options.middleHeight - 24 > 0)
			accordion.setHeight(options.middleHeight - 24);
	}
	
	/* 打开页面  */
	function f_addTab(tabid, text, url) {
		tab.addTabItem({
			tabid : tabid,
			text : text,
			url : url
		});
	}
</script>

</body>
</html>
