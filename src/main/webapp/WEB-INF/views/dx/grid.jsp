<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
	function doInit(){
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${gridPath}');
		dxGrid.setHeader('번호,이름,아이디');
		dxGrid.setColumnIds('num,name,id');
		dxGrid.setColTypes('ro,ed,ed');
		dxGrid.init();
		var data = [
			{num:1,name:'홍길동',id:'hong'}
		]
		dxGrid.parse(data,'js');
	}
	window.addEventListener('load',doInit);
</script>
<body>
	<div id="dxGrid" style="width:400px;height:300px"></div>
</body>
</html>