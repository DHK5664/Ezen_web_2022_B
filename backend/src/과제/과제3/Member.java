package 과제.과제3;

import java.util.ArrayList;

public class Member {
	// 1. 필드	[ 기본자료형(boolean , int , float 등등) , 참조자료형( 클래스 ) ]
	String id;
	String password;
	String name;
	String phone;
	ArrayList<Book> rentList = new ArrayList<>();	// 미리 메모리 할당 해놔서 상황에 따라 생기고 줄고 그럼
}
