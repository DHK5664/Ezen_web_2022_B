<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file = "/header.jsp" %>
	
	<div class="container">
		<div id="clickLatlng"></div> <!-- 클릭한 위치의 좌표 알기 -->
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:700px;"></div>
	</div>
	
	<!-- 카카오 지도에 필요한 클래스/메소드 가지고 있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f2696c7ce73b2c3c992ea91cbfd4905&libraries=clusterer""></script>
	
	<script src="/jspweb/js/api/api2.js" type="text/javascript"></script>

</body>
</html>