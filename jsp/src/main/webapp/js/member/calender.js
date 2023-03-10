/* DB */
let contents = []	// 일정목록


/*----------------전역변수 : 모든 함수에서 공용으로 사용되는 메모리[변수]---------------*/
// 1. js 열렸을때 현재 연도와 월을 구해서 변수에 저장
let year = new Date().getFullYear();	// 기본값:현재 연도	// 이전/다음 버튼 클릭에 변경
let month = new Date().getMonth()+1;	// 기본값:현재 월	// 이전/다음 버튼 클릭에 변경
// 2. 캘린더 상단에 연도/월 표시 함수	[1. js열렸을때 2.이전/다음 버튼 클릭할떄마다]
cal_print(); // js열렸을때
function cal_print(){
	// 1. 현재 캘린더 설정된 날짜를 상단에 월/일 표시
document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`;
	
	// 3. html '요일' 기본 구성
	let html = `<div class="day weekday sunday">일</div><div class="day weekday">월</div>
				<div class="day weekday">화</div><div class="day weekday">수</div>
				<div class="day weekday">목</div><div class="day weekday">금</div>
				<div class="day weekday">토</div>`
				
	// * 현재 캘린더 설정된 날짜의 마지막 일 구하기
	let lastday = new Date(year , month , 0).getDate();console.log(' 현재 캘린더 마지막 날짜:' + lastday);		// 중요
	// *  현재 캘린더 설정된 날짜의 1일 시작 요일 구하기
	let weekday = new Date(year , month-1 , 1 ).getDay();console.log('현재 캘린더 시작일 요일 : ' +weekday );	// 중요
	
	// * 2. 시작 요일전에 공백 만들기
	for(let b = 1 ; b<=weekday ; b++ ){
		html +=`<div class="day"></div>`	
	}// for e
				
	// * 1. 일 만들기	[ 1 ~ 마지막 일[new Date(year , month , 0).getDate()] 까지]
	for(let day= 1 ; day<=lastday; day++){
		
		// 4. 1일 ~ 마지막 일 날짜 확인
		let date = new Date( year , month-1 , day );//console.log(date);
		let fdate = date_format(date); //console.log(fdate);
		
		html +=`<div class="day" onclick="openModal( ${fdate} )">
					 ${ day } ${contents_print( fdate )}
			 </div>`		
	} // for e
				
	// 3. html 마크업 출력
	document.querySelector('.cal_day').innerHTML=html;

}// f e

// 9. 일정 삭제
function onDelete(i){
	// 1. 배열 내 해당 인덱스 삭제
	contents.splice(i,1);
	// 2. 화면 업데이트
	document.querySelector('.modal_wrap').style.display='none';
	cal_print();
}

// 8. 등록 버튼 눌렀을 때 함수
document.querySelector('.modal_write').addEventListener('click' , (e)=>{	
	let content = {// 1. 입력받은 내용과 선택된 날짜 가져와서 객체화
		date : document.querySelector('.modal_date').innerHTML,
		content : document.querySelector('.modal_input').value,
		bg_color : document.querySelector('.modal_color').value
	}; console.log(content);
	// 2. 유효성 검사 생략
	// 3. 배열 저장
	contents.push(content);
	// 4. 화면 업데이트
		document.querySelector('.modal_input').value=''// 1. 입력된 데이터 초기화
		document.querySelector('.modal_wrap').style.display='none';	// 2. 모달 닫기
		cal_print();// 3. 캘린더 재출력[재 랜더링]
})


// 7. 모달 닫기 함수
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	// 1. 모달 배경구역 css 변경해서 모달 숨기기
	document.querySelector('.modal_wrap').style.display='none';
})// f e
// 6. 모달 열기 함수
function openModal(fdate){ // f s
	// 1. 모달 배경 구역 css 변경해서 모달 보이기
	document.querySelector('.modal_wrap').style.display = 'flex';
	// 2. 모달에 선택된 날짜 표시하기
	document.querySelector('.modal_date').innerHTML = fdate;
	// 3. 해당 하는 날짜의 모든 일정 출력
	let html =`<tr><th width="5%"> # </th><th> 일정 내용</th><th width="15%"> 비고 </th></tr>`	
		// 2. 일정목록 반복문 돌려서 선택된 날짜와 동일한 일정 찾기
	let j = 0;	//[출력용도]j : 동일한 일정의 일정[객체]들의 개수
	contents.forEach(( o , i )=>{	//[삭제용도]i : 일정 객체들의 인덱스 순서
		if( fdate == o.date){// 만약에 모달 클릭시 선택된 날짜와 일정목록에 있는 날짜가 같으면
			j++;	// 찾은 개수 증가
			html += `<tr>
					<td> ${j} </td>
					<td> ${o.content} </td>
					<td><button onclick="onDelete(${ i })" type="button">삭제</button> </td>
				</tr>`
			}
		} )
	
	document.querySelector('.table').innerHTML=html;
	
 } // f e
