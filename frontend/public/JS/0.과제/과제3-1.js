console.log('1.js작동')

let contentArray = [ ]	// 누적 기록

function addContent(){	// f s
	//function : 함수 선언[정의]시 사용되는 키워드
		//addContent : 함수이름
			//( )	 : 인수
				//{} : 함수 호출시 실행되는 구역(지역)
		console.log('2.addContent() 함수 작동')		
				
		// 2. <input>에서 입력받은 데이터[value] 가져와서 변수에 저장
		let content = document.querySelector('.content').value
			console.log('3.content : ' + content)
		//3. 배열 내 입력받은 변수 저장
		contentArray.push(content)
			console.log('3. contentArray : ' + contentArray)
		
		// 4. 출력할 html 구성 [ + vs ` ]
		let html = `<tr><th>번호</th><th>방문내용</th></tr>`	
		
		
		// 5.내용 추가 [반복 이용한 배열 내 요소 출력]
		for( let i = 0; i<contentArray.length ; i++){
			html += `<tr><td>${i+1}</td><td>${contentArray[i]}</td></tr>`
		}		
				
		// 6. 위에서 구성된 html을 해당 마크업에 대입
		document.querySelector('.contentTable').innerHTML = html
		
		
}	// f e