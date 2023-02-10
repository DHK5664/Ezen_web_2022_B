package Day08.Ex4_p230;

public class 실행 { // c s
	public static void main(String[] args) {// m s
		
		// powerOn(); // 오류 : 메모리 할당 전이라서
		
		// 1. 외부에서 함수 호출 -> 객체 필요
		Calculator myCalc = new Calculator();
		
		// 2. 객체를 통한 멤버 함수 호출
		myCalc.powerOn();
		
		// 3.
		int result1 = myCalc.plus(5, 6);
		// 오른쪽에 있는것을 왼쪽에 저장 / 즉 5와 6을 계산기 클래스에 3번에 대입후 받은 리턴값을 가져와서 왼쪽에 대입한다는 뜻 대입은 연산 순서가 항상 맨 마지막임
		System.out.println(result1);
		
		// 4.
		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println(result2);
		
		// 5.
		myCalc.powerOff();
		
		// 6. 계산기 클래스의 주석 번호와 짝 맞춤
		System.out.println(myCalc.info());
	}// m e
}// c e
