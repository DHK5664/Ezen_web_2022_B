package Day13.Ex5_p376;

public class Car {
	// 타입 : 인터페이스 [ 해당 인터페이스를 구현한 클래스들의 구현객체를 여러개 대입 ]
	Tire tire1 = new HankookTire();	
	Tire tire2 = new HankookTire();
// 타이어 대신 한국타이어를 넣어도 되지만 그렇게 하면 타이어교체해야 할 때 금호타이어는 사용 불가이기 때문
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
