console.log('js실행')

body_print()
function body_print(full,word){
	if(full==null,word==null){
	//	alert('검색어 없는 게시물 출력')
	}else{
		alert(word +' ☆해당 내용으로 검색합니다.')
	}
	
	let boardlist = [
   { no : 5 , writer : '강호동' , title : '배고파요'  , date : '2023-01-26' , view:887 , sDate : '2023-01-28' , state : '완료'  } , 
   { no : 4 , writer : '유민상' , title : '치킨 먹고싶어요'  , date : '2023-01-25' , view:587 , sDate : '2023-01-27' , state : '완료'  } ,  
   { no : 3 , writer : '문세윤' , title : '뭐든 먹고싶어요'  , date : '2023-01-24' , view:624 , sDate : '2023-01-26'  , state : '완료' } , 
   { no : 2 , writer : '김준현' , title : '식사 되나요?'   , date : '2023-01-23' , view:721 , sDate : '-' , state : '접수'   } , 
   { no : 1 , writer : '김민경' , title : '돈까스 있나요?'  , date : '2023-01-22' , view:685 ,  sDate : '-' , state : '접수'  }
	]
	
	
	let html=''
	
		boardlist.forEach((qboard)=>{
			html +=`<tr>
						<td>${qboard.no}</td><td>${qboard.writer}</td>
						<td> <a href="view.html"> ${qboard.title} </a> </td><td >${qboard.date}</td>
						<td>${qboard.state}</td><td>${qboard.sDate}</td>
						<td>${qboard.view}</td>
					</tr>`
		})
	document.querySelector('.bodylist').innerHTML=html
	
	
}

document.querySelector('.sBtn').addEventListener('click',(e)=>{
	console.log('검색 클릭')
	let full = document.querySelector('.full').value;
	let word = document.querySelector('.word').value;
	console.log('검색옵션 : ' + full); console.log('word: ' + word)
	body_print(full,word)
})