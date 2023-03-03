<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예1) HTML -- document.querySelecter --> JS -- AJAX --> servlet -- 메소드 --> Dao </h3>
	
	data1[문자열] 		:	<input type="text"		class="data1">		<br/>
	data2[패스워드]		:	<input type="password"	class="data2">		<br/>
	data3[실수]		:	<input type="text"		class="data3">		<br/>
	data4[정수]		:	<input type="number"	class="data4">		<br/>
	data5[날짜]		:	<input type="date"		class="data5">		<br/>
	data6[날짜/시간]	:	<input type="datetime-local" class="data6">	<br/>
	data7[선택버튼]		:	<input type="radio" name="data7" value="남">남
				 		<input type="radio" name="data7" value="여">여			<br/>
	data8[체크상자]		:	<input type="checkbox" class="data8">승인 	<br/>
	data9[목록상자]		:	<select class="data9">
						<option>안산</option> <option>수원</option> <option>성남</option>
					</select>										<br/>	 	
	data10[긴글]		:	<textarea class="data10" rows="" cols=""></textarea> <br/>
	
	<button type="button" onclick="ex1()"> 전송 </button>
	
	
	<h3> 예1) Dao -- 메소드 --> servlet -- AJAX/JACKSON --> JS -- document.querySelecter --> HTML</h3>
	<div class="ex1_box"></div>
	
	<h3> 과제) HTML -- document.querySelecter --> JS -- AJAX --> servlet -- 메소드 --> Dao </h3>
	이름[문자열]		: <input type="text"	class="Qdata1">		<br/>
	전화번호[문자열]		: <input type="text"	class="Qdata2">		<br/>
	키[실수]			: <input type="text"	class="Qdata3">		<br/>
	나이[정수]			: <input type="number"	class="Qdata4">		<br/>
	등록일[날짜]		: <input type="date"	class="Qdata5">		<br/>
	성별[선택버튼]		: <input type="radio"	name="Qdata6" value="남">남
					  <input type="radio"	name="Qdata6" value="여">여	<br/>
	개인정보동의[체크상자]	: <input type="checkbox"	class="Qdata7">승인		<br/>
	사는지역[목록상자]		: <select class="Qdata8">							<br/>
						<option>안산</option> <option>안양</option> <option>수원</option>
					  </select>									<br/>
	자기소개[긴글]		: <textarea class="Qdata9" rows="" cols=""></textarea><br/>
	
	<button type="button" onclick="Qex1()"> 보내기 </button>
	
	<h3> 과제) Dao -- 메소드 --> servlet -- AJAX/JACKSON --> JS -- document.querySelecter --> HTML</h3>
	<div class="Q_box"></div>

	<!-- 1. JQUERY( ajax 사용하기 위해 ) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자정의 js -->
	<script src="index.js" type="text/javascript"></script>
	
</body>
</html>