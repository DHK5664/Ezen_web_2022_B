alert('JS 열림') // 스크립트가 열렸을때
// 1. 문서가 열렸을때 DOM 객체 이벤트
//document.addEventListener( 'DOMContentLoaded' , () = > { 실행문 ;} )
document.addEventListener( 'DOMContentLoaded' , () => { // () => { alert('html 열림') 해당 이벤트에서만 사용 가능

	const h1 = document.querySelector('h1')
	
	console.log(h1)
	console.log(typeof(h1))	//typeof() : 데이터형 확인(문자인지 숫자인지 객체인지 함수인지 확인)
	
	h1.innerHTML = '안녕'
	h1.style.color = 'red'
	h1.style.backgroundColor='blue'		//카멜표기법 background-color -> backgroundColor
	h1.style.padding = '10px'
} ) 


// 2.
//document.addEventListener('DOMContentLoaded' , function(){실행문;})
document.addEventListener('DOMContentLoaded' , function(){
	const h1Array = document.querySelectorAll('h1')
	
	console.log(h1Array)
	console.log(typeof(h1Array))	// typeof() : 데이터형 확인
	
	// * 배열내 데이터[요소]들을 하나씩 꺼내는 방법 
	// 1. 젤 중요!!!!!
	for(let i = 0 ; i<h1Array.length ; i++){	// i라는 임시변수를 인덱스처럼 반복문에서 사용
		h1Array[i].innerHTML = '안녕'+i			// 이 for문은 꼭꼭 알아두자!!!!!!!!!!!!!!!!
	} // for end
	// 2.
	for(let index in h1Array){					// 배열 내 요소 모든 인덱스를 마지막까지 하나씩 반복변수 대입
		h1Array[index].innerHTML = '안녕' + index
	} // for end
	// 3. 
	for( let object of h1Array ){				// 배열 내 요소 모든 데이터를 마지막까지 하나씩 반복변수에 대입
		object.innerHTML = '안녕'
	} // for end
	// 4.
	h1Array.forEach( (object) => {object.innerHTML = '안녕~~'} )
		// 배열명.forEach(화살표함수)
		// 배열명.forEach((인수)=>{실행문;})
		// 배열명.forEach( (요소값) => {실행문;})
	h1Array.forEach( (object) => console.log(object) )	// 3번 동일
		// 배열명.forEach((요소값 , 인덱스) => {실행문;})
	h1Array.forEach((object,index) => {console.log(object); console.log(index); })	// 3번 4번 섞음
		// 배열명.forEach((요소값 , 인덱스 , 배열) => {실행문;})
	h1Array.forEach((object,index,array) => {
		console.log(object); console.log(index); console.log(array);
	
	})		
}
)
























