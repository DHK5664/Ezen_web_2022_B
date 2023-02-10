// 1. 클래스의 사용목적 main함수 가지고 있는 클래스

package Day08.Ex1_p218;

public class 실행 { // c s
	public static void main(String[] args) { // m s
		
		// 1. Car 클래스를 이용한 객체 생성
		// 클래스명 변수명 = new 생성자명();
		
		// 1. 기본생성자
		Car car = new Car();
		car.model = "그랜저"; car.color="노랑";		// 객체 깡통 만들고 나중에 초기값 넣기 다이렉트로 접근
		System.out.println( car.toString() );
		
		// 2. 2개의 매개변수 생성자
		Car car3 = new Car("그랜저", "파랑");		// 객체 만들면서 동시에 초기화 간접적으로 접근이라 조건 추가 가능(필터링 가능)
		System.out.println( car3.toString() );
		
		// 3. 3개의 매개변수 생성자
		Car car2 = new Car("그랜저", "검정", 250);	// 객체 만들면서 동시에 초기화 간접적으로 접근이라 조건 추가 가능(필터링 가능)
		System.out.println( car2.toString() );

		
		
	}// m e
}// c e
