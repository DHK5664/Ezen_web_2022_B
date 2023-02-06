package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크 { // c s

	public static void main(String[] args) { // m s
		// * 입력객체 import java.util.Scanner;
		Scanner scanner = new Scanner(System.in);
		// * 가격 변수
		int 콜라가격 = 300;	int 사이다가격 = 400;	int 환타가격 = 500;
		// * 재고 변수
		int 콜라재고 = 10;		int 사이다재고 = 8;		int 환타재고 = 15;
		// * 장바구니 변수
		int 콜라바구니 = 0;		int 사이다바구니 = 0;		int 환타바구니 = 0;
		
		// * 프로그램 실행 반복
		while(true) { // while s
			System.out.println("----------------------------------------------");
			System.out.print("1.콜라 2.사이다 3.환타 4.결제 >>>> ");
			int 메뉴 = scanner.nextInt();
			// 메뉴에 따른 제어 !!!
			if(메뉴 == 1) {
				if(콜라재고 == 0) {System.out.println("콜라 재고가 부족합니다.");}
				else {
					System.out.println("콜라를 선택하셨습니다.");
					콜라바구니++;
					콜라재고--;
					System.out.println("콜라 장바구니 : " + 콜라바구니);
					System.out.println("남은 콜라 갯수 : " + 콜라재고);
				}
			}
			else if(메뉴 == 2) {
				if(사이다재고==0) {	System.out.println("사이다 재고가 부족합니다.");}
				else {
					System.out.println("사이다를 선택하셨습니다.");
					사이다바구니++;
					사이다재고--;
					System.out.println("사이다 장바구니 : " + 사이다바구니);
					System.out.println(" 남은 사이다 개수 : " + 사이다재고);
				}
			}
			else if(메뉴 == 3) {
				if(환타재고==0) {System.out.println("환타 재고가 부족합니다.");}
				else {
					System.out.println("환타를 선택하셨습니다.");
					환타바구니++;
					환타재고--;
					System.out.println("환타 장바구니 : " + 환타바구니);
					System.out.println(" 남은 환타 개수 : " + 환타재고);
				}
			}
			else if(메뉴 == 4) {}
			else {System.err.println("[알림] 알수 없는 번호 입니다. ");}
		}// while e
		
	} // m e
} // c e
