package Day15.Ex2_p500;

public class 실행 {
	public static void main(String[] args) {
		
		System.out.println("홍길동".hashCode());
		System.out.println("홍길동".hashCode());	// 얘네는 같은데 "" 즉 리터럴 쓰는애들끼리 문자열 생긴게 같으면 리터럴문자열의 주소값은 같음
		System.out.println("홍길동".hashCode() == "홍길동".hashCode());
		
		Student s1 = new Student(1, "홍길동");
			System.out.println(s1);
		Student s2 = new Student(1, "홍길동");
			System.out.println(s2);
			
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());	// 얘네는 다름
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.equals(s2) );
	}
}
