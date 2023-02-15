package Day11.Ex5;

public class Child extends Parent{	
	public String job;	
	@Override
	public void method2() {
		System.out.println("자식이 부모메소드2 재정의");
	}
	public void method3() {
		System.out.println("자식 메소드3");
	}
}
/*
JAVA에서는 무조건 자식이 부모를 선택해서 기능을 부여받는다
고로 부모는 자식에게 갈 수 없고 반대는 가능하다
 */

