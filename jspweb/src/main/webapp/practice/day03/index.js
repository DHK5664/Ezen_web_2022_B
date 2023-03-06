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
			if(r == 'true'){
				alert('등록성공');
				onlist();
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				}
			else{alert('등록실패');}
		} // success end
	}) // ajax end
} // 등록 end

// 2. 모든 게시물 출력 [ 1. js 열릴때 2. 글작성때마다 ]
onlist();
function onlist(){
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "get",
		success : (r)=>{
			console.log('get 응답 성공 ');
			console.log(r);
			// 1. 테이블 제목
			let html =
					`<tr>
							<th> 번호 </th>
							<th> 제목 </th>
							<th> 작성자 </th>
							<th> 비고 </th>
						</tr>`;
			// 2. 테이블 내용
			r.forEach((o,i)=>{
				
				html+=
					`<tr>
							<td> ${o.bno} </td>
							<td> ${o.bcontent} </td>
							<td> ${o.bwriter} </td>
							<td>
								<button onclick="ondelete(${o.bno})" type="button"> 삭제 </button>
								<button onclick="onupdate(${o.bno})" type="button"> 수정 </button>
							</td>
						</tr>`;
			});
			// 3. 구성된 html 대입
			document.querySelector('.boardtable').innerHTML = html;
		}
	})
	
} // onlist end

// 3. 특정 게시물 삭제
function ondelete(bno){
	console.log("ondelete() 열림" + bno);
	$.ajax({
		url: "/jspweb/Ex3/Board" ,
		method : "delete" ,
		data : {"bno" :  bno } ,	// 전송 안댐;;
		success : (r)=>{
			console.log('delete 응답 성공'); console.log(r);
		}
	})
} // ondelete end

// 4. 특정 게시물 수정
function onupdate(bno){
	console.log("onupdate() 열림" + bno);
	let newContent = prompt('수정할 내용 입력');
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "put" ,
		data : {"bno" : bno , "newContent" : newContent} , // 전송 안댐;;
		success : (r)=>{
			console.log('put 응답 성공'); console.log(r);
		}
	})
}

/*
favicon.icon 404 이러는건 걍 아이콘문제라서 신경안써도 O
보통 404는 경로문제
보통 500번대는 백엔드 java문제임
*/











































