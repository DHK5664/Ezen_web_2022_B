console.log('함수')
console.log(memberInfo)
console.log(memberInfo)

let bno = document.querySelector('.bno').value;
console.log("bno :" + bno);

// 1. 수정할 게시물 출력
getBoard()
function getBoard(){
	$.ajax({
		url:"/jspweb/board/info",
		method : "get",
		data : {"type": 2 , "bno" : bno},
		success : (r)=>{
		console.log(r)
		
			document.querySelector('.btitle').value=r.btitle;
			document.querySelector('.bcontent').value=r.bcontent;
			
			
			// 1. 기존 select option 가져와서 selected
			let cnoSelect = document.querySelector('.cno');
				console.log(cnoSelect);	// select
				console.log(cnoSelect.options[0]);	// select 안에 있는 첫번째 option
			for(let i = 0 ; i<cnoSelect.options.length ; i++){ //cnoSelect.options.length 셀렉트 안에있는 옵션의 개수
				// i는 0부터 옵션<option>태그 개수만큼 반복
				if(cnoSelect.options[i].value == r.cno ){
					// i번째 옵션<option>태그의 값과 현재 게시물의 카테고리 번호가 일치하면
					cnoSelect.options[i].selected = true;
				}
			}
			
			// 2. 첨부파일 있을떄 / 없을때
			let html =''
			if(r.bfile == null){	// 첨부파일 없을때
				html += `<div>'첨부파일없음'</div>`;
			}else{	// 첨부파일 있을때
				html += 
				   `<div>
				   기존 첨부파일 : <span class="oldbfile"> </span>
					<button onclick="bfiledelete()" type="button">삭제</button>
					</div>`
				
			}
				html += `새로운 첨부파일 :	<input name="bfile" type="file">`
				document.querySelector('.bfilebox').innerHTML = html;
				document.querySelector('.oldbfile').innerHTML=r.bfile;
		}
	})
}
// 2.
function bupdate(){	
	let updateForm = document.querySelectorAll('.updateForm')[0];
	// 1. form 안에 있는 데이터 객체화 했다
	let updateFormData = new FormData(updateForm);
		// 2. form 밖에 있거나 js에 있는 추가 데이터는 formData.set 써서 추가
		// formdata객체명.set('변수명' , 데이터);
		updateFormData.set('bno' , bno); // 수정할 대상 write는 글 쓰기라 bno생성이고 얘는 글 수정이라서 대상이 명확하게 필요함
		
	$.ajax({
		url:"/jspweb/board/info",
		method:"put",
		data: updateFormData ,
		contentType : false ,
		processData : false ,
		success : (r)=>{
			if(r=='true'){
			alert('업데이트성공');
				location.href="/jspweb/board/view.jsp?bno="+bno;
			}else{
				alert('업데이트성공');
			}
		}
	})
}// end

// 3. 
function bfiledelete(){
	alert('첨부파일 삭제합니다.');
	
	$.ajax({
		url:"/jspweb/board/info" ,
		method : "delete" ,
		data : {"bno":bno , "type" : 2},	// view에서도 delete를 사용하고 있어서 하나의 서블릿 속 delete를 같이 사용하기 위해 type을 보내는데 1: 게시물삭제[첨부파일포함] // 2.첨부파일만 삭제
		success: (r)=>{
			if(r=="true"){
				// 특정 div만 reload[랜더링] 방법!
					// 주의점!! : location.href+'(띄어쓰기한번).클래스명 '
					$(".bfilebox").load(location.href+' .bfilebox');
					// load() : jquery 에서 제공하는 랜더링[새로고침] 함수
				// jquery	:$(".클래스명")	
				// : 해당 클래스명을 가진 태그 객체화
				// vs 
				// js		: document.querySelector('.bfilebox');
				// 불가능 : document.querySelector('.bfilebox').load( location.href+' .bfilebox' );
				
				/* document.querySelector 얘 자체가 원래 DOM객체이고 아까 설명들었던 document.querySelectorAll은 모든 걸 가져옴
				//근데 document는 문서 query는 질문, 질의 ,selector는 선택해온다는 의미 이므로 문서에서 클래스명 가진거 하나를 객체로 가져온다 이거고
				아까는 form이라서 특수한 상황인데 form일때는 걍 document.querySelector얘를 쓰면 문서로 document.querySelectorAll을쓰면 객체로 가져오게 된다.*/
			}else{
				
			}
		}
	})
}































