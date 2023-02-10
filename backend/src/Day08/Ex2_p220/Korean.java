package Day08.Ex2_p220;

public class Korean {
	// 1. 필드
	String nation = "대한민국";
	String name ;
	String ssn ;
	// 2. 생성자
		// 1. 빈 생성자 // 걍 관례적으로 이유없이 만듦
	public Korean() {}
	
	public Korean(String name , String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	// 3. 메소드
	
	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	

	
}

/*
 window -> preference -> General -> Appearence -> Color and Fonts로 폰트랑 색깔 등 바꿀 수 있음
 
 */































