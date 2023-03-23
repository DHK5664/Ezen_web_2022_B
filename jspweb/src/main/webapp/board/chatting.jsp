<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="/jspweb/css/chatting.css" rel="stylesheet">

</head>
<body>

	<%@include file="/header.jsp" %>
	<div class="container chattingwrap">
	
		<div class="connectlistbox">	<!-- 접속 명단 표시 구역 -->
			
		</div>
		<div class="chattingbox">	<!-- 채팅구역 -->
			
			<div class="contentbox"> <!-- 채팅창 -->
				
				
			</div>
				<!-- form-control 부트스트랩(bs) -->
			<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
			
			<div class="chattingbtnbox">
				
				<!-- 
					bs : 드롭다운
						클릭위치에 data-bs-toggle="dropdown"
						드롭다운시 표시할 위치 : "dropdown-menu"	
				 -->
				<!-- 드롭다운 버튼 -->
				<button class="emobtn" type="button" data-bs-toggle="dropdown"> <i class="far fa-smile"></i> </button>
				
				<!-- 드롭다운 버튼 클릭시 보이는 구역 -->
				<div class="dropdown-menu emolist">	</div>
				
				<button onclick="보내기()" class="sendbtn" type="button">보내기</button>
			</div>
			
			
			
		</div>
	</div>
<!-- 	
			<div class="connectbox">	
				<div> <img alt="" src="/jspweb/member/pimg/default.webp" class="hpimg"> </div>
				<div class="name">강호동</div>
			</div>

	보낼때 [ 시간 , 내용 ]
				
				<!-- 알람 -->
				<!-- <div class="alarm">
					<span> 강호동님이 입장 하셨습니다. </span>
				</div> -->
				<!-- 받을때 [ 프로필 , 시간 ,내용 ]
				
	
 -->	
<!-- 	
			채팅 내용물 표시되는 구역
		<div class="contentbox"></div>
			채팅 입력창
		<textarea class="msgbox" rows="" cols=""></textarea>
			채팅 전송버튼
		<button onclick="보내기()" type="button"> 보내기 </button>
	</div>	 -->
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>

</body>
</html>