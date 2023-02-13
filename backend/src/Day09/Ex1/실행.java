package Day09.Ex1;

public class 실행 { // c s
	public static void main(String[] args) { // m s
		
		// 1. 객체 만들기
		Member member = new Member();
			// 2. 멤버인 필드 호출 가능
		System.out.println(member.name);
			// 3. 멤버안에 있는 변수 호출 불가능
		System.out.println(member.inputName);
	}// m e
}// c e
