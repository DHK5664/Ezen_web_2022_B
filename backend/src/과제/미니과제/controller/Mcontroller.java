package 과제.미니과제.controller;

import java.util.ArrayList;

import 과제.미니과제.model.Member;
import 과제.미니과제.model.Memo;

/*
-------Mcontroller
   - 회원가입
      인수: id , pw , confirmpwd,name,phone         반환 : true / false
   - 로그인
      인수: id, pw               반환 : 성공,실패
   - 마이페이지
      인수: X                  반환 : 현재 로그인 된 사람에게 온 쪽지ArrayList , 현재 로그인 된 사람이 보낸 쪽지ArrayList 
*/
public class Mcontroller {

	// * 싱글톤
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller() {}
	public static Mcontroller getInstance() {
		return mc;
	}
	
	// DB 대신 ArrayList
	private ArrayList<Member> MemberDB= new ArrayList<>();
	
	public Member getLogSession() {
		return logSession;
	}
	
	private Member logSession = null;
	
	// 1. 회원가입
	public boolean signup(String id , String pw , String confirmpw , String name , String phone) {
		// 1. 유효성검사
		if(!pw.equals(confirmpw)) {return false;}
		// 2. DB저장
			// 객체화
		Member m = new Member(id, confirmpw, name, phone, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		// ArrayList 각각 Product , Memo1 , Memo2!!
			MemberDB.add(m);
		return true;
	}
	// 2. 로그인
	public boolean login (String id , String pw) {
		for(Member m : MemberDB) {
			if( m.getId().equals(id)&& m.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
}
