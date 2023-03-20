package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 
		int bno = Integer.parseInt(	request.getParameter("bno")	);		System.out.println("bno : " +bno);
		int type = Integer.parseInt(request.getParameter("type"));		System.out.println("type : " +type);
		int rindex = 0;
		
		if(type == 1) {// 상위댓글 출력
			
		}else if(type == 2) {// 하위댓글 출력
			rindex = Integer.parseInt(request.getParameter("rindex"));	System.out.println("rindex : " +rindex);
		}
		
		// 2. 
		ArrayList<ReplyDto> result = BoardDao.getInstance().getReplyList(bno,rindex);
		// 3. 
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		// 4.
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		String rcontent = request.getParameter("rcontent");
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		ReplyDto dto = new ReplyDto(rcontent, mno, bno);
		if(type == 1) { // 상위 댓글
		}else if (type == 2) { // 하위 댓글
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto = new ReplyDto(rcontent, mno, bno);
			dto.setRindex(rindex);
		}
		
		// 2. 
			System.out.println("dto : " + dto);
		
		// 3.
		boolean result = BoardDao.getInstance().rwrite(dto);
		// 4. 
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
