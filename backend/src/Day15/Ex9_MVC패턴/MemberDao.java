package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDao {

	// *싱글톤 : DAO 싱글톤 사용하는 이유 : 프로그램 DB 연동 1번만 해서 하나의 연동 객체 사용
		// 1. 내부에 객체 만들기
	private static MemberDao dao = new MemberDao();
		// 2. 생성자는 private -> 외부에서 new 사용금지
		// 3. 외부에서 내부객체 사용할 수 있게 내부객체 반환 메소드 [ getInstance ]
	public static MemberDao getInstance() {return dao;}
	
	// 1. 필드
	private Connection conn;		// 1. 연결된 DB구현객체를 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [+매개변수도 가능] 인터페이스
	private ResultSet rs;			// 3. 실행된 SQL 결과 인터페이스
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동될 수 있게 하려고 ]
	private MemberDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15" , "root" , "1234");
		} catch (Exception e) { System.out.println(e.getMessage() );}
	}
	
	// 3. SQL 처리 메소드
	// 1. 회원가입 메소드 [ 인수 : Dto( id,pw )  , 반환 : 성공[true],실패[false] ]
	public boolean signup( MemberDto dto ) {// 매개변수로 쓰이는 상태라서 자료형인 MemberDto가 앞에 꼭 붙어야댐
		// 1. SQL 작성한다.
		String sql = "insert into member (mid , mpw) values(?,?)";
		// 2. 연동 DB에 SQL 대입한다 . [ ps -> 매개변수 조작 가능 ]
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());	// SQL구문 내 첫번째 ?에 대한 데이터 대입
			ps.setString(2, dto.getMpw());	// SQL구문 내 두번째 ?에 대한 데이터 대입
			//4. ps가 sql 실행
			ps.executeUpdate();
			// 5. 결과 반환
			return true; // 여기까지 문제 없었으면 저장 성공
			
		}catch (Exception e) {System.out.println("DB오류 : " + e);	}
		return false;// try{ } 문제가 있으면 실행되는 구역 -> 저장실패
	}
	////////////////////////---------------------------------------////////////////////////////
	
	// 2. 모든 회원 출력 [ 인수 : X 		반환 : [배열 vs ArrayList ] 회원 = dto객체  ]
	public ArrayList<MemberDto> list() { 
		// *  여러명의 회원 Dto 객체를 저장하기 위한 리스트 선언		[ 버스 1대 선언 <회원> ]
		ArrayList<MemberDto> list = new ArrayList<>();
		// 1. SQL 작성
		String sql = "select * from member";
		// 2. 연결된 DB에 작성된 SQL 대입[*예외처리]
		try {
			ps=conn.prepareStatement(sql);
		// 3. SQL 조작[ 매개변수 없으면 패스~ ]
		
		// 4. SQL 실행[ SQL 결과를 rs 인터페이스에 저장 ]
			rs = ps.executeQuery();	// 결과 : 검색된 모든 레코드
		// 5. SQL 결과
			// 레코드 --자바형태--> 객체 DTO	// 레코드1개 -> DTO 1개 -> 회원 1개
			while(rs.next()) {	// 결과 : 다음 레코드 이동 [ 없으면 false ] // 마지막 레코드까지 무한반복
					//rs[null] --rs,next--> rs[1레코드] --rs,next--> rs[2레코드] --rs,next--> rs[3레코드] --rs,next--> X[false]
				
				// 레코드 1개 --> 객체화 1개 [ rs.get필드타입(필드순서번호) ]		레코드1개 ---> 회원 1명
				MemberDto dto = new MemberDto(rs.getInt(1),rs.getString(2),rs.getString(3) );
				System.out.println("회원 마다 : " + dto );
				// 1개 객체 --> 리스트 담기
				list.add(dto);										// 회원 1명 ---> 버스로 이동
			}
			System.out.println("회원 목록 : " + list.toString());
			return list;
			
		}catch (Exception e) { System.out.println("DB 오류 :" + e);}
		return null;	
	}// list end
	
	// 3. 비밀번호 수정
	//[인수 : 누구[식별 mno]의 비밀번호를 무엇으로[새로운 mpw] 바꿀건지 / 반환 : 성공[true] 실패[false] ]
	public boolean update( int mno , String mpw) {
		// 1. SQL 작성
		String sql = "update member set mpw = ? where mno = ?";
		// 2. 연결 DB에 SQL 대입
		try {
			ps = conn.prepareStatement(sql);
		// 3. SQL 조작
			ps.setString(1, mpw);	// 1은 첫번째 물음표라는 뜻
			ps.setInt(2, mno);		// 마찬가지로 2는 두번쨰 물음표
		// 4. SQL 실행
			ps.executeUpdate();	// insert , update , delete -> executeUpdate();		결과 1개
								// select -> ps.executeQuery();						결과 여러개
		// 5. SQL 결과
			return true;
		} catch (Exception e) {System.out.println("DB오류 : " + e);	}
		return false;
	}
	
	// 4. 회원 삭제 [ 인수 : 누구의 회원[mno]을 삭제할건지 / 반환 : 성공[true] 실패[false]  ]
	public boolean delete(int mno) {
		//1.
		String sql = "delete from member where mno = ?";
		try {	
			ps= conn.prepareStatement(sql);//2.
			ps.setInt(1, mno);//3.
			ps.executeUpdate();	// insert , update , delete	// select만 query 쓰면 댐 //4.
			return true;//5.
		}catch (Exception e) { System.out.println("DB오류 : " + e);}
		return false;
	}
	

}








