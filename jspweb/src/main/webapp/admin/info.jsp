<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<div class="container">
	
	<h3> chart.js 사용 </h3>
	
	<div>
  		<canvas id="myChart"></canvas>
	</div>
	
	
	<h3> 모든 회원 명단 </h3>
			<div class="adminpagebox">
			
		</div>
		<button onclick="setsearch()" type="button">전체보기[검색제거]</button>
		<div class="seachcount"> 총 회원 수 : </div>
		<select onchange="setlistsize()" class="listsize">
			<option>3</option>
			<option>5</option>
			<option>10</option>
		</select>
		<table class="mListTable" border="1">
	
		</table>
		<!-- 페이징처리 버튼들  -->

		<!-- 검색창 -->
		<div>
			<select class="key">	<!-- select 시 사용되는 조건의 필드명 -->
				<option value="mno">번호</option>
				<option value="mid">아이디</option>
				<option value="memail">이메일</option>
			</select>
			<input class="keyword" type="text">	<!-- select 시 사용되는 조건의 데이터 -->
			<button onclick="getsearch()" type="button">검색</button>
		</div>
		
		
	</div>
	<!-- chat.js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>

<!-- 2. + 개별 과제 : /jspweb/admin/info.jsp
	1. 회원목록 [ 페이징처리 , 검색처리(회원번호 , 아이디 , 이메일) ]

	제출 : ip주소 카톡에 제출
 -->