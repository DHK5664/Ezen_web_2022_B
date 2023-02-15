package 과제.과제7.model;

public class Account {
/*
1. [상위클래스] 계좌 클래스를 만든다.
		필드 : 계좌번호[ 은행코드-난수2자리-난수2자리 ] , 계좌비밀번호[4자리] , 계좌주 , 잔금 [초기 0원 ]
		메소드 : 
			계좌생성()	: 
				1. 3개 은행중 선택를 받는다. 선택한 은행으로 계좌를 생성한다.
				2. 비밀번호와 계좌주 입력받고 계좌번호는 자동생성 , 예금액은 0 으로 계좌를 생성한다.
			예금() : 해당 계좌번호와 예금액을 입력받아 해당 계좌번호에 금액을 더해준다.
*/
	String account;
	String password;
	String name;
	String money;
	
	public Account() {}
	
}
