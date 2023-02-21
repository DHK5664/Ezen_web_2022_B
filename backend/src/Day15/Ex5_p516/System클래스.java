package Day15.Ex5_p516;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class System클래스 {
	public static void main(String[] args) throws Throwable {
		
		// p.517
		long time1 = System.nanoTime();	// 현재시간을 나노초로 표현
		System.out.println(time1);
		int sum = 0;
		for(int i = 1 ; i<=1000000; i++) {	// 백만번 반복	[ *CPU마다 다름 ]
			sum += i;	// i를 sum에 누적 합계 더하기
		}
		long time2 = System.nanoTime();	// 현재시간을 나노초로 표현
		System.out.println((time2 - time1) + "나노초가 소요 되었습니다.");
		
		// p.518
		System.out.println("--------------------------------");
		System.out.println("key    :         value");
		System.out.println("--------------------------------");
		Properties props = System.getProperties();	// 모든 시스템 속성 호출
		
		for(Object obj : props.keySet()) {	// 시스템 속성들의 키들을 반복문 돌리기
			System.out.println(
					
						(String)obj + "                       " +	// 해당 키를 문자열 반환 
						System.getProperty((String)obj));			// 해당 키를 이용한 시스템 속성 정보 호출
		}
		
		// p.520
		String data = "자바"; // 문자열 저장하고 조작하는 클래스
		// 해당 문자열을 바이트열로 변환 getBytes()			인코딩 타입 : UTF-8		[한글 3바이트]
		byte[] arr1 = data.getBytes();
		// 배열의 주소값 출력
		System.out.println(arr1);
		// 배열내 데이터 출력 Arrays.toString(배열명)
		System.out.println(Arrays.toString(arr1));
		
		// 문자열 -> 바이트열로 변환 getBytes("EUC-KR")	인코딩 타입 : EUC-KR	[한글 2바이트]
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println(Arrays.toString(arr2));
		
		// 바이트열 -> 문자열 new String(배열명);
		String str1 = new String(arr1);
		System.out.println(str1);
		
		String str2 = new String(arr2 , "EUC-KR");
		System.out.println(str2);
	}
}
/*

	밀리초 ->								1/1000	
		마이크로초	-> 						1/1,000,000	
			나노초 ->						1/1.000,000,000
			 	피코초 -> 				1/1.000,000,000,000
			 		펨토초 ->				1/1.000,000,000,000,000
			 			아토초 ->			1/1.000,000,000,000,000,000
			 				젭토초 ->		1/1.000,000,000,000,000,000,000
			 					욕토초	1/1.000,000,000,000,000,000,000,000
	

*/


