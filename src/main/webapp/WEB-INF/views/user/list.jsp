<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
	<link rel="stylesheet" type="text/css" href="${resPath}/dhtmlx/skins/skyblue/dhtmlx.css"/>
<script>
	var uiGrid;
	window.addEventListener('load',function(){
		uiGrid = new dhtmlXGridObject('divGrid');
		uiGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
		uiGrid.setHeader('번호,아이디,이름,별명,이메일,생년월일,전화번호,성별');
		uiGrid.setColumnIds('UINO,UIID,UINAME,UINICKNAME,UIEMAIL,UIBIRTH,UIPHONENO,UIGENDER');
		uiGrid.setColAlign('center,center,center,center,center,center,center,center');
		uiGrid.setColTypes('ro,ro,ro,ed,ed,ed,ed,ro');
		uiGrid.setColSorting('int,str,str,str,str,str,int,int');
		uiGrid.init();
		au.send({url:'/users',success:function(res){
			res= JSON.parse(res);
			uiGrid.parse(res,'js');
		}});
		
	});
</script>
</head>
<body>
<div id="divGrid" style="width:500px; height:350px; background-color:white;"></div>
</body>
</html>
