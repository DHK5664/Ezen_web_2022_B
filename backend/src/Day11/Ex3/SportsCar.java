package Day11.Ex3;

public class SportsCar extends Car{
	@Override
	public void speedUp() {
		super.speedUp();	// 부모 메소드 호출
	}
	@Override
	public void stop() {// 오류 : stop메소드가 final이라서 재정의 불가능
		super.stop();
	}
}
