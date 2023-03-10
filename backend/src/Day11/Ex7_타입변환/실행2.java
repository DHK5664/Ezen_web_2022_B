package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {//c s
	public static void main(String[] args) {//m s
		
		// *
		 Tire tire = new Tire();
		 KumhoTire kumhoTire = new KumhoTire();
		 HankookTire hankookTire = new HankookTire();
		 
		 // 1. 참조타입의 자동타입 변환
		 Tire temp = tire;
		 	Tire temp2 = kumhoTire;
		 		Tire temp3 = hankookTire;
		 			Object temp4 = temp3;
		 			
		 // 2. 강제타입 변환
		 Tire tire2 = (Tire)temp4;
		 	KumhoTire kumhoTire2 = (KumhoTire)tire2;
		 		HankookTire hankookTire2 = (HankookTire)tire2;

		 // 3. 매개변수 , 리턴타입	
		 Tire result = 함수1( kumhoTire2 );
		 KumhoTire result2 = (KumhoTire) 함수2((KumhoTire) temp2);
		 
		 // 4. 배열 , ArrayList : 동일한 타입만 가능
		 ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		 kumhoList.add(kumhoTire);		// O
		 kumhoList.add(hankookTire);	// X	
		 kumhoList.add(tire);			// X	// 부모는 자식한테 갈 수 없다
		 // -------->
		 ArrayList<Tire>TireList = new ArrayList<>(); // 되는 이유 ? 다형성
		 TireList.add(kumhoTire);	// O
		 TireList.add(hankookTire);	// O	// 자식은 부모한테 갈 수 있지만
		 TireList.add(tire);		// O
		 
	}// m e
	
	public static KumhoTire 함수1(Tire tire) {return new KumhoTire();}
	public static Tire 함수2(KumhoTire kumhoTire) {return new Tire();}
}// c e
