<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<body>
	<form>
		언어1 : <select id="source">
			<option value="ko">ko</option>
			<option value="en">en</option>
		</select> 
		언어2 : <select id="target">
			<option value="ko">ko</option>
			<option value="en">en</option>
		</select> 
		입력 : <textarea id="text"></textarea>
		<button type="button" onclick="trans()">번역</button>
		
		결과 : <textarea id="result" disabled></textarea>
	</form>
<script>
	function trans(){
		var source = document.querySelector('#source').value;
		var target = document.querySelector('#target').value;
		var text = document.querySelector('#text').value;
		var param = 'source=' + source + '&target=' + target + '&text=' + text;
		var result;
		var conf = {
				url : encodeURI('/trans?'+ param),
				success : function(res){
					alert(res);
				}
		};
		au.send(conf); 
	}
</script>
</body>
</html>