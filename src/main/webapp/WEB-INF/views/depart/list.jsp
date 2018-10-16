<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
	<link rel="stylesheet" type="text/css" href="${resPath}/dhtmlx/skins/skyblue/dhtmlx.css"/>
<script>
	var diGrid;
	window.addEventListener('load',function(){
		diGrid = new dhtmlXGridObject('divGrid');
		diGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
		diGrid.setHeader('번호,이름,설명,인원');
		diGrid.setColumnIds('dino,diname,didesc,dicnt');
		diGrid.setColAlign('center,center,center,center');
		diGrid.setColTypes('ro,ed,ed,ed');
		diGrid.setColSorting('int,str,str,int');
		diGrid.init();
		au.send({url:'/departs',success:function(res){
			res= JSON.parse(res);
			diGrid.parse(res,'js');
		}});
		
	});
</script>
</head>
<body>
<div id="divGrid" style="width:500px; height:350px; background-color:white;"></div>
</body>
</html>