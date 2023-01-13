
let contentArray = [ ]	// 누적 기록

function addContent(){	// f s
	//function : 함수 선언[정의]시 사용되는 키워드
		//addContent : 함수이름
			//( )	 : 인수
				//{} : 함수 호출시 실행되는 구역(지역)
		
		let content = document.querySelector('.content').value// 2. <input>에서 입력받은 데이터[value] 가져와서 변수에 저장
		contentArray.push(content)//3. 배열 내 입력받은 변수 저장
		printContent()
	


}	// 2. 삭제 버튼을 클릭했을때 함수

function onDelete( dno ){ // f s
	contentArray.splice( dno , 1 )
	printContent()
} //  f e


	//3. 배열 내 존재하는 요소들을 출력하는 함수 [1. 등록했을때 2. 삭제했을때 3. 수정했을때]
function printContent(){
		// 4. 출력할 html 구성 [ + vs ` ]
		let html = `<tr>
						<th>번호</th
						><th>방문내용</th>
						<th>비고</th>
					</tr>`	
		
		for( let i = 0; i<contentArray.length ; i++){// 5.내용 추가 [반복 이용한 배열 내 요소 출력] for s
			html += `<tr>
						<td>${i+1}</td>
						<td>${contentArray[i]}</td>
						<td><button onclick="onDelete( ${i} )">삭제</button></td>
					</tr>`
								/* onDelete(삭제할번호)*/
		}	// for e
				
		
		document.querySelector('.contentTable').innerHTML = html// 6. 위에서 구성된 html을 해당 마크업에 대입
		
		
}	// f e

























