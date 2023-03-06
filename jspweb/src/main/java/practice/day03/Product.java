package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Product() {
        super();
    }
    // 1. 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String pname = request.getParameter("pname");	System.out.println("pname : " + pname);
    	int pprice = Integer.parseInt(request.getParameter("pprice")); System.out.println("pprice : " + pprice);
    	ProductDto productDto = new ProductDto(0, pname, pprice);
    	boolean result = ProductDao.getInstance().onregi(productDto);
    	response.getWriter().print(result);
	}
    // 2. 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 응답 매개변수 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 2. DAO 호출해서 모든 게시물 반환 후 저장
		ArrayList<ProductDto> result = ProductDao.getInstance().onplist(); System.out.println("PRODUCT DAO LIST : " + result);
		// 3. JSON[JS객체] 형식의 문자열로 변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
			System.out.println("jsonArray : " + jsonArray);
		// 4. 응답
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	// 3. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 응답 매개변수 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt(request.getParameter("pno"));	System.out.println("pno : " +pno);
		boolean result = ProductDao.getInstance().pdelete(pno);
		response.getWriter().print(result);
	}
	// 4. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt(request.getParameter("pno"));	System.out.println("pno : " + pno);
		String newpname = request.getParameter("newpname");	System.out.println("수정할이름요청 : " +newpname);
		int newpprice = Integer.parseInt(request.getParameter("newpprice"));	System.out.println("수정할 가격 요청 : " +newpprice);
		boolean result = ProductDao.getInstance().pupdate(pno, newpname, newpprice);
		response.getWriter().print(result);
	}

	
}
