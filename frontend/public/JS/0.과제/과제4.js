console.log('js 작동 확인') // 확인용
let 도서목록 = ['혼자공부하는자바','이것이자바다','열혈 C언어']
let 대여목록 = ['혼자공부하는자바']

//김지호
관리자테이블출력()

function bookIn(){
	let bookName = document.querySelector('.bookName').value
	if(도서목록.indexOf(bookName) != -1){ alert('존재하는 도서입니다.'); return; }
	if(bookName.length<5 || bookName.length>10){ alert('등록할 수 없는 글자 수 입니다.'); return; } 
	도서목록.push(bookName)
	관리자테이블출력()
	printTable()
}

function 관리자테이블출력(){
	let 관리자테이블 = `<tr>
					<th> 번호 </th> 
					<th> 도서 </th> 
					<th> 도서대출여부 </th> 
					<th> 비고 </th>
				</tr>`
	for(let i = 0 ; i<도서목록.length ; i++){
		관리자테이블 += `<tr>
						<td>${i+1}</td> 
						<td>${도서목록[i]}</td>
						<td>${대출여부(i)}</td>
						<td><button type="button" onclick="onDelete(${i})">삭제</button></td>
					</tr>`
	document.querySelector('.관리자테이블').innerHTML = 관리자테이블		
	}	
}

function 대출여부(bno){
	for(let j =0; j<대여목록.length ; j++){
		if(대여목록.indexOf(도서목록[bno])>=0){return '대여중'}
		else{return '대여가능' }
	}	
}

function onDelete(bno){
	if(대출여부(bno)=='대여중'){
		alert('대출중입니다.')
		return;
	}
	도서목록.splice(bno,1)
	관리자테이블출력()
}



/*---------------------------------------------------------------*/

function printTable(){
	console.log('table print')
	let html = `<tr>
					<td>번호</td>
					<td>도서</td>
					<td>도서대여여부</td>
					<td>비고</td>
				</tr>`
				
	for(let i=0 ; i<도서목록.length ; i++){
			html += `<tr>
						<td>${i+1}</td>
						<td>${도서목록[i]}</td>
						<td>${대출여부(i)}</td>
						<td><button onclick="대여버튼( ${i} )">대여버튼</button>
						<button onclick="반납버튼( ${i} )">반납버튼</button></td>
					</tr>`
		
	}
	
	
	document.querySelector('.printTable').innerHTML = html


}

printTable() // JS 실행될때 실행되는 함수 

function 대여버튼(i){
	console.log(i+'대여버튼을 누르셨군요')
	if(대여목록.indexOf(도서목록[i])>=0){alert('이미 대여중입니다.'); return;}
	else{대여목록.push(도서목록[i])}
	console.log(대여목록)
	printTable()
	관리자테이블출력()
}

function 반납버튼(j){
	console.log(j+'반납버튼을 누르셨군요.')
	if(대여목록.indexOf(대여목록[j])==-1){alert('대여하지 않는 도서입니다')}
	else{
	대여목록.splice(대여목록.indexOf(대여목록[j]),1)}
	console.log(대여목록)
	printTable()
	관리자테이블출력()
}