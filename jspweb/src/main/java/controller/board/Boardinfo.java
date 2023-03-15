package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class Boardinfo
 */
@WebServlet("/board/info")	// !: 프로젝트 내 동일한 서블릿주소 있을경우 서버자체가 안켜짐
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Boardinfo() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드
		// 1. 업로드할 파일의 저장 위치 [경로]
			// 클라이언트[유저] ----- x ----> git[내프로젝트]
			//			  ----- o ----> 서버[배포된프로젝트]
		// 2. 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("path : " + path);
		// 3. 파일 복사 [ 대용량 바이트 복사하기 ]
		MultipartRequest multi = new MultipartRequest(
				request ,	path ,	1024*1024*10 ,	"UTF-8" ,
				new DefaultFileRenamePolicy() );
			System.out.println("multi : " + multi);
			
		// --------- 확인 ---------
			// request.getParameter("객체명의 필드명")
			// multi.getParameter("form 하위 태그의 name명")
		int cno = Integer.parseInt(multi.getParameter("cno"));			System.out.println("cno:" + cno);
		String btitle = multi.getParameter("btitle");		System.out.println("btitle:" + btitle);
		String bcontent = multi.getParameter("bcontent");	System.out.println("bcontent:" + bcontent);
		String bfile = multi.getFilesystemName("bfile");		System.out.println("bfile:" + bfile);
						// getFilesystemName : input 실제 파일이름
		//	--------- 확인 ---------
			// 1. 회원제게시판 [ 로그인된 회원의 mno 필요! ]
			String mid = (String)request.getSession().getAttribute("login");
			// 2. mid ---> mno (Dao)
			int mno = MemberDao.getInstance().getMno(mid);
			// 3. 만약에 회원번호가 존재하지 않으면 글쓰기 불가능
			if(mno<1) {response.getWriter().print("false");}
			
		// Dto
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
			System.out.println("dto : " + dto);
			
		// DAO
		boolean result = BoardDao.getInstance().bwrite(dto);
		
		// 응답
		response.getWriter().print(result);
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
