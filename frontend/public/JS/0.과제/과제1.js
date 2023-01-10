console.log('JS실행'); // 확인용
/*
	*오류메시지 : ~~ is not defined
	1. 정의 X 2. 이름 오타 3. 저장/새로고침
*/

/*4. 배열선언
 [ 1. 함수 안에서 선언(함수 실행마다 선언 - 누적저장 X)
   2. 함수 밖에서 선언(JS실행 1번 선언 -누적저장O) ]
*/
// 4. 배열 선언과 동시에 3개의 요소 저장
let studentArray = ['20230110' , '20230109' , '20230108']

// 3. HTML : onclick="onLogin()" 에 대한 함수 정의[만들기]
function onLogin(){//함수[onLogin] 시작점

	console.log('onLogin함수 실행')	//[확인용]

	// 5. <input> 마크업 js변수로 가져오기
	let sno = document.querySelector('.sno')
	// 5. <input> 마크업에 입력된 데이터 호출
	let snoValue = sno.value;
		// * 확인
		console.log('5번체크 : ' +snoValue)
	
	// 6. 비교 [ 만약에 배열내 입력한 값이 존재하면 찾은 인덱스 번호 / 존재하지않으면 -1 ]
	let sIndex = studentArray.indexOf( snoValue )
		// * 확인
		console.log('6번체크 : ' + sIndex )
	//7. 논리
		if(sIndex == -1){//if s
			//alert('로그인 실패') 
			//8. 출력 [ innerHTML 이용한 '문구' 출력 ]
			document.querySelector('.resultBox').innerHTML = '로그인 실패'
			}// if e
		else{	// el s
			//alert('로그인 성공');}
			document.querySelector('.resultBox').innerHTML = '로그인 성공'
			}// el e
	
		
}// 함수 [onLogin] 끝



function insign(){ // 함수 시작
	
	

	
	let snadd = document.querySelector('.snadd')		// <input> 마크업 js로 가져오기
	
	let snadd_Value = snadd.value;						// <input>에 입력된 데이터 호출
	

	
	let snadd_Index = studentArray.indexOf(snadd_Value) // indetOf를 통해 존재하나 안하나 찾아보기
	
	let length = snadd_Value.length						// 길이 확인용
	

	
	if (length == 0) {document.querySelector('.result').innerHTML = '학번을 입력해주세요.';}		//길이 0일시 학번 입력 출력
	
	else if (length != 8){document.querySelector('.result').innerHTML = '8자리로 입력해주세요.';}	//길이 8아닐 시 8자리 맞춰달라 출력
	
	else if (snadd_Index == -1){						// 배열 안에 없을시
			studentArray.push(snadd.value)				// 데이터 호출값에 대입
			document.querySelector('.result').innerHTML = '등록 완료';	// 등록완료 호출
			console.log(studentArray)
	
	}

	else {document.querySelector('.result').innerHTML =  '존재하는 학번입니다.';}		// 배열안에 있을 시 존재 X 호출
	snadd.value = '';
	
	
	
	
	
	
	
	
	
	
	
}










