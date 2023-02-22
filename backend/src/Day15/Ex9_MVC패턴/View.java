package Day15.Ex9_MVC패턴;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	// 싱글톤
	private static View view = new View();
	private View() {}
	public static View getInstance() {return view;}
	
	// 필드
	Scanner scanner = new Scanner(System.in);
	// 1. 메인화면
	public void index() {
		while(true) {
			System.out.println("1.등록[C] 2.출력[R] 3.수정[U] 4.삭제[D] : ");
			int ch = scanner.nextInt();
			if(ch==1) { signup(); }
			else if(ch==2) { list(); }
			else if(ch==3) { update(); }
			else if(ch==4) { delete(); }
		}
	}// index end
	
	// 2. 회원가입 화면	---> 얘가 View(HTML 역할)
	public void signup() {
		System.out.println("--------- 등록[C] ---------");
		// 1. 데이터 2개 입력받기
		System.out.println("아이디 : ");		String mid = scanner.next();
		System.out.println("비밀번호 : ");		String mpw = scanner.next();
		// 2. 입력받은 데이터 2개 를 컨트롤에게 전달 후 결과 얻기
		boolean result=	Controller.getInstance().signup( mid , mpw );
		// 3. 결과에 따른 출력
		if(result == true) {System.out.println("[회원가입 성공]");}
		else{System.out.println("[회원가입 실패]");}
	}
	// 3. 회원목록 화면
	public void list() {		
		System.out.println("-------------------------------");
		System.out.printf("%2s \t %10s \t %10s \n" , "no" , "mid" , "mpw" );
		// 1. 컨트롤에게 모든[여러개-ArrayList]회원[MemberDto]들의 요청
		ArrayList<MemberDto> result = Controller.getInstance().list();
		
		for(int i = 0 ; i<result.size(); i++) {	// 0번 인덱스부터 마지막 인덱스까지 반복
			System.out.printf("%2d \t %10s \t %10s \n" ,
					result.get(i).getMno() , result.get(i).getMid() , result.get(i).getMpw());
		}
	}// list end
	// 3. 비밀번호 수정
	public void update() {
		System.out.println("-------------------------");
		System.out.println("회원번호 : ");			int mno = scanner.nextInt();
		System.out.println("새로운 비밀번호 : ");	String mpw = scanner.next();
		
		boolean result = Controller.getInstance().update(mno, mpw);
		if(result) {System.out.println("[알림] 수정 성공");}
		else {System.out.println("[알림] 수정 실패 - 관리자에게 문의");}
	}// update end
	
	// 4. 회원삭제
	public void delete() {
		System.out.println("---------------------");
		System.out.println("삭제할 회원번호 : ");
		int mno = scanner.nextInt();
		
		boolean result=
		Controller.getInstance().delete(mno);
		if(result) {System.out.println("[탈퇴성공]");}
		else {System.out.println("[탈퇴 실패]");}
		}
	}
	

