console.log('js열림')
// 1. 로그인 함수
function login(){
	console.log('login열림')
	// 1. 입력받은 값
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2. 
	$.ajax({
		url : "/jspweb/login",
		method: "post",
		data: {"mid" : mid , "mpwd" : mpwd},
		success: (r)=>{ 
			console.log('통신');
			console.log(r);
			if(r=='true'){ location.href="/jspweb/index.jsp";}
			else{				
				document.querySelector('.checkconfirm').innerHTML = "회원정보가 다릅니다."
			}
		}
	})
}
// 2. 아이디 찾기
function findid(){
	let memail = document.querySelector('.memail').value; // 1. 입력받은 이메일 가져오기
	$.ajax({// 2. ajax에게 보내서 결과 받기
		url:"/jspweb/find",
		method:"get",
		// "type" : 1 아이디찾기 // "type" : 2 비밀번호찾기
		data:{"type" : 1 , "memail" : memail},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='false'){
				document.querySelector('.checkconfirm').
				innerHTML='동일한 회원정보가 없습니다.'
			}else{
				document.querySelector('.checkconfirm').
				innerHTML= '회원님의 아이디 : ' + r;
			}
		}
	})
}










































