
console.log('js 실행')	// 1. 확인

 // 테이블의 첫 행 [제목] html 마크업 대입된 변수
 // let html변수면 = 'HTML마크업작성'		//! : 마크업 문자처리

/*let 테이블행 =  '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>'	;	*/	 // 밖에 만들면 1번 실행 [ 결과 누적 O ]

// * 함수 밖에 있으면 1번 실행/ 함수 안에 있으면 클릭 할 떄 마다 실행함 ☆!중요!☆
// 3. 
function onResult(){
	console.log('클릭했다.') //3. 확인
	let 테이블행 =  '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>'	;	// 안에 만들면 클릭 때 마다 실행 [ 결과 누적 X ]
	// 4. 단 : <input> 곱 <input> 에 입력된 value 각 변수에 저장
	let dan = document.querySelector('.dan').value // 이렇게 바로 value 붙여도 문제 없
	let gob = document.querySelector('.gob').value				//----1 번째로 중요
	
	/* 3. 테이블 행<tr> 반복문으로 만들기	*/
for(let 곱 = 1 ; 곱 <= gob ; 곱++ ){	// for s
	// 곱은 1부터 입력받은 값(gob - gob은 위에서 선언한 input의 변수이기 때문) 까지 1씩 증가 반복처리
	
	// ! : 변수명 과 수식은 문자처리 X (html , 상수는 문자처리 O)
	// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
	테이블행 += '<tr> <th> '+dan+' </th> <th> '+곱+' </th> <th>'+(dan*곱)+' </th>'
	// += 추가 [기존데이터 + ] / = 대입 [기존데이터 덮어씌우기] 그래서 '대입'을 넣으면 싹 덮어버려서 마지막 값인 2 9 18만 나옴	--> dan 대신 2일때
}// for e

	//5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기
	document.querySelector('table').innerHTML = 테이블행
		
}
































