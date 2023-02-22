package Day15.Ex9_MVC패턴;

public class Start {
	
	public static void main(String[] args) {
		
		View.getInstance().index();
		
	}
}
/*

	내부에서 메소드[멤버] 호출 방법	[ 메모리 할당 전 ]
		메소드명();
	외부에서 메소드[멤버] 호출 방법	[ 메모리 할당 ]
		1. 인스턴스 메소드	[ new -> 힙 ]
			클래스명 객체명 = new 생성자();
			객체명.메소드명();	-- 변수명이 존재하기 떄문에 재호출 가능
			
				ex)View view = new View();
					view.index();
					
		2. 정적[static] 메소드
			클래스명.메소드명();
			
				ex)View.index();
				
		3. 싱글톤 내 메소드 호출		[ new -> 힙 ]	: 안에서 new를하고 밖에서 막으면 싱글톤!
			클래스명.get싱글톤.메소드();
			
				ex)View.getInstance().index();
				
		*추가 
			new 생성자().메소드명();	[ new -> 힙 ]	: 얘는 단순 호출용도이면 일케 써도 됨
													-- 저장하는 변수명 없어서 일회용
				ex)new View().index();			
				
			JVM
				
				[ 현재 사용중인 메모리 : 컴파일한 파일과 + import ]
				
		메소드 영역					스택 영역					힙 영역
			- 전역에서 사용				- 기본자료형 데이터
									- 힙주소 저장
			: 클래스 멤버정보				클래스명 객체명  =	new 생성자();
			: static 멤버정보							    new 생성자().메소드명();
				- 정적 메소드
			public static void index()
				- 정적 필드
			static 타입 필드명
			static View view						=	new View();
				
			즉 메소드는 힙에 있음
				
				
*/
