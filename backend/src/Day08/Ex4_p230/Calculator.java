package Day08.Ex4_p230;

public class Calculator {
	// 1.필드
	// 2.생성자
	// 3.메소드
		// 1. 인수X 반환X 
	void powerOn () {
		System.out.println("전원을 켭니다.");
	}
		// 2. 인수X 반환X 
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
		// 3. 인수 : x , y	반환 : int	// 예) x=3 y=5		return = 8
	int plus( int x , int y ) {
		int result = x + y;
		return result;
	}
		// 4. 인수 : x , y / 반환 : double	// 예) x=3 y=5		return = 0.6
	double divide(int x , int y ) {
		double result = (double)x / (double)y;
		return result;
	}
		// 5. 인수 : x , y / 반환 X
	void multiply(int x , int y ) {
		double result = (double)x * (double)y;
		System.out.println( result );
	}
		// 6. 인수 X / 반환 O
	String info() {
		return "이젠 계산기";
	}
	
		// 7. 내부에서 함수호출	. 을쓰는 이유가 .이 접근연산자인데 이미 함수가 안에 들어와있는 상황이라 굳이 더 들어갈 필요가 읍슴
	void 함수호출() {
		powerOn(); // 내부에서 함수 호출시 : 함수명();
	}
	
}
/*
 함수 = 메소드
 
 js 선언부						java 선언부
 function 함수명(인수명){			리턴타입 함수명 (인수1,인수2){

 }								}
 
 js 호출							java 내부 호출
 함수명(인수1,인수2)					함수명( 인수 1 , 인수 2 )
 
 								java 외부 호출 - 객체명 필요	// 함수를 담고있는 객체명을 통해서 호출
 								객체명.함수명( 인수1 , 인수2 )
 								
 								
 								
 	1.	인수 X 반환 X					
 		void 함수명()	{}
 								
 	2.	인수 O 반환X	
 		void 함수명 (인수1, 인수2){}				
 	
 	3.	인수X 반환 O							
 		리턴타입 함수명() { return 값;}
 								
 	4.	인수 O 반환O
 		리턴타입 함수명( 인수1 , 인수2 ){ return 값; }
 								
 								
 								
 								
 								
 								
 								
 								
 								
 
 */