// 5. 일정 출력 함수
function contents_print( fdate ){ console.log(fdate)
		let html = ``
	contents.forEach((o)=>{// 일정목록 반복문
		if(fdate==o.date){// 만약에 인수로 전달된 날짜와 일정목록에서 동일한 날짜가 존재하면
			html += `<div class="content" style="background-color : ${ o.bg_color }">${o.content}</div>`			
		}	
	})	// for end
	return html;
}

// 4. 날짜 포멧 함수 [인수 : 날짜 -----로직[포멧]-----> 반환 : 변경된 날짜 형식]
function date_format( date ){	
	let d_year = date.getFullYear(); 
			// 만약에 월/요일이 한자리수(<=9) 이면 앞에 0 붙이기
	let d_month = (date.getMonth()+1) <=9 ? '0'+(date.getMonth()+1) :(date.getMonth()+1) ;
	let d_day = date.getDate()<=9  ? '0' + date.getDate() : date.getDate();
	return `${d_year}${d_month}${d_day}`
}

// 3. 이전달 다음달 버튼 클릭 이벤트에 따른 연도와 월이 변경
document.querySelector('.previousbtn').addEventListener( 'click' , (e)=>{console.log('이전달 버튼 클릭')
	// 1. 월 1차감 했을경우 만약에 0이면 연도 1차감 월 12설정
	month--;
	if(month < 1){year--; month = 12; }
	cal_print(); //이전/다음 버튼 클릭할떄마다
} ) // fe
document.querySelector('.nextbtn').addEventListener( 'click' , (e)=>{console.log('다음달 버튼 클릭')
	month++;	// 1. '월' 1증가 했을 경우 만약에 월 12보다 크면 '연도' 1 증가 '월' 1출력
	if( month > 12){ year++; month = 1;}
	cal_print(); //이전/다음 버튼 클릭할떄마다
} ) // fe



















/*
	new Date()	클래스	날짜/시간 관련된 클래스
			1. let date = new Date 					: 현재 날짜/시간 객체
			2. let date = new Date(2023 , 01 , 31 )	: 사용자 정의 날짜/시간 객체
			3. let date = new Date(연도 , 월+1 , 0)	: 사용자 정의 연도와 월 날짜에 따른 마지막 일 날짜
			3. let date = new Date(연도 , 월 , 1)		: 사용자 정의 연도와 월 날짜에 따른 1일 날짜
				1.	.getFullYear()	: 연도
				2.	.getMonth()		: 월	[ 0 ~ 11   0:1월 ~ 11:12월]
				3.	.getDate()		: 일
				4.	.getDay()		: 요일 [ 0 ~ 6   0:일요일 ~ 6:토요일]

let date = new Date(); console.log('date :' + date)
let date2 = new Date(2020,1,31);console.log('date2 :' + date2);
console.log('연도:' + date.getFullYear());
console.log('월 :'+date.getMonth());
console.log('일 :' + date.getDate());
console.log('요일 :' + date.getDay());

	`백틱
		` 문자열 ${ js작성할 수 있는 구역 }` 즉 함수 연산 상수 다 들갈 수 있음

*/