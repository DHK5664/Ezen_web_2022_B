package Day19.Ex5;

import java.util.Scanner;

public class 실행 { // c s
	public static void main(String[] args) { // m s
		
		Scanner scanner = new Scanner(System.in);
		
		Music music = new Music();	// 음악스레드
		Movie movie = new Movie();	// 영화스레드
		
		while(true) {
			System.out.print("1.음악재생/중지 2.영화재생/중지 : ");
			int ch = scanner.nextInt();
			// 만약에 1번 입력하면서 음악재생 꺼져있으면 켜기
			if(ch==1 && music.stop == false ) {
				music.start();		// 음악스레드 시작
				music.stop = true;	// 음악재생여부 true;
			// 만약에 1번 입력하면서 음악재생 켜져있으면 중지
			}else if (ch== 1 && music.stop == true) {
				music.stop = false; 	// 음악재생 여부 false ;
				music = new Music();	// 추후 음악스레드 초기화
				
			// 만약에 2번 입력하면서 영화재생 꺼져있으면 켜기	
			}else if(ch==2 && movie.stop == false) {
				movie.start();
				movie.stop = true;
			// 만약에 2번 입력하면서 영화재생 켜져있으면 중지	
			}else if(ch == 2 && movie.stop == true) {
				movie.stop = false;
				movie= new Movie();
			}
		}
		
	}// m e	
}// c e
