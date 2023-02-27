package Day19.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EX1_p604 {

	public static void main(String[] args) {
		
		// 1.
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		for(int i = 0 ;  i<10 ; i++) {
//			toolkit.beep(); // 비프음 내기
//			try {
//				Thread.sleep(3000); // 3초간 해당 스레드를 일시정지[ 3초간 cpu(명령어처리) 점유 불가 ]
//			}catch (Exception e) {	}
//		}
		// 2. 콘솔에 시계 만들기
//		while(true) {
//			Date date = new Date(); // 날짜/시간 클래스
//			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss초"); // 날짜/시간 꾸미기 [형식]
//			System.out.println(sdf.format(date));
//			try{Thread.sleep(1000);}
//			catch (Exception e) {}
//			for(int i = 0; i<100 ; i++) {System.out.println();}// 100줄 공백채우기
//		}
		// 3. 
//		SumThread sumThread = new SumThread();
//		sumThread.start();
//		System.out.println(sumThread.getSum());
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();
		}catch (Exception e) {	}
		System.out.println(sumThread.getSum());
	}
	
}
