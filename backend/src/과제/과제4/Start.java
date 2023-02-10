package 과제.과제4;
// 굳이 나눠서 하는 이유는 규모가 커졌을때 업무분담을위해 + 보기 편하게 만드려고
import 과제.과제4.view.Front;

/*
	MVC : 디자인패턴 [ 관점별 파일 구분 ]
		M : model			데이터			DB
		V : view			화면				HTML / CSS / JS
		C : controller		제어[로직/기능처리]	JAVA
*/

public class Start {// c s
	public static void main(String[] args) {// m s
		Front front = new Front();
		front.index();
	}// m e
}// c e
