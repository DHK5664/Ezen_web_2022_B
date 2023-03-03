
/*alert('JS실행합니다.')*/ // 1번 실행

// * 함수 밖에 만든 이유 : 함수가 실행될 때 마다 선언하면 기존데이터는 삭제되기 떄문


let 학생리스트 = [ ]// 배열선언 , 초기 요소 없다[빈깡통]

/* 1. 추가 버튼을 눌렀을때 클릭 이벤트 함수*/
function onAdd(){ // 1. 함수 시작
	// 1. function : 함수 정의 키워드
	// 2. onAdd : 함수명[아무거나]
	// 3. () : 인수 [함수 안으로 전달받은 데이터]	
	// 4. {} : 함수가 실행되는 구역
	/*alert('클릭함수 실행합니다.')*/

	/* 2. sname 변수에 input 마크업 저장 */
	let sname=document.querySelector('.sname')
		
	/* 3. 마크업에서 값 가져와서 배열 담기 */
	//	alert(sname.value)	
	학생리스트.push( sname.value )
	
	// 4. 마크업에 출력
	//console.log(학생리스트)	
		//1. 출력할 위치에 마크업 가져오기
	let slist = document.querySelector('#slist')
	
	slist.innerHTML = '<li>'+ 학생리스트+'</li>'
} // 1. 함수 끝

/* 클릭시 배열 내 요소를 삭제하는 리스트 */
function onDelete(){
	// [입력부]
	// 1. <input>  가져와서 변수에 저장 [DOM객체]
	let sname = document.querySelector('.sname')
	// 2. <input> 입력된 value[값] 가져오기
	let dname = sname.value
	// 3. 값으로 해당하는 요소 인덱스 찾기
	let dindex = 학생리스트.indexOf(dname); // 입력받은 이름의 인덱스 찾기
	// 4. 배열내 해당 인덱스의 요소 제거
	학생리스트.splice( dindex , 1 );
	
	//[출력부]
	// 1.  <ul> 가져와서 변수에 저장 [DOM 객체]
	let slist = document.querySelector('#slist')
	// 2. <ul>  innerHTML 이용한 <ul> {여기에 데이터 넣기} </ul>
	slist.innerHTML = '<li>' + 학생리스트+ '</li>'	
}



















