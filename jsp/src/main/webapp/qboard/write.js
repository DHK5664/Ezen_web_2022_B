
let 임시저장소 =[]

let qboard={
			atitle : document.querySelector('.atitle').value ,
			acontent :document.querySelector('.acontent').value ,
			awriter:document.querySelector('.awriter').value ,
			apassword : document.querySelector('.apassword').value 
			// 첨부파일 X 
		}; console.log(qboard)

function bWrite(){
		let wrForm=document.querySelector('.wrForm');
		let fData = new FormData(wrForm); console.log(fData)	
	// * 유효성검사는 생략	
		임시저장소.push(qboard); console.log(임시저장소)
	let result = true; 
	if(result){ alert('글쓰기 성공'); location.href='list.html';}
	else{alert('글쓰기 실패')}
}

document.querySelector('.cancel').addEventListener('click',(e)=>{
	location.href="list.html"; alert('글 작성을 취소합니다.')
})

