
var AjaxUtil = function(){
	var xhr,success,error;
	var init = function(conf){
		if(!conf || !conf.url){
			alert('url은 필수 입니다.conf변수를 확인해주세요.');
			return;
		}
		xhr = new XMLHttpRequest();
		conf.method = conf.method?conf.method:'GET';
		conf.param = conf.param?conf.param:'{}';
		success = conf.success?conf.success:function(res){
			alert(res);
		} 
		error = conf.error?conf.error:function(res){
			alert(res);
		}
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=="200"){
					success(xhr.responseText);
				}else{
					try{
						var res = JSON.parse(xhr.responseText);
						alert(res.errorMsg);
						return;
					}catch(e){
						
					}
					error(xhr.responseText);
				}
			}
		}
	} 
	
	this.send = function(conf){
		init(conf);
		xhr.open(conf.method,conf.url);
		if(conf.method!='GET'){
			xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
		} 
		xhr.send(conf.param);
	}
}