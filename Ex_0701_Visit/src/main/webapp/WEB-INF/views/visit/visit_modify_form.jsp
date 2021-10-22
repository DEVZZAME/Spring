<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>

	<script type="text/javascript">
		function send(f) {
			var name = f.name.value.trim();
			var content = f.content.value.trim();
			var pwd = f.pwd.value.trim();
			
			if( name == '' ){
				alert("작성자의 이름을 입력하세요");
				return;
			}
			
			if( content == '' ){
				alert("내용을 입력하세요");
				return;
			}
			
			if( pwd == '' ){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			var url = "modify.do";
			var param = "idx="+f.idx.value+
						"&name="+name+
						"&content="+encodeURIComponent(content)+
						"&pwd="+encodeURIComponent(pwd);
			
			//modify.do로 접근하여 게시물을 수정하는 코드를 작성하시오
			//수정성공 or 수정실패의 alert()창을 띄워서 결과 알려주기!!
			sendRequest(url, param, resultFn, "POST");
		}
		
		function resultFn() {
			
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				//no 혹은 yes
				var data = xhr.responseText;
				
				if( data == 'no' ){
					alert("수정실패");
					return;
				}else{
					alert("수정성공");
					location.href='list.do';
				}
			}
			
		}
	</script>

</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${vo.idx}">
		
		<table border="1" align="center">
			<caption>:::방명록 수정:::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name" value="${ vo.name }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><pre><textarea name="content" rows="5" cols="50">${ vo.content }</textarea></pre></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정"
					       onclick="send(this.form);">
					       
					<input type="button" value="취소"
					       onclick="location.href='list.do'">       
				</td>
			</tr>
		</table>
	</form>
</body>
</html>














































