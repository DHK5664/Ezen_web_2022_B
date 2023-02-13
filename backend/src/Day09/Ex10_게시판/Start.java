package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
	Ex10_게시판 패키지
		controller 패키지
			Bcontroller.java
		model 패키지
			Board.java
		view 패키지
			Front.java
		Start.java
	- 1. start[main함수] 클래스가 front 클래스 호출
	- 2. front 클래스에서 사용자로 부터 입·출력 받기
	- 3. Bcontroller 클래스에서 front로 부터 전달받은 데이터를 처리/로직
	- 4. Board 클래스에서 게시물의 모델링	
		
*/


public class Start { // c s
	public static void main(String[] args) {// m s

		Front.getInstance().index();
		
	}// m e
}// c e
