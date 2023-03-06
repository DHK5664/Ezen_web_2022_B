package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getInstance() {return productDao; }
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb" , "root" , "1234");
		}catch (Exception e) {System.out.println(e);}
	}
	// 1. 등록 [ 인수 : 입력받은 값 / 반환 : 성공여부 ]
	public boolean onregi( ProductDto productDto) {
		String sql ="insert into qproduct(pname , pprice) values(? , ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, productDto.getPname());
			ps.setInt(2, productDto.getPprice());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	} // 등록 end
	
	// 2. 제품출력 [ 인수 : X / 반환 여러개[list]의 dto ]
	public ArrayList<ProductDto> onplist (){
		ArrayList<ProductDto> plist = new ArrayList<>();
		String sql = "select * from qproduct";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				plist.add(productDto);
			}// while end
		}catch (Exception e) {System.out.println(e);}
		return plist;
	}
	
	// 3.  삭제 [ 인수 : 제품번호 / 반환 성공여부]
	public boolean pdelete(int pno) {
		String sql = "delete from qproduct where pno = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	public boolean pupdate(int pno , String newpname , int newpprice) {
		String sql = "update qproduct set pname =? , pprice = ? where pno = ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newpname);
			ps.setInt(2, newpprice);
			ps.setInt(3, pno);
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}















