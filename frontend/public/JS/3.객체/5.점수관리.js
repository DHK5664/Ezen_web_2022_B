// * 학생들의 점수 객체를 여러개 저장하는 배열
let studentArray = [ ]
// 1. JS열렸을때 <button> 객체 가져오기
let addbtn = document.querySelector('.addbtn')
// 2. 해당 버튼에 이벤트
addbtn.addEventListener( 'click' , () => {
	
	// 1. 입력받은 데이터를 하나씩 가져와서 객체화
		// * input 숫자를 입력해도 value는 무조건 문자열을 가져온다. 형변환 필요!!
		// parseInt(문자열) -> 정수
	let info = {
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		mat : parseInt(document.querySelector('.mat').value)
	}
		console.log(info)
		
	// 2. 유효성 검사 [ 데이터 체크 ]
	let check = true;	// 유효성검사 상태 저장하는 변수 [아래 4개중 하나라도 충족하면 저장 실패]
			// 1. 이름 중복체크
		for(let i = 0 ; i< studentArray.length ; i++){
			if(studentArray[i].name  == info.name){
				alert('이미 등록된 이름입니다.'); check=false;
			}// if e
		}// for e
			// 2. 점수 0~100 사이만 입력
	if( ( info.kor < 0 || info.kor > 100 )||
	  	( info.eng < 0 || info.eng > 100 )||
	 	( info.mat < 0 || info.mat > 100 ) ){
		alert('입력할 수 없는 점수범위 입니다.[0~100 사이만 가능]');check=false;
	}
			// 3. 이름이 3~5 사이만 입력
	if( info.name.length < 3 || info.name.length > 5 ){
		alert('이름은 3~5글자로 입력해주세요');check=false;
		}
			// 4. 숫자 아닐경우 [isNaN() : 숫자형식 체크 [true of false]]
	if(isNaN(info.kor) || isNaN(info.eng) || isNaN(info.mat) ){
		alert('숫자형식으로 입력해주세요.');check=false;
	}
	// 3. 저장 [위 유효성검사에서 하나도 충족하지 않았을 때]
	if(check){studentArray.push( info ); alert('학생 점수를 등록했습니다');printTable(); }
		
} )	//addEvent end
// 2. 배열 내 객체 정보를 테이블에 출력하는 함수 [ 1. JS열렸을 때 2. 등록할때마다/업데이트 3. 삭제 할때마다 4. 수정 할때마다]
printTable(); // 함수 호출
function printTable(){ // 함수 정의
	
	//1. html 구성
	let html = `<tr>
					<th> 번호 </th><th> 이름 </th><th> 국어 </th>
					<th> 영어 </th><th> 수학 </th><th> 총점 </th>
					<th> 평균 </th><th> 순위 </th><th> 비고 </th>
				</tr>`
	// 2. 배열 내 객체정보를 html에 대입
	studentArray.forEach(( o , i )=>{	// o = 값 / i = 인덱스
	
		// 1. 총점
		let total = o.kor + o.eng + o.mat;
		// 2. 순위 구하기
		let rank = 1;
		studentArray.forEach((o2)=>{
			// 1. 비교할총점
			let total2 = o2.kor+o2.eng+o2.mat;
			// 2. 만약에 총점이 비교할 총점보다 작으면 순위 하락
			if(total < total2 ){ rank++;}
		})
	
		html +=`<tr><td> ${i+1} </td>		<td> ${o.name}</td>		<td> ${o.kor} </td>
					<td> ${o.eng} </td>		<td> ${o.mat} </td>		<td> ${ total } </td>
					<td> ${ parseInt( (total)/3) } </td>	<td> ${rank} </td>
					<td> <button onclick="onDelete( ${ i } )">삭제</button>
						 <button onclick="onUpdate( ${ i } )">수정</button> </td>
				</tr>`
	} )
	// 3. 
	document.querySelector('.listtable').innerHTML = html;	
}// f e

// 3. 배열 내 객체 삭제	[ 삭제할 인덱스 !!! ]
function onDelete( i ){
	studentArray.splice(i,1); // 선택한 i번째 인덱스 객체 삭제
	printTable();// 삭제 후 새로고침/업데이트
}
// 4. 수정 버튼을 클릭했을때 [ 수정할 인덱스!!! ]
let upindex = -1 ; // 수정할 인덱스 // 여럿 {}에서 동일한 변수 사용하려고 // 전역변수 
// -1 넣은 이유는 upindex가 일단 index이고 index는 0부터 시작해서 뭐 굳이 다른 숫자를 넣어도 상관없긴 하지만 안정빵으로 -1을 넣는것이다
function onUpdate( i ){
	upindex = i // i값을 upindex에 대입// 내가 선택한 i번째 인덱스
	document.querySelector('.updatebox').style.display = 'block'		// 1. 수정페이지 보여주기
	// 2. 선택한 i번째 객체의 속성 데이터를 대입
	document.querySelector('.upname').value = studentArray[upindex].name
	document.querySelector('.upkor').value = studentArray[upindex].kor
	document.querySelector('.upeng').value = studentArray[upindex].eng
	document.querySelector('.upmat').value = studentArray[upindex].mat
	
}// f e

// 5. 점수수정 버튼을 클릭했을때
let updatebtn = document.querySelector('.updatebtn')
updatebtn.addEventListener('click' , ()=>{
	
	// 1. 수정된 데이터 가져오기 // 2. 해당 객체의 속성 값 변경
	studentArray[upindex].kor = parseInt(document.querySelector('.upkor').value)
	studentArray[upindex].eng = parseInt(document.querySelector('.upeng').value)
	studentArray[upindex].mat = parseInt(document.querySelector('.upmat').value)
	
	document.querySelector('.updatebox').style.display = 'none'// 3. 수정페이지 숨기기
	
	
	printTable();// 4. 수정 후 새로고침/업데이트
	
})




/*studentArray.forEach( ( obj ) => { // 1. 번 for문과 같은 놈임 근데 함수이고 for문이  훨씬 더 빠름
		if(obj.name == info.name){ 
			alert('현재 등록된 학생명입니다.');
			return;
		}//
	})//	*/
	
	
	// 2.
	
	
	
	/* 배열 내 순위
	예시)
		for1 :		80 90 75 100	
		for2 :		80 90 75 100
		
			1. 
				80일때  rank = 1	
					80일때	80 < 80 	f
					90일때	80 < 90	 	t rank ++ rank = 2
					75일때	80 < 75 	f 
					100일때  80 < 100	t rank ++ rank = 3
				90일때  rank = 1	
					80일때	90 < 80		f
					90일때	90 < 90		f
					75일때	90 < 75		f
					100일때	90 < 100	t rank ++ rank = 2
				75일때  rank = 1	
					80일때	75 < 80		t rank ++ rank = 2
					90일때	75 < 90		t rank ++ rank = 3
					75일때	75 < 75		f
					100일때	75 < 100	t rank ++ rank = 4
				100일때 rank = 1	
					80일때	90 < 80		f
					90일때	90 < 90		f
					75일때	90 < 75		f
					100일때	90 < 100	f 		  rank = 1
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	*/
	
	
	
	
	
	
	
	
	