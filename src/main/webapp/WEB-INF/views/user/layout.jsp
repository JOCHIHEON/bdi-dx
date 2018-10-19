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
	var layout;
	var updateFormData = [
	    {type: "block", list:[
	        {type:"fieldset",  label:"details", width:270, list:[
	        	{type:'number',name:'uino',label:'번호',validate:'ValidAplhaNumeric'},
	        	{type:'input',name:'uiid',label:'아이디',validate:'ValidAplhaNumeric'},
				{type:'password',name:'uipwd',label:'비밀번호',validate:'ValidAplhaNumeric'},
				{type:'input',name:'uiname',label:'이름'},
				{type:'input',name:'uinickname',label:'별명'},
				{type:'input',name:'uiemail',label:'이메일'},
				{type:'input',name:'uibirth',label:'생년월일'},
				{type:'input',name:'uiphoneno',label:'전화번호'},
				{type:'block',list:[
					{type:'label',label:'성별'},
					{type:"newcolumn"}, 
			        {type:"radio", name:"uigender", value:'1',label:'Man',  offsetTop:10},
			        {type:"newcolumn"},
			        {type:"radio", name:"uigender", value:'0',label:'Woman',  offsetTop:10}
			    ]},
				{type:"block", list:[
			        {type:"button", name:"updatebtn", value:"수정",  offsetTop:10},
			        {type:"newcolumn"},
			        {type:"button", name:"deletebtn", value:"삭제",  offsetTop:10}
			    ]}
	    ]}]}
	];
	function doInit(){
		layout = new dhtmlXLayoutObject('laydiv','2U');
		layout.cells('a').setText('Menu');
		layout.cells('b').setText('header Grid');
		var updateform = new dhtmlXForm("box", updateFormData);
		updateform = layout.cells("b").attachForm(updateFormData);
	} 
	window.addEventListener('load',doInit);
</script>
</head>
<body>
	<div id="laydiv"></div>
	<div id="box" style="width:250px; height:160px; background-color:white;"></div>
</body>
</html>