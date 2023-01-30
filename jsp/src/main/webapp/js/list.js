
board_print( null , null );// 1. js 시작될 때 실행 / 처음 열렸을때 실행되는거라서 검색값이 없어서 null로 넣음

// 1. 게시물 출력 함수 
// 인수 :  1. 페이지 처음 js열렸을때[조건 없음 = keyword=null , key=null ] / 2. 검색되었을때[조건 있음] ]
//		  2. 검색되었을 때 [조건 o = keyword=입력받은 값 , key=입력받은 값]
//		  3. 페이지 전환 되었을 때	
function board_print(keyword , key){
	
	// 1. JAVA[백엔드]로 부터 데이터 요청		//~추후
	if(keyword==null && key == null){// 1. 검색이 없는경우 : 전체출력
		alert('검색이 없는 게시물 출력')
		//JAVA에게 검색[조건]이 없는 게시물들을 요청
	}else{// 2. 검색이 있는 경우
		alert('검색이 있는 게시물 출력')
		// JAVA에게 keyword , key 보내서 검색[조건] 이 있는 게시물들을 요청
	}
	// [백엔드로부터 요청된 결과 ] 2. DB->JAVA으로 전달된 게시물리스트 데이터 
let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } , 
	]

// 2. 출력
	let html=''
	
	boardlist.forEach((board)=>{
		html+= `<tr> 
					<td>${board.no}</td><td>${board.title}</td>
					<td>${board.writer}</td><td >${board.date}</td>
					<td>${board.view}</td><td>${board.up}</td>
					<td>${board.down}</td> 
				</tr>`
	})
	
	document.querySelector('.boardlist').innerHTML = html;
	
}
// 2. 검색 버튼 클릭했을때 검색
document.querySelector('.searbtn').addEventListener('click' , (e)=>{
	console.log('검색 클릭')
	// 1. 키워드
	let keyword = document.querySelector('.keyword').value
	// 2. 검색어
	let key=document.querySelector('.key').value
	console.log('keyword : ' + keyword); console.log('key : ' + key)
	// 3. 유효성검사 생략
	// 4. 키워드,검색어 전달 [ 백엔드 ](함수에게 인수를 전달)
	board_print( keyword , key )		// 키워드와  키를 보드프린트에 전달 == 키워드와 키가 포함된것만 출력하기 위함
})

/*
	배열반복문
	for(let i = 0 ; i<배열명.length; i++){}
	forEach(()=>{})
*/




