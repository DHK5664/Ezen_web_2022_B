console.log('1.js 열림')

// * 함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리 사용
let contents = [ ]
onprint() // js 열렸을때
	// 이벤트함수
		// 1. <button type="button" onclick="onwrite()"> 글등록 </button>
			// function onwrite(){}
		// 2. <button type="button" class="onwritebtn()"> 글등록 </button>

			// document.querySelector('.onwritebtn').addEventListener( 'click' , (e)=>{} )
// 1. 글 등록 함수
function onwrite(){ // f s
	console.log('2. onwrite 함수열림')
	// 1. 입력받은 4개 데이터를 하나의 객체로 선언
	let info = { // let 객체명(아무거나) = {속성명 : 데이터 , 속성명 : 데이터 , 속성명 : 데이터} = 객체값
		bwriter:	document.querySelector('.bwriter').value,
		bpassword: document.querySelector('.bpassword').value,
		btitle : document.querySelector('.btitle').value,
		bcontent :document.querySelector('.bcontent').value,
		bdate : new Date(), // 현재 날짜/시간 반환
		bview : 0 // 조회수
	}
	console.log( info )// 객체정보 출력시 문자열 연결연산자 금지
	// 2. 유효성 검사	// 객체명.속성명
		// 1. 입력받은 데이터 길이 체크
	if(info.bwriter.length <= 0 || info.bpassword.length <= 0 ||
	info.btitle.length <=0 || info.bcontent.length <= 0 ){
		alert('작성이 안된 구역이 있습니다. 작성해주세요');
		return; // 함수종료 ... 해당 함수에서 아래로 진행 불가능(반환) + 반환에 값 설정을 하면 나중에도 사용 가능
		//ex) return 3; 이런 느낌
	}
	// 3.  배열에 저장 * 추후에는 백엔드에게 통신해서 데이터 전달 [백엔드 : java , db]
	contents.push( info )
	alert('글 등록 성공')
	onprint()// 글 등록했을 때
	console.log( contents )
	// 4. input 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
}// f e

// 2. 글 목록 출력 함수
function onprint(){ // f s // 1.js 열렸을때 2.글 등록했을 때 3.글 삭제 4.글 수정
	console.log('onprint 열림')
	// 1. 기본 html 구성
	let html = `<tr> <th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th> </tr>`
	// 2. 내용 html 구성
	for( let i = 0 ; i<contents.length; i++){
		
		let date = contents[i].bdate.getFullYear() +'년'+
				(contents[i].bdate.getMonth()+1) +'월'+
				contents[i].bdate.getDay() +'일'+
				contents[i].bdate.getHours()+':'+
				contents[i].bdate.getMinutes()+':'+
				contents[i].bdate.getSeconds()
		
		html += `<tr onclick="onview(${i})">
					<th>${ i+1 }</th>
					<th>${ contents[i].btitle }</th>
					<th>${ contents[i].bwriter }</th>
					<th>${ date}</th>
					<th>${ contents[i].bview }</th>
				</tr>`
	}
	
	// 3. 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML=html;
} // f e
// 3. 글 보기 함수 [ 조회수 증가 ]
function onview(i){ // f s // 1. 글 목록에서 해당 행을 클릭했을 때
	contents[i].bview += 1;onprint();
	console.log(i)
	let html = `<div> 제목 :${ contents[i].btitle } </div>
				<div> 내용 : ${ contents[i].bcontents } </div>
				<div> 작성자 : ${ contents[i].bwriter }</div>
				<div> <button onclick="onDelete(${i})">삭제</button> </div>
				`
	
	document.querySelector('.viewbox').innerHTML=html;
} // f e
// 4. 글 삭제 함수
function onDelete(i){// f s
	let password = prompt('게시물 비번 입력 :')
	if(password == contents[i].bpassword) { // if s
		contents.splice(i,1);
		alert('게시물 삭제 성공'); onprint();
		document.querySelector('.viewbox').innerHTML='';
	}// if e
	else { // else s
		alert('비밀번호가 틀렸습니다. 삭제실패')
	} // else e
}// f e









































