<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/list.css" rel="stylesheet">

</head>
<body>

	<%@ include file= "/header.jsp" %>
	<%
		// 1. HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
		// 2. 표현식을 이용한 input , div 등등 대입
	%> 
	<!-- cno 숨겨서 js에게 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<!-- html/css -->
	<div class="container">
		<div class="boardbox">	<!-- 게시물리스트 출력 구역 -->
			<div class="boardtop">
				<h3 class="cname">공지사항</h3>
				<P>다양한 사람들과 정보를 공유 해보세요</P>
			</div>
			
			<div class="boardtopetc">
				<a href="write.jsp">
					<button class="bbtn"> <i class="fas fa-pencil-alt"></i>글쓰기</button>
				</a>
				<div>
					<span class="searchcount">게시물수 :</span>
					<button onclick="setsearch()" class="bbtn">전체보기</button>
					<select class="bbtn listsize" onchange="setlistsize()">
						<option>3</option>
						<option>5</option>
						<option>10</option>
					</select>
				</div>
			</div>
			
			<div class="boardTable">
			
			</div>
			
		
			
		</div>
		<div>
			<!-- 페이징처리 버튼들 -->
		
			
			
			<!-- 검색 버튼들 -->
			<div class="boardbottom">	
				<div class="pagebox">
				</div>
				<select class="key bbtn">				<!-- select 시 사용되는 필드명 -->
					<option value="b.btitle">제목</option>
					<option value="b.bcontent">내용</option>
					<option value="m.mid">작성자</option>
				</select>
				<input class="keyword" type="text">	<!-- select시 사용되는 조건의 데이터  -->
				<button class="bbtn" onclick="getsearch()" type="button">검색</button>
			</div>
		</div>
	</div>
	
	
	<div class="container">
		
		
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>