package Day11.Ex4.package2;
import Day11.Ex4.package1.A;
//----------------- 패키지 2 ------------------ //

public class C {
	public void method() {
		A a = new A(); // X
		a.field = "value"; // X
		a.method(); // X
	}
}
