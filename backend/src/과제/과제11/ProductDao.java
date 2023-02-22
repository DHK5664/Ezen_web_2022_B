package 과제.과제11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProductDao {

	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static ProductDao dao = new ProductDao();
	private ProductDao() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/과제11" , "root" , "1234");
		} catch (Exception e) {System.out.println( e );	}
	}
	public static ProductDao getInstance() {return dao;}
	
	// 1. 제품등록 [ 인수 : Dto(이름,가격,초기재고) / 반환 : true,false ]
	public boolean regist(ProductDto dto) {
		
		String sql = "insert into product (pname , pprice , pstock) values(? , ? , ?);";// 1. SQL작성
		
		try {
				ps=conn.prepareStatement(sql);		// 2. 연동DB에 SQL 대입					2시~3시 수업 중 확인해보자
				ps.setString(1, dto.getPname());	// 3.SQL 조작 [? 매개변수에 데이터 대입 ]
				ps.setInt(2, dto.getPprice());		// ps.set타입명(?순서번호 , 데이터)
				ps.setInt(3, dto.getPstock());
				ps.executeUpdate();					// 4. SQL실행
				return true;						// 5. SQL결과
			}catch(Exception e) {System.out.println(e);
			return false;
			}
	}
	// 2. 모든 제품 출력 [ 인수 : X / 반환 : 여러개[배열 , 리스트 그래서 리스트]제품[dto]
	public ArrayList<ProductDto> getProductAll(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	// SQL결과를 rs인터페이스로 반환
			while( rs.next() ) {	// 결과에서 레코드 하나씩 반복 rs.next() : 다음 레코드
				// 레코드 1개 --> 객체1개 [필드 호출 rs.get타입(필드순서 번호)]
				ProductDto dto = new ProductDto (rs.getInt(1) , rs.getString(2) , rs.getInt(3) , rs.getInt(4) );
				list.add(dto);
				
			}
			return list;
		} catch (Exception e) {System.out.println(e);	}
		return null;
	}
	// 3. 수정 구현 [ 인수 : 제품명 , 가격 / 반환 : 성공[true] 실패[false] ]
	public boolean updateProduct(int pno , String pname , int pprice) {

		String sql = "update product set pname =? , pprice=? where pno = ?";	// 1. SQL 작성
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2,pprice );
			ps.setInt(3, pno);
			
			ps.executeUpdate();
			
			return true;
		}catch (Exception e) {System.out.println("DB오류 : " + e);}
		return false;
	}
	// 4. 재고수정 구현 [ 인수 : 재고수량 / 반환 성공[true] 실패[false] ]
	public boolean updateStock(int pno , int pstock) {
		
		String sql = "update product set pstock =?  where pno =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pstock);
			ps.setInt(2, pno);
			
			ps.executeUpdate();		// executeUpdate는 틀린값이 나와도 무조건 true처리됨
			return true;
		} catch (SQLException e) {System.out.println("DB오류 : " + e);	}
		return false;
	}
	// 5. 물건삭제 구현	[인수 : 삭제할 제품번호 / 반환 성공[true] 실패[false]]
	public boolean delete(int pno) {
		String sql = "delete from product where pno = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("DB오류 : " + e);}
		return false;
	}
}











