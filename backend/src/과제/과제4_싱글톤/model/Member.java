package 과제.과제4_싱글톤.model;

import java.util.ArrayList;
///*	여쭤볼 것 : ArrayList<Board> boardlist의 자료형은 그럼 리스트 객체인것인가? 그렇다구 한다ㅇㅇ
// M : 데이터를 저장할때 사용되는 데이터 모델링
	// - 회원[객체] 여러명 만들어서 하나의 리스트에 저장
	// - 필드 : private : 관례적으로 얘를 씀 ( 외부 직접 접근 방지 -> getter , setter )
	// - 생성자 : (1. 빈생성자 , 2. 풀생성자) : 안쓰더라도 관례적으로 무조건 만듦
	// - 메소드 : 1. .toString() 2. getter , setter
public class Member {

	// 인스턴스멤버 : 객체 있어야 사용 -> 스택영역
	// 정적멤버 : static 객체없이 사용 -> 메소드영역
	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	// 한 명의 회원[객체]가 여러개의 board객체를 가질 수 있다.
	private ArrayList<Board> boardlist = new ArrayList<>();
	// 2. 생성자
	
	public Member() {}
	
	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardlist) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardlist = boardlist;
	}
	// 3. 메소드

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", boardlist=" + boardlist
				+ "]";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Board> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<Board> boardlist) {
		this.boardlist = boardlist;
	}
	
}
