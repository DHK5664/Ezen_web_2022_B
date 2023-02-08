package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {// c s

	public static void main(String[] args) {// m s
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 1. 배열선언 : 자료형타입[] 배열명 = {데이터1,데이터2,데이터3}
		// * 게임판 0칸 문자열 선언
		String[] 게임판 = {
							"[ ]" , "[ ]" , "[ ]" ,
							"[ ]" , "[ ]" , "[ ]" ,
							"[ ]" , "[ ]" , "[ ]" };
		// * 승리판단 결과 저장 변수
		boolean 결과 = false;		// false일땐 결과 판단 없음. 
		
		game : while(true) {// while s // * 무한반복 [ 종료조건 : 승리판단 있을경우 ]
			
			// ---------------2. 배열내 데이터 호출 / 게임판 출력 ---------------------
			for(int i = 0 ; i<게임판.length ; i++) {
				System.out.print(게임판[i]);
				// * 만약에 3칸마다[3배수] 줄바꿈(인덱스 번호로 하기때문에 2 5 8마다 줄바꿈해야댐 그래서 2%3 등 하면 2가 남음)
				if( i % 3 == 2 ) {System.out.println(); }
			}
			// -----------------------------------------------------------
			//-------------- 3. 플레이어가 알두기-------------------//			
			while(true) { // 무한루프 [ 종료조건 : 정상 알두기 했을 때 break;]
				System.out.println("위치[0~8] 선택 : ");
				int 위치 = scanner.nextInt();
				// 유효성검사 [ 1. 0~8 사이가 아니거나 2. 이미 알이 존재한 자리 --> 다시 입력 ]			
				if( 위치 < 0 || 위치 > 8 ) {// 1. 0~8 사이의 숫자가 아니면 다시입력
					System.err.println("[알림] 허용 범위내 입력해주세요. ");
					continue; // 가장 가까운 반복문 이동
				}			
				if( !게임판[위치].equals("[ ]")) {	// 2. 공백이 아니면 다시입력
					System.err.println("[알림] 이미 알이 존재하는 위치입니다. ");
					continue;	// 가장 가까운 반복문 이동
				}
				게임판[위치]="[O]"; // * 유효성검사 통과후 정상적으로 알두기
				break;	// 가장 가까운 반복문 탈출
			}// while e
			
			// 1. 승리판단
			// 1. 가로승리 : 0 1 2 / 3 4 5 / 6 7 8
		for(int i = 0 ; i<=6 ; i+=3) {
			if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+1])&&게임판[i+1].equals(게임판[i+2])) {
				System.out.println("[결과] : " + 게임판[i]);
				break game; // 1. * 최상위 반복문 종료
				//return ; 	// 2. main 함수 탈출
				//결과 = true; // 3. 상태변수 활용
			}
		}
			// 2. 세로승리 : 0 3 6 / 1 4 7 / 2 5 8
		for(int i = 0 ; i<=2 ; i++) {
			if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+3])&&게임판[i+3].equals(게임판[i+6])) { 
				System.out.println("[결과] : " + 게임판[i]);
				break game; // * 최상위 반복문 종료
			}
		}
			// 3. 대각선승리 : 0 4 8 / 2 4 6
		if(!게임판[0].equals("[ ]") && 게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8])) {
			System.out.println("[결과] : " + 게임판[0]);
			break game; // * 최상위 반복문 종료
		}
		if(!게임판[2].equals("[ ]") && 게임판[2].equals(게임판[4])&&게임판[4].equals(게임판[6])) { 
			System.out.println("[결과] : " + 게임판[2]);
			break game; // * 최상위 반복문 종료
		}
		
		// 3. 무승부 : 알이 9개이면 무승부
		int 빈자리수 = 0;
		for( int i = 0 ; i<게임판.length ; i++) {
			if( 게임판[i].equals("[ ]") ) 빈자리수++;
		}
		if( 빈자리수  == 0 ) { System.out.println("[결과] 무승부"); break game; }
			
			//------------- 4. 컴퓨터가 알두기 -------------------//
			while(true)	{ // * 무한반복 [ 종료조건 :정상적인 난수 생성될때 break; ]
				Random random = new Random();	// 난수 관련된 메소드 제공
				int 위치 = random.nextInt(9);		// 0~8
				if(!게임판[위치].equals("[ ]") ) { continue; }
				게임판[위치] = "[X]"; break;
			}// while e			
			//------------- 5. 승리판단 [ 1. 승리 2. 패배 3. 무승부 ]  -------------------//
			
				// 무승부 복사 붙여넣기
			
			//--------------------------------------------------------------------//
			
			// 1. 승리판단
				// 1. 가로승리 : 0 1 2 / 3 4 5 / 6 7 8
			for(int i = 0 ; i<=6 ; i+=3) {
				if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+1])&&게임판[i+1].equals(게임판[i+2])) {
					System.out.println("[결과] : " + 게임판[i]);
					break game; // 1. * 최상위 반복문 종료
					//return ; 	// 2. main 함수 탈출
					//결과 = true; // 3. 상태변수 활용
				}
			}
				// 2. 세로승리 : 0 3 6 / 1 4 7 / 2 5 8
			for(int i = 0 ; i<=2 ; i++) {
				if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+3])&&게임판[i+3].equals(게임판[i+6])) { 
					System.out.println("[결과] : " + 게임판[i]);
					break game; // * 최상위 반복문 종료
				}
			}
				// 3. 대각선승리 : 0 4 8 / 2 4 6
			if(!게임판[0].equals("[ ]") && 게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8])) {
				System.out.println("[결과] : " + 게임판[0]);
				break game; // * 최상위 반복문 종료
			}
			if(!게임판[2].equals("[ ]") && 게임판[2].equals(게임판[4])&&게임판[4].equals(게임판[6])) { 
				System.out.println("[결과] : " + 게임판[2]);
				break game; // * 최상위 반복문 종료
			}
			
			// 3. 무승부 : 알이 9개이면 무승부
			빈자리수 = 0;
			for( int i = 0 ; i<게임판.length ; i++) {
				if( 게임판[i].equals("[ ]") ) 빈자리수++;
			}
			if( 빈자리수  == 0 ) { System.out.println("[결과] 무승부"); break game; }
			
		}// while e		
	}// m e
}// c e





























