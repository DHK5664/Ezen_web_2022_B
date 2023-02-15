package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {

		// * 타이어
		Tire tire = new Tire(); // 기본 타이어
		
		// 1. 자동차 객체 만들기
		Car myCar = new Car();
		// 자동차 객체에 타이어객체 1개 포함
		// 2. 기본 타이어 장착
		myCar.tire = new Tire();
		myCar.run();
			Tire result = myCar.parking(tire);
		// 3. 한국 타이어 교치
		myCar.tire = new HankookTire();
		myCar.run();
			
		HankookTire hankookTire = new HankookTire();
			HankookTire result2 = (HankookTire)myCar.parking(hankookTire);
			//Tire 자리에 HankookTire 넣으면 부모는 자식에 넣을 수 없어서 안댐
			//고로 강제타입변환 해주면댐
			
			System.out.println(result2 instanceof Tire);	//	한국 타이어는 타이어로 부터 상속 받았음 True
			System.out.println(result2 instanceof Object);	// Object는 최상위 클래스라서 당연히 상속관계라 True
		
		
		// 4. 금호 타이어 교체
		myCar.tire = new KumhoTire();
		myCar.run();
		
		KumhoTire kumhoTire = new KumhoTire();
			KumhoTire result3 =	(KumhoTire)myCar.parking(kumhoTire);
	}
}
