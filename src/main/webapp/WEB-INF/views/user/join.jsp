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
var dxForm,dxWin;
var joinFormData = [
	{type:'fieldset',name:'join',label:'join',inputWidth:'auto',
		list:[
			{type:'input',name:'uiid',label:'아이디',validate:'ValidAplhaNumeric',required:true},
			{type:'password',name:'uipwd',label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
			{type:'input',name:'uiname',label:'이름',required:true},
			{type:'input',name:'uinickname',label:'별명',required:true},
			{type:'input',name:'uiemail',label:'이메일',required:true},
			{type:'input',name:'uibirth',label:'생년월일',required:true},
			{type:'input',name:'uiphoneno',label:'전화번호', required:true},
			{type:'radio',name:'uigender',value:'1',label:'남', checked:true},
			{type:'radio',name:'uigender',value:'0',label:'여'},
			{type:'button',name:'joinbtn',value:'JOIN'}
		]}
]
var forms = [	
	{type:'button',value:'회원가입',name:'joinWin'}
]
dxForm = new dhtmlXForm('dxForm',forms)
dxForm.attachEvent('onButtonClick',function(name){
	if(name=='joinWin'){
		if(!dxWin){
			dxWin = new dhtmlXWindows();
			w2 = dxWin.createWindow('w1',0,10,400,400);
			w2.setText('회원가입');
			w2.centerOnScreen();
			var joinForm = new dhtmlXForm('joinForm',joinFormData);
			dxWin.window('w1').attachObject('joinForm');
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
	}
})
}
window.addEventListener('load',doInit)
</script>
<body>
<div id="dxForm" style="height:200px; float:right;"></div>
<div id="joinForm" style="width:300px;height:500px"></div>
</body>
</html>