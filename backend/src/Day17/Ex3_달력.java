package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {// c s
	public static void main(String[] args) {// m s
		// - static 멤버는 인스턴스 멤버 호출 X
		// 1. [해당 멤버[메소드/필드] 가 static멤버 ]run메소드도 정적멤버 하자
			run2();
		// 2. [해당 멤버[메소드/필드] 가 인스턴스멤버] 객체 만들어서 메소드 호출 하자
			Ex3_달력 ex3_달력 = new Ex3_달력();
			ex3_달력.run();
		
	}// m e
	
	// 1. 달력함수
	static void run2() {}
	void run() {
		Calendar cal = Calendar.getInstance();		// 1. 현재 날짜
		int year = cal.get(Calendar.YEAR);			// 2. 현재 년도
		int month = cal.get(Calendar.MONTH)+1;		// 3. 현재 월
		int day = cal.get(Calendar.DAY_OF_MONTH);	// 4. 현재 일
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.printf("=================== %d 년 %d 월 ===================\n" , year , month);
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			// *** 1. 현재 월의 1일 날짜의 요일
			cal.set(year, month-1 , 1 );	// 캘린더 날짜 수정 : 현재 연도/월 의 1일 날짜 형식으로 변경
			int sweek = cal.get( Calendar.DAY_OF_WEEK );	// 2023-02-01 요일 -> 4
			
			// *** 2. 현재 월의 마지막 일
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	// 2023-02월의 일수의 최대수 = 마지막 일 = 28
			
			// * 출력
			// * 해당 월 1일의 요일 전까지 공백으로 채우기
			for(int i = 1 ; i<sweek ; i++) {System.out.print("\t");}
			//*
			for(int i = 1 ; i<=eday ; i++) {
				System.out.printf("%2d\t" ,i);
				if(sweek%7==0)System.out.println();// * 7일마다 줄바꿈
				sweek++;	// 요일 증가	
			}
			System.out.println("\n===============================================");
			System.out.print("1.이전달 2.다음달 3.검색 : "); int ch = scanner.nextInt();
			if(ch==1) {
				month--;
				// 만약에 월이 0이면 월은 12, 연도 1차감
				if(month<1) {month=12; year--;}
			}
			if(ch==2) {
				month++;
				// 만약에 월이 13이면 월은 1, 연도 1증가
				if(month>12) {month=1; year++;}
			}
			if(ch==3) {
				System.out.println("연도:");		int inputY = scanner.nextInt();
				System.out.println("월:");		int inputM = scanner.nextInt();
				// 만약에 정상 입력이면
				if(inputY >= 1900 && inputY<=9999 && inputM >=1 && inputM<=12) {
					year = inputY;	month=inputM;
				}
				// 아니면
				else { System.out.println("[★] 출력할 수 없는 달력입니다. "); }
			}
		}
		
	}
	
}// c e
















