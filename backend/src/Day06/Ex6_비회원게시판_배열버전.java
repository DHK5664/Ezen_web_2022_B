package Day06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_배열버전 {// c s

	public static void main(String[] args) throws Exception {// m s	// 2. 예외처리 던지기
		
		// step1 : 필요한 데이터 입력받아 저장
		// step2 : 쓰기 페이지 실행되는 조건
		// step3 : 입력된 데이터를 파일처리[영구저장]
		// step4 : 파일에 있는 문자열 가지고 오기
		// * 입력객체
		Scanner scanner = new Scanner(System.in);		
		while(true) {
			
			// 현재 파일에 존재하는 모든 문자열 호출
			// 1. 파일 입력 클래스 객체 생성 (파일경로)
			FileInputStream fin = new FileInputStream("c:/java/board.txt");
			// 2. 읽어온 바이트를 저장하기 위해 바이트배열 1000바이트 미리 생성
			byte[] inbytes = new byte[ 1000 ];	// 영문 1바이트(특수문자도) , 한글 3바이트	[아스키코드 지원하는 글자는 1바이트 아닌건 3바이트]
			// 3. .read() 메소드를 이용한 파일 읽기 [* 읽은 바이트를 바이트배열 저장 ]
			// inbytes : 읽어온 바이트가 저장
			// bytecount : 읽어온 바이트의 개수
			int bytecount = fin.read( inbytes );	// 스트림 : 바이트단위 // 2. 읽어온 바이트를 바이트배열 저장
			// 4. 바이트 배열 ---> 문자열
				// new String("유재석");
				// new String("바이트배열"); new String (바이트배열 , 시작인덱스 , 마지막인덱스);
			String fStr = new String(inbytes , 0 , bytecount ); // 3. 바이트배열 --> 문자열 변환
			/*
				fStr = 안녕하슈,자바글쓰기,김동혁,1234,
			*/
			//* 행 기준 자르기
			String[] boards = fStr.split("\n");	// 행 기준을 분리 [ 만약에 게시물 2개일때는 3조각인데 마지막 인덱스 사용안함 ]
				
			System.out.println("----------------게시물 목록 ------------");
			System.out.printf("%2s %10s%5s\n" , "번호" , "제목" , "작성자" );
			//* [행마다] 열 기준 자르기 
			for(int i = 0 ; i<boards.length ; i++) {
				// * [게시물 마다 열 자르기]
				String[] cols  = boards[i].split(","); // 4조각
				String title = cols[0];		String content= cols[1];
				String writer = cols[2];	String password = cols[3];
				System.out.printf(" %2d %10s%5s\n" , i , title , writer );
 			}
			
			System.out.println("메뉴> 게시물 상세보기[번호] 쓰기[-1]   나가기[-2] ");
			int ch = scanner.nextInt();
			if(ch == -1) {
		// 1. 각 변수별로 입력받아 저장
				System.out.println(" 제목 : "); String title = scanner.next();
				System.out.println(" 내용 : "); String content = scanner.next();
				System.out.println(" 작성자 : "); String writer = scanner.next();
				System.out.println(" 비밀번호 : "); String password = scanner.next();
				
				// , : 열 구분선[데이터구분]		\n : 행 구분선[게시물 구분] 
				String outStr = title+","+content+","+writer+","+password+","+"\n";
				
				// 1. 파일처리 객체 생성 ("파일경로" , true ); --> 처음에는 true 넣으면 파일이 없는 상태라서 안댐
				FileOutputStream fout = new FileOutputStream("c:/java/board.txt",true);
				fout.write(outStr.getBytes());	// 스트림 : 바이트단위
			}
			else if(ch == -2) {break;}
		}	// while e
	}// m e
}// c e
