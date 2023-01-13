
// 1. 인수X 반환X 함수
function 함수1(){// fs
	//function : 함수 선언시 사용되는 키워드 변수 선언시 let 하는것과 같음
		// 함수1 : 함수이름[식별자] 동일한 파일내에서는 중복이름 불가능
			//() : 인수 정의하는곳
			 // {} : 함수가 호출되면 실행 되는 구역
	alert('함수1 실행 됨')
}// f e

// 1. 함수 호출

함수1()

// 2. 인수O 반환O 함수
function 함수2( x , y ){// f s
	// ( x , y ) : 해당 함수를 호출시 인수[x와 y : 이름 아무거나] 2개를 받는 함수
	alert('함수 2 실행 됨')
	return x + y;
}// f e


let result = 함수2(3, 5) // 반환[return] 값을 변수에 저장 let변수명[result]을 써서 저장했음
alert("함수2 실행 후 보내준 값 : " + result )

// 3. 인수O 반환X 함수
function 함수3(x , y , z){
	let result = x + y + z
	alert('함수3 실행 됨 : ' +  result)	//-->중괄호 안에 result가 있어서 지역변수 처리 즉 쓰고 지우고 하기때문에 밖에는 영향 X 
}
함수3( 3, 5, 7)

// 4. 인수X 반환O 함수
function 함수4(){
	let result = 3 + 5 + 8		//--> 혼자 alert나 console.log도 없어서 button을 눌러도 나오는건 없다.
	return result;
	
}
let result2 = 함수4()
alert('함수4 실행 후 보내준 값 :' + result2)	//--> 위에 result가 있어서 result2라고 적었는데 걍 임의로 정한 이름이므로 다른거로 해도 됨







































