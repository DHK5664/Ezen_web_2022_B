console.log('js열림');

// -- 로그인한 회원정보 호출
function getLogin(){
	
	$.ajax({
		url:"/jspweb/login",
		method:"get",
		success : (r)=>{}
	})
}