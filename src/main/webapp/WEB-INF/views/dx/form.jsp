<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
<style>
    html, body {
        width: 100%;
        height: 100%;
        overflow: hidden;
        margin: 0px;
    }
</style>
</head>
<script>
	var wWidth = screen.width;
	var wHeight = screen.height;
	var dxForm,dxWin,updateForm;
	var idDupChk = false;
	var userData = new dhtmlXDataStore;
	var joinFormData = [
		{type:'fieldset',name:'join',label:'join',inputWidth:'auto',
			list:[
				{type:'block',list:[
					{type:'input',name:'uiid',label:'아이디',validate:'ValidAplhaNumeric',required:true},
					{type:"newcolumn"},
					{type:'button',name:'chkDupId',value:'중복체크'}
				]},
				{type:'password',name:'uipwd',label:'비밀번호',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'uiname',label:'이름',required:true},
				{type:'input',name:'uinickname',label:'별명',required:true},
				{type:'input',name:'uiemail',label:'이메일',required:true},
				{type:'input',name:'uibirth',label:'생년월일',required:true},
				{type:'input',name:'uiphoneno',label:'전화번호', required:true},
				{type:'block',list:[
					{type:'label',label:'성별'},
					{type:"newcolumn"},
			        {type:"radio", name:"uigender", value:'1',label:'남', checked:true,  offsetTop:10},
			        {type:"newcolumn"},
			        {type:"radio", name:"uigender", value:'0',label:'여',  offsetTop:10}
			    ]},
			    {type:'hidden',name:'uiactive', value:'1'},
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
	var updateFormData = [
		{type: "block", list:[
	        {type:"fieldset",  label:"상세정보", width:270, list:[
	        	{type:'input',name:'uino',label:'번호', validate:'ValidInteger'},
	        	{type:'input',name:'uiid',label:'아이디',value:'',validate:'ValidAplhaNumeric'},
				{type:'password',name:'uipwd',label:'비밀번호',value:'',validate:'ValidAplhaNumeric'},
				{type:'input',name:'uiname',label:'이름',value:''},
				{type:'input',name:'uinickname',label:'별명',value:''},
				{type:'input',name:'uiemail',label:'이메일',value:''},
				{type:'input',name:'uibirth',label:'생년월일',value:''},
				{type:'input',name:'uiphoneno',label:'전화번호',value:''},
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
	]
	function doInit(){
		var layout = new dhtmlXLayoutObject({
		    parent: "layoutObj",
		    pattern: "2U",
		    cells: [
		    	{id:"a", text: "유저정보"},
				{id:"b", text: "유저수정", width: 300}
		    ]
		});
		var forms = [
			{type:'button',value:'로그인',name:'loginWin'},
			{type:"newcolumn"},
			{type:'button',value:'회원가입',name:'joinWin'}
		]
		var uiGrid;
		uiGrid = new dhtmlXGridObject('dxGrid');
		uiGrid = layout.cells("a").attachGrid();
		uiGrid.setImagePath('${resPath}/dhtmlx/skins/skyblue/imgs/dhxgrid_skyblue/');
		uiGrid.setHeader('번호,아이디,이름,별명,이메일,생년월일,전화번호,성별');
		uiGrid.setColumnIds('uino,uiid,uiname,uinickname,uiemail,uibirth,uiphoneno,uigender');
		uiGrid.setColAlign('center,center,center,center,center,center,center,center');
		uiGrid.setColTypes('ro,ro,ed,ed,ed,ed,ed,ro');
		uiGrid.setColSorting('int,str,str,str,str,str,int,int');
		uiGrid.init();
		au.send({url:'/users',success:function(res){
			res= JSON.parse(res);
			uiGrid.parse(res,'js');
		}});
		var dxForm = new dhtmlXForm('dxForm',forms);
		dxForm.attachEvent('onButtonClick',function(name){
			if(name=='joinWin'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					w1 = dxWin.createWindow('w1',0,10,390,380);
					w1.setText('회원가입');
					w1.centerOnScreen();
					var joinForm = new dhtmlXForm('joinForm',joinFormData);
					dxWin.window('w1').attachObject('joinForm');
					joinForm.attachEvent('onButtonClick',function(name){
						if(name=="chkDupId"){
							var uiid;
							uiid = joinForm.getItemValue('uiid');
							if(uiid==""){
								alert("아이디를 입력해주세요");
								return;
							}
							var conf = {
								url:'/user/chkDupId/'+uiid,
								method:'GET',
								param: JSON.stringify({uiid:uiid}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
										idDupChk=false;
										if(res.chkDupId=='success'){
											idDupChk=true;
										}
										if(idDupChk==false){
											alert("아이디 중복체크를 다시 해주세요.");
											joinForm.disableItem('joinbtn')
											return;
										}else if(idDupChk==true){
											joinForm.enableItem('joinbtn');
										}
									}
								}
								au.send(conf);
						}else if(name=='joinbtn'){
							if(idDupChk==0){
								alert("아이디 중복체크를 해주세요.");
								joinForm.disableItem('joinbtn')
								return;
							}if(joinForm.validate()){
								var uiid = joinForm.getItemValue('uiid');
								var uipwd = joinForm.getItemValue('uipwd');
								var uiname = joinForm.getItemValue('uiname');
								var uinickname = joinForm.getItemValue('uinickname');
								var uiemail = joinForm.getItemValue('uiemail');
								var uibirth = joinForm.getItemValue('uibirth');
								var uiphoneno = joinForm.getItemValue('uiphoneno');
								var uigender = joinForm.getItemValue('uigender');
								var uiactive = joinForm.getItemValue('uiactive');
								var conf = {
										url:'/users',
										method:'POST',
										param: JSON.stringify({uiid:uiid,uipwd:uipwd,uiname:uiname,uinickname:uinickname
											,uiemail:uiemail,uibirth:uibirth,uiphoneno:uiphoneno,uigender:uigender,uiactive:uiactive}),
										success : function(res){
											res = JSON.parse(res);
											alert(res.msg);
											location.href='/uri/dx/form';											}
								}
								au.send(conf);
							}
						}
					})
				}
			}else if(name=='loginWin'){
				if(!dxWin){
				dxWin = new dhtmlXWindows();
				w2 = dxWin.createWindow('w2',0,10,250,240);
				w2.setText('로그인');
				w2.centerOnScreen();
				var loginForm = new dhtmlXForm('loginForm',loginFormData);
				dxWin.window('w2').attachObject('loginForm');
				loginForm.attachEvent('onButtonClick',function(name){
						if(name=='loginbtn'){
							if(loginForm.validate()){
								var uiid = loginForm.getItemValue('uiid');
								var uipwd = loginForm.getItemValue('uipwd');
								var conf = {
										url:'/user/login',
										method:'POST',
										param: JSON.stringify({uiid:uiid,uipwd:uipwd}),
										success : function(res){
											res = JSON.parse(res);
											alert(res.msg);
											location.href='/uri/dx/form';
										}
								}
								au.send(conf);
							}
						}
					})
				}
			}
		})
		updateForm = new dhtmlXForm("updateForm", updateFormData);
		updateForm = layout.cells("b").attachForm(updateFormData);
		updateForm.setReadonly("uino", true);
		updateForm.setReadonly("uiid", true);
		updateForm.attachEvent("onChange", function(){
			updateForm.save();
			uiGrid.callEvent("onGridReconstructed",[])
		});
		updateForm.bind(uiGrid);
		updateForm.attachEvent('onButtonClick',function(name){
			if(name=='updatebtn'){
				var uino = updateForm.getItemValue('uino');
				var uiid = updateForm.getItemValue('uiid');
				var uipwd = updateForm.getItemValue('uipwd');
				var uiname = updateForm.getItemValue('uiname');
				var uinickname = updateForm.getItemValue('uinickname');
				var uiemail = updateForm.getItemValue('uiemail');
				var uibirth = updateForm.getItemValue('uibirth');
				var uiphoneno = updateForm.getItemValue('uiphoneno');
				var uigender = updateForm.getItemValue('uigender');
				var conf = {
						url:'/users/'+uino,
						method:'PUT',
						param: JSON.stringify({uino:uino,uiid:uiid,uipwd:uipwd,uiname:uiname,uinickname:uinickname
							,uiemail:uiemail,uibirth:uibirth,uiphoneno:uiphoneno,uigender:uigender}),
						success : function(res){
							res = JSON.parse(res);
							alert(res.msg);
							location.href='/uri/dx/form';
						}
				}
				au.send(conf);
			}else if(name=='deletebtn'){
				var uino = updateForm.getItemValue('uino');
				var conf = {
						url:'/users/'+uino,
						method:'DELETE',
						param: JSON.stringify({uino:uino}),
						success : function(res){
							res = JSON.parse(res);
							alert(res.msg);
							location.href='/uri/dx/form';
						}
				}
				au.send(conf);
			}
		})
	}
	window.addEventListener('load',doInit)
</script>
<body>
<div id="dxForm" style="height:200px; float:right;"></div>
<div id="layoutObj" style="position: relative;height: 600px;margin-top: 50px;">
	<div id="updateForm" style="width:250px; height:160px; background-color:white;"></div>
	<div id="loginForm" style="width:200px;height:100px"></div>
	<div id="joinForm" style="width:370px;height:500px"></div>
</div>
<div id="dxGrid"></div>
</body>
</html>