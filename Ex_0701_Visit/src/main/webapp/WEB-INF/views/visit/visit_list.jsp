<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- href="${pageContext.request.contextPath}/resources/css/visit.css" -->
	<link rel="stylesheet" href="/vs/resources/css/visit.css">

	<script src="${ pageContext.request.contextPath }/resources/js/httpRequest.js"></script>

	<script type="text/javascript">
		function del( f ) {
			
			var pwd = f.pwd.value;//원본 비밀번호
			var c_pwd = f.c_pwd.value;//입력한 비밀번호
			
			if( pwd != c_pwd ){
				 alert("비밀번호가 일치하지 않습니다");
				 return;
			}
			
			if( !confirm("정말 삭제하시겠습니까?") ){
				return;
			}
			
			//Ajax를 통해 삭제하고자 하는 idx를 전달
			var url = "delete.do";
			var param = "idx=" + f.idx.value;
			sendRequest(url, param, resultFn, "GET");
		}
		
		function resultFn() {
			//결과를 받을 콜백메서드
			if( xhr.readyState == 4 && xhr.status == 200 ){
				
				//data = "[{'res':'no'}]"
				var data = xhr.responseText;
				
				var json = eval(data);
				
				if( json[0].res == 'yes' ){
					alert("삭제성공");
					location.href = "list.do";
				}else{
					alert("삭제실패");
				}
				
			}
		}
		
		//수정
		function modify(f){
			var pwd = f.pwd.value; //원본 비밀번호
			var c_pwd = f.c_pwd.value;//입력받은 비밀번호
			
			if( pwd != c_pwd ){
				alert("비밀번호가 틀립니다");
				return;
			}
			
			f.action = 'modify_form.do';
			f.method = "post";
			f.submit();
		}
		
	</script>
</head>

<body>
	<div id="main_box">
		<h1>:::방 명 록:::</h1>
		<div align="center">
			<input type="button" value="새글쓰기" 
			       onclick="location.href='insert_form.do'">
		</div>
		
		<c:forEach var="vo" items="${ list }">
		
			<div class="visit_box">
				<div class="type_content"><pre>${ vo.content }</pre></div>
				
				<!-- 첨부된 이미지가 있을 때만 img 태그를 노출 -->
				<c:if test="${ vo.filename ne 'no_file' }">
					<img src="resources/upload/${vo.filename}" width="200">
				</c:if>
				<div class="type_name">${ vo.name }(${ vo.ip })</div>
				<div class="type_regdate">작성일:${ vo.regdate }</div>
				
				<div>
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }"> 
						<input type="hidden" name="pwd" value="${ vo.pwd }"> 
						
						비밀번호:<input type="password" name="c_pwd">
						
						<input type="button" value="수정" onclick="modify(this.form);">
						<input type="button" value="삭제" onclick="del(this.form);">
					</form>
				</div>
				
			</div>
		</c:forEach>
		
	</div>
</body>

</html>









