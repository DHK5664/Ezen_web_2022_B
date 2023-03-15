package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiledownLoad
 */
@WebServlet("/filedownload")
public class FiledownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiledownLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 다운로드 할 파일명 요청
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
			System.out.println("bfile:" + bfile);
		// 2. 파일 다운로드
			// 1. 다운로드할 파일의 경로 찾기
		//String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		//	System.out.println("path : " + path);
			// 2. 다운로드할 [폴더/파일명]의 파일 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			System.out.println("path : " + path);
			// 3. 파일 클래스 [해당 경로의 파일을 객체화]
		File file = new File(path);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
