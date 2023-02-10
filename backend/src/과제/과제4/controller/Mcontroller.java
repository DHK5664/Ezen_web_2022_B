package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;
// public : 전체범위 느낌 그래서 다른 패키지에서 가져다 쓸 수 있게 함

// * 처리/제어 담당	// 절대 프린트 , 스캐너 사용 불가
public class Mcontroller { // c s
	// * DB 대신할 [ 데이터 저장소 (리스트) ]
	ArrayList<Member> memberDb = new ArrayList<>();
	// 1. 회원가입 로직
	public int signup(String id , String pwd , String confirmpwd , String name , String phone) {
		// 1. 유효성검사
		if( !pwd.equals(confirmpwd)){ return 1;}	// 회원가입 실패 1
		// 2. 객체 만들어서
		Member member = new Member(id, confirmpwd, name, phone);
		// 3. db처리 [ 리스트 ]
		memberDb.add(member);
		return 0;	// 회원가입 성공 0
	}
	// 2. 로그인 로직
	public int login( String id , String pwd ) {
		// * 모든 멤버들 중 동일한 아이디/비밀번호 찾기
		for(int i = 0 ; i<memberDb.size(); i++) {
			// 1. 만약에 i번째 회원의 아이디와 입력받은 아이디와 같으면
			if((memberDb.get(i).id.equals(id) ) ) {
			 // 2. 만약에 i번째 회원의 비밀번호와 입력받은 비밀번호가 같으면
				if(memberDb.get(i).pwd.equals(pwd) ) {
					return i; // 회원번호 인덱스 반환
				}else {
					return -1; //비밀번호 틀림
				}
			}// if 끝
		}// for 끝
		return -2 ; // 아이디가 없음 for문 안에 넣으면 처음 인덱스와 비교할때 아이디가 다르면 바로 -2로 나와버려서 여기에 둠
	}
	// 3. 아이디 찾기 로직
	public String findId(String name , String phone) {
		for(int i = 0 ; i<memberDb.size(); i++) {
			// 1. 만약에 i번째 회원의 이름과 입력받은 이름이 같으면
			if(memberDb.get(i).name.equals(name) ) {
			// 2. 만약 i번째 회원의 전화번호와 입력받은 전화번호가 같으면
				if(memberDb.get(i).phone.equals(phone) ) {
					return memberDb.get(i).id;	// i번째 데이터베이스 리스트 속 id 반환
				}
			}
		}
		return null; // 없는 회원
	}
	
	// 4. 비밀번호 찾기 로직
	public String findPassword(String id , String name , String phone) {
		for(int i = 0 ; i<memberDb.size(); i++) { 
			// 데이터베이스 전체 돌려서 입력받은 값과 같은 값 가진 객체 찾아보기
			if(memberDb.get(i).id.equals(id)) { // 만약 i번째 객체의 id와 입력받은 id가 같으면
				if(memberDb.get(i).name.equals(name)) {// 만약 i번째 객체의 name과 입력받은 name이 같으면
					if(memberDb.get(i).phone.equals(phone)) {// 만약 i번째 객체의 전번과 입력받은 전번이 같으면
						return memberDb.get(i).pwd; // i번째 데이터베이스 리스트 속 pwd 반환
					}// if3 end
				}// if2 end
			}// if1 end
		}// for end
		return null;	// 그런거 없다.
	}
	
}// c e


// 향상된 for(타입 반복변수명 : 리스트/배열){ }