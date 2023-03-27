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
		
		<form class="writeForm">
			제품명 :	<input type="text" name="pname">		<br>
			제품설명 :	<input type="text" name="pcomment">		<br>
			제품가격 :	<input type="text" name="pprice">		<br>
			위치 :	
			<div id="map" style="width:100%;height:350px;"></div>
			<button onclick="onwrite()" type="button">제품등록</button>	<br>
			
			<h5>첨부파일 한개</h5>
			<input type="file" name="pfile" accept="image/*">	<br>
			
			<h5>첨부파일 여러개</h5>
			<input type="file" name="pfile1">	
			<input type="file" name="pfile2">	
			<input type="file" name="pfile3">	
			
			<h5>첨부파일 여러개</h5>
			<input type="file" name="pfiles" multiple="multiple" accept="image/*">	<br>
			
		</form>
		
		<div>
		
		</div>
	
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f2696c7ce73b2c3c992ea91cbfd4905"></script>
	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
	
</body>
</html>