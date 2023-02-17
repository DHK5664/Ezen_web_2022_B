package Day13.Ex4_p365;

public class 실행 {
	
	/*
	
			A엄마		B아빠
				상속
				C나
	
	*/
	public static void main(String[] args) {
		// 1. 객체 만들기
		InterfaceCImpl impl = new InterfaceCImpl();
		
		// 2. 인터페이스 변수에 구현객체 대입
		InterfaceA ia = impl;
		ia.methodA();	// 본인 추상 메소드 호출 가능
		//ia.methodB();	// X
		//ia.methodC();	// X
		
		// 2.
		InterfaceB ib = impl;
		//ib.methodA();	// X
		ib.methodB();	// 본인
		//ib.methodC();	// X
		
		// 2.
		InterfaceC ic =impl;
		ic.methodA();	// O
		ic.methodB(); 	// O
		ic.methodC();	// O
	}
}
