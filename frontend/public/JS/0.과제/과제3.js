let contentArray = []											// 내용 담을 배열 선언



function addContent(){											// onclick 함수 선언
	console.log('클릭함.')										// JS와 연결 되었는지 확인

	let 테이블행 =  '<tr> <th>번호</th> <th>내용</th> </tr>'			// 테이블 태그 변수 선언

	contentArray.push(document.querySelector('.detail').value)// <input> 입력받은 값 contentArray에 요소로 입력
	
	for( let i=0 ; i<contentArray.length ; i++ ){	
	//i는 1부터 컨텐츠배열의 길이까지 증가 반복처리를 하고있다.
	/*위와 같은 for문은 조건이 true여야만 실행 되고 또한 contentArray라는 요소가 없는 빈 깡통 배열과 같이 사용 중이라서
	<input>에 입력해서 배열 속 요소가 추가가 되면 그게 곧 contentArray의 length(길이)가 된다
	그래서 위와 같은 초기값과 조건문을 기입 시 그 길이까지 실행을 하므로
	최초로 요소 추가시 길이는 1이되고 i는 0이라서 i<contentArray.length = 0<1 이 성립하므로 일단 
	'테이블 행 한 줄 실행' 그 다음에는 반복증가 실행이므로 i=1이 되어서 1<1은 false이므로 한 줄만 나온다
	이러한 이유로 만약 <=를 넣는다면 처음<input>에 요소를 입력할 경우 '행'이 '두 줄' 실행 될 것이다. */
	테이블행 += '<tr> <th> '+i+' </th> <th> '+contentArray[i]+' </th> </tr>'
	// i는 0부터 시작해서 0 1 2 3 4 이런식으로 표기되고 contentArray[i]라고 하면 0번 1번 2번 ... 해당 위치의 인덱스가 나옴 
	// 그리고 i를 기입한 이유는 i를 기입시 글 번호가 되기 때문
	}
	//5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기
	document.querySelector('.i_list').innerHTML = 테이블행		// 얘로 누적(?)된 데이터들 HTML에 출력
	document.querySelector('.detail').value = '' 			// 입력 후 <input>값 초기화
	}