package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Member;

// * 1개만 있어도 되는지 생각

public class Mcontroller {
	// 여쭤볼 것 로그인 한 흔적을 남겨야 하는 이유? : 함수가 끝나면 모든 기록은 날아가서 이를 저장해서 다른 곳에서도 사용하기 위함
	
	// * 싱글톤 : 다른곳에서 해당 객체를 공유 메모리[멤버=필드 , 메소드]
		// 1. 본인 클래스로 본인 객체 만들기
	private static Mcontroller mc = new Mcontroller();
		// 2. 외부에서 생성자 사용 못하게 생성자에 private
	private Mcontroller() {}
		// 3. 객체는 외부로부터 차단하고 getInstance 함수를 통해 객체를 내보낸다. [ 유효성검사 위해 ]
	public static Mcontroller getInstance() {
		return mc;
	}
		// 4. 외부에서 getInstance 함수를 사용하려면 객체가 필요한데 외부에서 객체 못만듦 고로 정적멤버 쓰자
	
	// DB 대신 ArrayList
	private ArrayList<Member> memberDB= new ArrayList<>();
	
	public Member getLogSession() {
		return logSession;
	}

	// 로그인 한 회원의 객체를 저장 [ *동시접속 문제점 발생!! ]
		// 사용목적 : 페이지가 바뀌더라도 정보 저장 [ *메소드가 종료 되더라도 정보는 저장 ]
	private Member logSession = null;

	// 1. 회원가입 처리
	public int signup(String id , String pw , 
				String confirmpw ,String name , 
				String phone) {
		// 1. 유효성검사	// 앵간하면 스크립트에서 다 하고 들어오긴함
		if(!pw.equals(confirmpw)) {return 1;}
		// 2. DB에 저장
			// 1. 객체화 [ 입력받은 데이터 4개와 , 회원마다 글을 저장할 리스트 메모리 초기화 ] 
		Member m = new Member( id , pw , name , phone , new ArrayList<>() );
				//  new ArrayList<>()를 인수로 받아 실행때마다 리스트 생성
				// id , pw , name , phone : 스택영역에 저장된 힙주소 전달
				// new ArrayList<>() : 힙영역에 생성된 힙주소 전달
			// 2.리스트에 저장
			memberDB.add(m);
		return 0;
	}
	// 2. 로그인 처리
	public int login (String id , String pw) {
		
		for(int i = 0 ; i<memberDB.size(); i++) {
			if(memberDB.get(i).getId().equals(id) ) {//i번째 인덱스의 아이디와 입력받은 아이디 같으면
				if(memberDB.get(i).getPw().equals(pw)){
					//i번째 인덱스의 패스워드와 입력받은 패스워드 같으면 로그인 성공	[ !로그인 성공했어 흔적/식별 ] 
					logSession = memberDB.get(i);	// 로그인 성공한 회원객체를 필드에 저장( 해당함수는 지역변수라서 끝나면 지워지므로 필드에 저장)
					return i;
				}else {
					return -1;
				}
			}
		}
		
		return -2;
	} // end
	// 3. 아이디 찾기 처리
	public String findId(String name , String phone) {
		for(Member m : memberDB ) { // memberDB 여러개의 member객체가 들어있고 하나씩 member 객체를 꺼내기 반복
			if(m.getName().equals(name) && m.getPhone().equals(phone)) {
				return m.getId();	// 위 조건이 일치할 경우 찾은 아이디 반환
			}
		}
		return null;
	}// end
	// 4. 비밀번호찾기 처리
	public String findPw(String id , String phone) {
		for(Member m : memberDB) {
			if(m.getId().equals(id) && m.getPhone().equals(phone)) {
				return m.getPw();
			}
		}
		return null;
	}// end
	// 5. 로그아웃
	public boolean logOut() {
		logSession = null;	// 필드에 저장된 로그인 성공한 회원 객체를 지우기 [ null 대입하면 GC가 힙 메모리 자동제거 ]
		return true;
	}
}
/*
1. 회원가입 처리
	인수 : id ,pw , confirmpw , name , phone	반환 : 0:성공 1:패스워드실패

2. 로그인 처리
	인수 : id,pw				반환 : i:회원번호 , -1:비밀번호틀림 , -2:아이디가 업슴

3. 아이디찾기 처리
	인수 : name, phone				반환 : 찾은 아이디,null

4. 비밀번호 찾기 처리
	인수 : id , phone				반환 : 찾은 비밀번호, null
	
10. 로그아웃
	인수 : X						반환 : true 성공 false 실패

*/
