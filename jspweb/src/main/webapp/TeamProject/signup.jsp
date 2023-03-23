<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<form class="signupForm">
			<h3>회원가입</h3>
			<div class="title">이름</div>
			<input class="mname" name="mname" type="text">
			
			
			<div class="title">아이디</div>
			<input class="mid" name="mid" type="text">
			
			<div class="title">비밀번호</div>
			<input class="mpwd" name="mpwd" type="text">
			
			<div class="title">사는장소</div>
			<input class="mresidence" name="mresidence" type="text">
			
			<div class="title">이메일</div>
			<input class="memail" name="memail" type="text">
			
			<div class="title">성별</div>
			<input type="radio" name="mmw" value="남">남
			<input type="radio" name="mmw" value="여">여			<br/>
			
			<div class="title">핸드폰번호</div>
			<input class="mphone" name="mphone" type="text">
			
			<div class="title">프로필</div>
			<input type="file" name="mimg" class="mimg">
			
			<button class="signupbtn" onclick="signup()" type="button">가입하기</button>
		</form>
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
	<script src="/jspweb/TeamProject/signup.js" type="text/javascript"></script>
	
</body>
</html>