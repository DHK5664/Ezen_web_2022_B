package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3") // <-- 해당 클래스[자원] URL 정의
public class Ex3 extends HttpServlet { // <-- HttpServlet 클래스에게 상속 받음 
	private static final long serialVersionUID = 1L;
       
    public Ex3() {
        super();
    }
    
	// 1. POST 메소드	// C
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 메소드에서 통신 받았소.");
	}
	// 2. GET 메소드	// R
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("GET 메소드에서 통신 받았소.");
		}
	// 3. PUT 메소드	// U
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PUT 메소드에서 통신 받았소.");
	}
	// 4. DELETE 메소드	// D
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE 메소드에서 통신 받았소.");
	}

}
