alert('JS열림');
// 1. 
function doPOST(){
	alert('http POST 메소드 실행합니다');
	$.ajax({
		url :"/jspweb/Ex3" ,
		method : "post" ,
		success : (result)=>{ } // = function(result){} 얘랑 같음
	})
}
// 2. 
function doGET(){
	alert('http GET 메소드 실행합니다');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "get" ,
		success : (result)=>{}
	})
}
// 3.
function doPUT(){
	alert('http PUT 메소드 실행합니다');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "PUT" ,
		success : (result)=>{}
	})
}
// 4.
function doDELETE(){
	alert('http DELETE 메소드 실행합니다');
	$.ajax({
		url : "/jspweb/Ex3" , 
		method : "DELETE" ,
		success : (result)=>{}
	})
}
//-----------------------------------------------------------------------
// 1. 등록
function onwrite(){
	console.log('함수 s')
	let info = {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "post",
		data : info ,
		success : (r)=>{
			console.log('응답성공');
		}
	})
}
/*
favicon.icon 404 이러는건 걍 아이콘문제라서 신경안써도 O
보통 404는 경로문제
보통 500번대는 백엔드 java문제임
*/











































