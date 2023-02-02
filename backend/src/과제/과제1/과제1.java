package 과제.과제1;

import java.util.Scanner;

public class 과제1 { // c s

	public static void main(String[] args) { // m s
		Scanner scanner = new Scanner(System.in);
		/*
		// 문제 1
		System.out.println("문제1 : 강아지 console 출력");
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		*/
		
		/*
		// 문제 2
		System.out.println("문제2 : 입력받은 변수 3개 데이터를 이용한 표 만들기");				
		// [입력 -> 저장] 
		System.out.print("작성자 : ");	String 작성자 = scanner.next();
		scanner.nextLine();
		System.out.print("내용 : "); 		String 내용 = scanner.nextLine();	
		System.out.print("날짜 : " ); 	String 날짜 = scanner.next();	
		
		//[출력]
		System.out.println("--------------방문록--------------------");
		System.out.printf("%3s | %6s |  %15s | %6s |\n " , "번호" , "작성자" , "내용" , "날짜");
		System.out.printf("%4d | %6s |  %15s | %6s |\n " , 1 , 작성자 , 내용 , 날짜);
		System.out.println("----------------------------------------");
		*/
		
		/*
		// 문제 3
		// [ 입력 -> 저장 ]
		System.out.print(" 기본급 : ");   int 기본급 = scanner.nextInt();	
		System.out.print(" 수당 : ");		int 수당 = scanner.nextInt();
		// [ 계산 ]
		System.out.printf("실수령액 : " + (기본급+수당-(int)(기본급*0.1)));
		// int= int + int - (int*double) = double() int * double => 피연산자중 더 큰 허용범위 결과로 나옴
		// 그래서 강제 타입 변환을 해야 함 '(int)double' double을 int로
		*/
		
		/*
		// 문제 4
		// [ 입력 -> 저장 ]
		System.out.print(" 금액 : " ); int 금액 = scanner.nextInt();	
		// [ 출력 = 십만원권 ]
		System.out.println(" 십만원권 : " + (금액/100000)+"장");
		// [ 출력 = 만원권 ]
		금액 -= (금액/100000) * 100000; 		// 1. 원금[금액]에서 십만원권 제외
		System.out.println(" 만원권 : " + (금액/10000)+"장");
		// [ 출력 = 천원 ]
		금액 -= (금액/10000) *10000;	// 1. 원금[금액]에서 만원권 제외
		System.out.println(" 천원 : " + (금액/1000)+"장");
		// [ 출력 = 백원 ]
		금액 -= (금액/1000) *1000; 		// 1. 원금[금액]에서 천원권 제외
		System.out.println(" 백원 : " + (금액/100)+"장");
		*/
		
		/*
		// 문제 5
		// [ 입력 -> 저장 ]
		System.out.print("숫자를 입력하시오 : "); int 숫자1 = scanner.nextInt();
		// [ 출력 ]
		String 결과 = (숫자%7==0)? "7의 배수이다" : "7의 배수 아님"; System.out.print(" 결과 : " + 결과);
		*/
		
		/*
		// 문제 6
		// [ 입력 -> 저장 ]
		System.out.print("숫자를 입력하시오 : "); int 숫자2 = scanner.nextInt();
		String 결과 = (숫자%2==1)? "홀수" : "홀수 아님"; System.out.print(" 결과 : " + 결과);
		*/
		
		/*
		// 문제 7
		// [ 입력 -> 저장 ]
		System.out.print("숫자를 입력하시오 : "); int 숫자3 = scanner.nextInt();
		String 결과 = (숫자%7==0 && 숫자%2==0)? "7의 배수이면서 짝수이다" : "아님";	System.out.print(" 결과 : " + 결과);
		*/
		
		/*
		// 문제 8
		// [ 입력 -> 저장 ]
		System.out.print("숫자를 입력하시오 : "); int 숫자4 = scanner.nextInt();
		String 결과 = (숫자%7==0 && 숫자%2==1)? "7의 배수이면서 홀수이다" : "아님";	System.out.print(" 결과 : " + 결과);
		*/
		
		/*
		// 문제 9
		// [ 입력 -> 저장 ]
		System.out.println("숫자1 : ");	int 숫자5 = scanner.nextInt();
		System.out.println("숫자2 : ");	int 숫자6 = scanner.nextInt();
		String 결과 = (숫자1>숫자2)? "숫자1" : (숫자1<숫자2)?  "숫자2" : "둘이같다"; System.out.print("결과 : " +  결과);
		// int를 String안에 그냥은 쓸 수 없으므로 문자열식인 String 식으로 바꿔서 출력한다.
		*/
		
		
		// 문제 10
		System.out.println("반지름 : ");	int 반지름 = scanner.nextInt();
	} // m e
	
} // c e


















