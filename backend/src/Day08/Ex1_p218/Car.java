// 2. 클래스의 설계 목적

// 클래스 선언
	// 1. 첫글자 대문자인 영문시작
	// 2. 띄어쓰기X , 숫자로 시작X
	// 3. 멤버 : 1.필드 2.생성자 3.메소드
package Day08.Ex1_p218;

public class Car {	// c s

	// 1. 필드
	String model;
	String color;
	int maxSpeed;
	
	// 1. 빈생성자 = 객체 생성시 매개변수 없다 , 초기값이 없다.
	Car() { }
	// 2. 생성자 = 2개의 매개변수를 받는다.	-> 초기값을 필드에 대입하는 목적
	Car(String model, String color) { 
		this.model = model;		// this.내부필드명 = 매개변수
		this.color = color;
	}
	// 3. 생성자 = 3개의 매개변수를 받는다.	
	Car( String model , String color , int maxSpeed ){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}

	// 2. 생성자	* 리턴이 따로 없음
		// 1. 생성자가 1개도 선언이 없을때 기본생성자 사용가능
		// 2. 생성자 이름은 클래스명과 동일!!!!!!!! 다르면 함수[메소드] 취급!!!!!!!!
		// 3. 기본생성자[깡통] , 풀생성자 -> 관례적으로 만들고 시작
		// 4. 오버로딩 : 이름이 동일할 경우 시그니처( 매개변수 개수 , 타입 ) 구분해서 식별가능 // 자바에서 지원해줌
		// 		vs 오버라이딩 : 부모의 메소드를 다시 정의	즉 object 꺼인 오버로딩을 짐 현재 필드에 맞게 재정의해준다는 뜻으로 생각.

	
	// 3. 메소드
	
	
	
	
}// c e
















/*자바는 무조건 object한테 상속을 받음 그래서 그렇게 toString을 만들어둠
 이를 이용하면 객체 주소값을 얻을 수 있는데
 우리가 알아 볼 수 없게 되어있음
 */

