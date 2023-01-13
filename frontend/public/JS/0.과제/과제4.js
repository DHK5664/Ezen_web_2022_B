let 도서목록=['혼자공부하는자바', '이것이 자바다' , '열혈 C언어']
let 대여목록=['혼자공부하는자바']



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
								<td>${i}</td>
								<td><button onclick="대여버튼( ${i} )">대여버튼</button>
								<button onclick="반납버튼( ${i} )">반납버튼</button></td>
							</tr>`
		
	}
	
	
	document.querySelector('.printTable').innerHTML = html


}

printTable() // JS 실행될때 실행되는 함수 

function 대여버튼(i){
	console.log(i+'대여버튼을 누르셨군요')
	if(대여목록.indexOf(i)>=0){alert('이미 대여중입니다.')}
	else{대여목록.push(i)}
	
	printTable()
}

function 반납버튼(j){
	console.log(j+'반납버튼을 누르셨군요.')
	if(대여목록.indexOf(j)==-1){alert('대여하지 않는 도서입니다')}
	else{
	대여목록.splice(j,1)}
	
	printTable()
}







function 대출여부(bno){
	for(let j =0; j<대여목록.length ; j++){
		if(도서목록[bno]==대여목록[j]){return '대여중'}
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