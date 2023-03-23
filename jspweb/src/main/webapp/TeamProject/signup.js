console.log('js열림');

// 1. 회원가입

function signup(){
	let signupForm = document.querySelectorAll('.signupForm')[0];
	let signupFormData = new FormData(signupForm);
	console.log(signupFormData);
	
	$.ajax({
		url:"/jspweb/tpsignup",
		method:"post",
		data:signupFormData,
		contentType : false ,
		processData : false , 
		success:(r)=>{
			console.log(r);
			if(r=='true'){alert('회원가입 성공(DB에 저장댐)')}
			else{alert('회원가입 실패...')}
		}
	})
}