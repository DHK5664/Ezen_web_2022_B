package practice.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Q2Dao {

	private static Q2Dao q2Dao = new Q2Dao();
	public static Q2Dao getInstance() {return q2Dao;}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Q2Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
		}catch (Exception e) {System.out.println(e);}
		
	}
	
	public boolean QSetData(Q2Dto q2Dto) {
		String sql = "insert into Q2 values(?,?,?,?,?,?,?,?,?)";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, q2Dto.getQdata1());		ps.setString(2, q2Dto.getQdata2());
			ps.setDouble(3, q2Dto.getQdata3());		ps.setInt(4, q2Dto.getQdata4());
			ps.setString(5, q2Dto.getQdata5());		ps.setString(6, q2Dto.getQdata6());
			ps.setBoolean(7, q2Dto.getQdata7());	ps.setString(8, q2Dto.getQdata8());
			ps.setString(9, q2Dto.getQdata9());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	public ArrayList<Q2Dto> QGetData(){
		ArrayList<Q2Dto> Qlist = new ArrayList<>();
		String sql = "select * from Q2";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Q2Dto q2Dto = new Q2Dto(rs.getString(1), rs.getString(2), rs.getDouble(3),
						rs.getInt(4), rs.getString(5), rs.getString(6),
						rs.getBoolean(7), rs.getString(8) , rs.getString(9));
				Qlist.add(q2Dto);
			}
		}catch (Exception e) {System.out.println(e);}
		return Qlist;
	}
	
}
