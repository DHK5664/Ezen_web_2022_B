package Day11.Ex4.package1;
// ----------------- 패키지 1 ------------------ //

public class A {

	protected String field;
	protected A() {}
	protected void method() {}
}
/*protected 서로 같은 패키지일때는 가능
 근데 상속받은 자식은 부모의 필드 , 생성자 , 메소드 접근 가능 하지만
 new 연산자로 생성자를 직접 호출은 안댐
*/