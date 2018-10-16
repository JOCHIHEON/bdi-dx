<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
<style>
#laydiv{
	margin : auto 0px;
	width : 100%;
	height : 100%;
}
</style>
<script>
	var dxLayDiv;
	function doInit(){
		dxLayDiv = new dhtmlXLayoutObject('laydiv','3L');
		dxLayDiv.cells('a').setText('Menu');
		dxLayDiv.cells('b').setText('header Grid');
		dxLayDiv.cells('c').setText('Item Grid');
	} 
	window.addEventListener('load',doInit);
</script>
</head>
<body>
	<div id="laydiv"></div>
</body>
</html>