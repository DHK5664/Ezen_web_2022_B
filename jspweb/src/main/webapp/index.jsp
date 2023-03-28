<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">	<!--  가로/세로 사이즈 생략시 auto(내용물 크기만큼) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height: 100%">
	<%@ include file="/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox">
		검색창
	</div>
	
	<div class="contentbox">
		<!-- 지도 -->
		<div id="map" style="width:75%;height:100%;"></div>
		<!-- 사이드바 -->
		<div class="productlistbox">
		
			
		</div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f2696c7ce73b2c3c992ea91cbfd4905&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
	
	<!-- <div class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/notebook.webp">
				</div>
				<div class="pcontentbox">
					<div class="pdate"> 2023-03-28  </div>
					<div class="pname"> LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다.LG노트북 팝니다. </div>
					<div class="pprice"> 가격 : 3,000원 </div>
					<div class="petc">  
						<i class="far fa-eye"></i>30
						<i class="far fa-thumbs-up"></i>5
						<i class="far fa-comment-dots"></i>2
					</div>
				</div>
			</div> -->
	
	<!-- 
	<div class="chatbox">
				
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/product/pimg/doraemon.png" class="hpimg">
						<span class="pname"> 도라에몽 팝니다. </span>
					</div>
					<div>
						<button onclick="productlistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				<div class="chatcontent">
					<div class="sendbox">구매가능할까요?</div>
					<div class="receivebox">네 구매 가능합니다.</div>
				</div>
				
				<div class="chatbtn">
					<textarea rows="" cols=""></textarea>
					<button type="button">전송</button>
				</div>
			</div>
	 -->
</body>
</html>