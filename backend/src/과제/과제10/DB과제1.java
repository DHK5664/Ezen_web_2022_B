package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		
		while(true) {
			try {
				System.out.println("1.DB연결 2.SQL구문작성 3.매개변수 입력");
				int ch = scanner.nextInt();
				if(ch==1) {
					System.out.println("연동할 DB이름 입력 : ");
					String dbname = scanner.next();
					System.out.println(dbname+"에 연결합니다.");
					
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/"+dbname, "root" , "1234");
					
					System.out.println(dbname +"연결 성공");
				}
				
				else if(ch==2) {
					System.out.println("-- SQL 구문 입력 : ");
					scanner.nextLine();
					String sql = scanner.nextLine();
					PreparedStatement ps = con.prepareStatement(sql);
					ps.execute();
				}
				else if(ch==3) {
					System.out.println("제품번호 : ");		int pno = scanner.nextInt();
					System.out.println("제품명 : ");		String pname = scanner.next();
					scanner.nextLine();
					System.out.println("제품설명 : ");		String pexplain = scanner.nextLine();
					System.out.println("제품가격 : ");		int pprice = scanner.nextInt();
					
					String sql = "insert into product values( ? , ? , ? , ?);";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, pno);
					ps.setString(2, pname);
					ps.setString(3, pexplain);
					ps.setInt(4, pprice);
					ps.executeUpdate();
				}
				
			}catch (InputMismatchException e) {
				System.out.println("[알수없는 입력 입니다.]");
				scanner = new Scanner(System.in);
			}catch (SQLException e) {
				System.out.println("[SQL 오류] : " + e);
			}catch (Exception e) {
				System.out.println("[DB 연결 후 다시 실행]");
			}
		}
	}
}
