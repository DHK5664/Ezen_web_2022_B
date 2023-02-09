package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {// c s

	public static void main(String[] args) { // m s
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		// * 리스트 선언 [ Book 객체를 여러개 저장할 리스트 ]
		ArrayList<Book> bookList = new ArrayList<>();	// 가변길이
		
		while(true) { // while s [무한루프/종료수단 X ]
			
			// * 출력		배열명[인덱스]	vs 리스트명.get(인덱스)
			System.out.println("--------------- 이젠 도서관 ---------------");
			System.out.println("번호\t대여여부\t장르\t도서명");
			for(int i = 0 ; i<bookList.size(); i++) {	// i = 0부터 리스트내 마지막 인덱스까지 1씩증가
				System.out.printf("%d \t %s \t %s \t %s\n",
						i , (bookList.get(i).state ? "가능" : "불가능") ,//삼항 연산자로 해당 책 대여상태 확인 true면 대여가능 false면 대여불가 
						bookList.get(i).genre , bookList.get(i).name);
			}// for e
			
		System.out.println("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자]");
		int ch = scanner.nextInt();		// 채널 선택 (1번 도서대여 2번 도서반납 ~~ )
		if(ch==1) {	// 1번 채널 선택시
			System.out.println("--- 대여 페이지 ---");
			System.out.println(" 대여할 도서번호 : "); int bno = scanner.nextInt();	// 대여할 도서번호(bno) 입력받음
			if(bookList.get(bno).state == true ) { //만약에 입력한 도서인덱스의 도서상태가 true이면 대여 가능한상태
				System.out.println("[알림] 대여완료");
				bookList.get(bno).state = false;	// 대여중으로 변경(false값을 bookList의 state값에 대입해줌)
			}else {									// because 위에 삼항연산자에서 false값일시 대여중이라고 했기때문
				System.out.println("[알림] 대여중인 도서입니다. ");
			}
		}
		else if(ch==2) {
			System.out.println("--- 반납 페이지 ---");
			System.out.println(" 반납할 도서번호 : "); int bno =scanner.nextInt();
			if(bookList.get(bno).state == false ) {	// 만약에 입력한 도서인덱스의 도서상태가 false 이면 반납 가능한 상태
				System.out.println("[알림] 반납완료");
				bookList.get(bno).state = true;		// 대여 가능으로 변경
			}else {
				System.out.println("[알림] 대여한 도서가 아닙니다. ");
			}
		}
		else if(ch==3) {
			System.out.println("--- 등록 페이지 ---");
			// 1. 입력받기 --> 변수 3개 [입력 2 , 초기1 ]
			System.out.println("도서명 : ");	String inputName = scanner.next();	// 문자열 클래스 String으로 변수 inputName으로 입력받음
			System.out.println("장르 : ");	String inputGenre = scanner.next();
											boolean basicState = true;			// 논리형 변수 basicState에 true값 대입
			// 2. 서로 다른 자료형의 변수들을 하나의 자료형 만들자 [클래스]
			Book book = new Book();	// 클래스 이용해서 book이라는 이름 가진 객체생성
			book.name = inputName; book.genre = inputGenre; book.state = basicState; //위에서 입력받은 값들 각각 객체에 대입			
			// 3. 배열 or 리스트 저장
			bookList.add(book);	// 그렇게 입력받아서 만들어진 객체 bookList라는 리스트에 대입
		}
		else {
			System.out.println("[알림] 알수없는 행동 입니다.");
		}
			
		}// while e
	}// m e
}// c e
