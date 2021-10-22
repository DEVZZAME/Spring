<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<script type="text/javascript">
		function send(f){
			
			var name = f.name.value;
			var content = f.content.value;
			var pwd = f.pwd.value;
			
			//유효성 체크
			if( name == '' ){
				alert('작성자 이름을 입력하세요');
				return;
			}
			
			if( content == '' ){
				alert("내용은 필수입니다.");
				return;
			}
			
			if( pwd == '' ){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			f.action = "insert.do";
			f.method = "post";
			f.submit();
			
		}
		
	</script>

</head>
<body>
	<form enctype="multipart/form-data" method="post">
		<table border="1" align="center">
			<caption>:::방명록 작성:::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content"></textarea></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<th>파일첨부</th>
				<td><input type="file" name="photo"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="send(this.form);">
					
					<input type="button" value="목록보기" 
					       onclick="location.href='list.do'">
					
				</td>
			</tr>
			
		</table>	
	</form>
</body>
</html>











