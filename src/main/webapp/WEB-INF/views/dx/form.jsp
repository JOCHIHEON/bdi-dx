<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }
</style>
</head>
<script>
	var wWidth = screen.width;
	var wHeight = screen.height;
	var dxForm,dxWin;
	var joinFormData = [
		{type:'fieldset',name:'join',label:'join',inputWidth:'auto',
			list:[
				{type:'input',name:'UIID',label:'아이디',validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'UIPWD',label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'UINAME',label:'이름',required:true},
				{type:'input',name:'UINICKNAME',label:'별명',required:true},
				{type:'input',name:'UIEMAIL',label:'이메일',required:true},
				{type:'input',name:'UIBIRTH',label:'생년월일',required:true},
				{type:'input',name:'UIPHONENO',label:'전화번호', required:true},
				{type:'radio',name:'UIGENDER',value:'1',label:'남', checked:true},
				{type:'radio',name:'UIGENDER',value:'0',label:'여'},
				{type:'button',name:'joinbtn',value:'JOIN'}
			]}
	]
	var loginFormData = [
		{type:'fieldset',name:'login',label:'login',inputWidth:'auto',
			list:[
				{type:'input',name:'uiid',label:'ID',validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'uipwd',label:'PWD',validate:'ValidAplhaNumeric',required:true},
				{type:'button',name:'loginbtn',value:'LOGIN'}
			]}
	]
	function doInit(){
		var layout = new dhtmlXLayoutObject({
		    parent: "layoutObj",
		    pattern: "2U",
		    cells: [
		    	{id:"a", text: "유저정보"},
				{id:"b", text: "유저수정", width: 300, collapse: true}
		    ]
		}); 
		var forms = [
			{type:'button',value:'로그인',name:'loginWin'},
			{type:'button',value:'회원가입',name:'joinWin'}
		]
		var uiGrid;
		uiGrid = new dhtmlXGridObject('dxGrid');
		uiGrid = layout.cells("a").attachGrid();
		uiGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
		uiGrid.setHeader('번호,아이디,이름,별명,이메일,생년월일,전화번호,성별');
		uiGrid.setColumnIds('uino,uiid,uiname,uinickname,uiemail,uibirth,uiphoneno,uigender');
		uiGrid.setColAlign('center,center,center,center,center,center,center,center');
		uiGrid.setColTypes('ro,ro,ro,ed,ed,ed,ed,ro');
		uiGrid.setColSorting('int,str,str,str,str,str,int,int');		
		uiGrid.init();		
		au.send({url:'/users',success:function(res){
			res= JSON.parse(res);
			uiGrid.parse(res,'js');
		}});
		var dxForm = new dhtmlXForm('dxForm',forms)
		dxForm.attachEvent('onButtonClick',function(name){
			if(name=='joinWin'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					w2 = dxWin.createWindow('w2',0,10,400,400);
					w2.setText('회원가입');
					w2.centerOnScreen();
					var joinForm = new dhtmlXForm('joinForm',joinFormData);
					dxWin.window('w2').attachObject('joinForm');
					joinForm.attachEvent('onButtonClick',function(name){
							if(name=='joinbtn'){
								if(joinForm.validate()){
									var uiid = joinForm.getItemValue('uiid');
									var uipwd = joinForm.getItemValue('uipwd');
									var uiname = joinForm.getItemValue('uiname');
									var uinickname = joinForm.getItemValue('uinickname');
									var uiemail = joinForm.getItemValue('uiemail');
									var uibirth = joinForm.getItemValue('uibirth');
									var uiphone = joinForm.getItemValue('uiphoneno');
									var uigender = joinForm.getItemValue('uigender');
									var conf = {
											url:'/users',
											method:'POST',
											param: JSON.stringify({uiid:uiid,uipwd:uipwd,uiname:uiname,uinickname:uinickname
												,uiemail:uiemail,uibirth:uibirth,uiphone:uiphone,uigender:uigender}),
											success : function(res){
												res = JSON.parse(res);
												alert(res.msg);
											}
									}
									au.send(conf);
								}
							}
						})
					}
			}else if(name=='loginWin'){
				if(!dxWin){
				dxWin = new dhtmlXWindows();
				w1 = dxWin.createWindow('w1',0,10,250,240);
				w1.setText('로그인');
				w1.centerOnScreen();
				var loginForm = new dhtmlXForm('loginForm',loginFormData);
				dxWin.window('w1').attachObject('loginForm');
				loginForm.attachEvent('onButtonClick',function(name){
						if(name=='loginbtn'){
							if(loginForm.validate()){
								var uiid = loginForm.getItemValue('uiid');
								var uipwd = loginForm.getItemValue('uipwd');
								var conf = {
										url:'/login',
										method:'POST',
										param: JSON.stringify({uiid:uiid,uipwd:uipwd}),
										success : function(res){
											res = JSON.parse(res);
											alert(res.msg);
										}
								}
								au.send(conf);
							}
						}
					})
				}
			}
		})
	}
	window.addEventListener('load',doInit)
</script>
<body>
<div id="layoutObj" style="position: relative; height: 600px;"></div>
<div id="dxGrid"></div>
<div id="dxForm" style="height:200px; float:right;"></div>
<div id="loginForm" style="width:200px;height:100px"></div>
<div id="joinForm" style="width:300px;height:500px"></div>
</body>
</html>