package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;

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
		
		int type = Integer.parseInt(request.getParameter("type"));
		if(type ==1) { // 전체 출력
			
			// ----------------- 카테고리 별 출력 ----------------- //
			// 1. 카테고리 매개변수 요청 [cno]	2.gettotalsize/getBoardList 조건 전달 
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			// ------------------ 검색 처리 --------------------- //
			// 1. 검색에 필요한 매개변수 요청 [ key , keyword ]	/ 2.gettotalsize/getBoardList 조건 전달
			String key = request.getParameter("key");			System.out.println("key :" +key);
			String keyword = request.getParameter("keyword");	System.out.println("keyword : " +keyword);
			
			// ------------------ page 처리 코드 ------------------ //
			// 1.현재페이지[요청된 것] , 2.페이지당 표시할게시물수(페이지당 3개) , 3.현재페이지[게시물시작번호 , 게시물끝번호]
			int page = Integer.parseInt(request.getParameter("page"));
			// int listsize = 3;
			int listsize = Integer.parseInt(request.getParameter("listsize"));	// 화면에 표시할 게시물 수 요청
			int startrow = (page-1)*listsize;//해당 페이지에서의 게시물의 시작번호
			// ------------------- page 버튼 만들기 --------------------- //
			// 1. 전체페이지수[ 총게시물레코드수/페이지당 표시수 ] 2. 페이지 표시할 최대버튼수 3. 시작버튼 번호
				// 1. 검색 업슬때
			//int totalsize = BoardDao.getInstance().gettotalsize();
				// 2. 검색 있을때
			int totalsize = BoardDao.getInstance().gettotalsize( key , keyword  , cno);
			int totalpage = totalsize % listsize == 0 ?					// 만약 나머지가 0이라믄 몫을 쓰고
							totalsize/listsize : totalsize/listsize+1; 	// 나머지가 있으믄 +1 해줌
			int btnsize = 5; // 최대 페이징버튼 출력수
			int startbtn = ( (page-1) / btnsize ) * btnsize +1 ;
			int endbtn = startbtn + (btnsize-1);
			// *단 마지막버튼수가 총 페이지수 보다 커지면
			if( endbtn > totalpage ) endbtn = totalpage;
				// 검색 없을때
			//ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList(startrow,listsize);
			ArrayList<BoardDto> result
				= BoardDao.getInstance().getBoardList(startrow,listsize , key , keyword , cno);
			
			// page Dto 만들기
			PageDto pageDto
			= new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
			
			
			// java 형식 ---> js 형식
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(pageDto);
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}else if(type==2) { // 2. 개별출력
			int bno = Integer.parseInt(request.getParameter("bno"));	System.out.println("bno : " + bno);
			// Dao 처리
			BoardDto result = BoardDao.getInstance().getBoard(bno);
			// 형변환 처리
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			// 응답 처리
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(json);
		}
		
		
	}
			/*
		 	총 게시물수 = 10	, 페이지당 표시할 게시물수 = 3
		 	총 레코드수 = 10	총 레코드의 인덱스 : 0~9
		 	1. 총페이지수 = 012 , 345 , 678 , 9 --> 4 //(즉 10/3인데 나머지가 있으면 +1 이됨)
		 			
		 			총 레코드수/페이지당 표시 게시물 수
		 				1. 나머지가 없으면 => 몫			9/3	-> 3페이지
		 				2. 나머지가 있으면 => 몫 + 1		10/3 -> 4페이지
		 				
		 	2. 페이지별 게시물시작 번호 찾기
		 			1페이지 요청 -> (1-1)*3 => 0
		 			2페이지 요청 -> (2-1)*3 => 3
		 			3페이지 요청 -> (3-1)*3 => 6
		 	3. 시작버튼 , 마지막버튼 수
		 		7페이지	btnsize = 5
		 				시작번호패턴 : 1 6 11 16 21
		 		1페이지 -> 1 2 3 4 5
		 		2페이지 -> 1 2 3 4 5
		 		3페이지 -> 1 2 3 4 5
		 		4페이지 -> 1 2 3 4 5
		 		5페이지 -> 1 2 3 4 5
		 		6페이지 -> 6 7
		 		7페이지 -> 6 7
		 		
		 		7페이지	btnsize = 3
		 				시작번호패턴 : 1 4 7 10 ...
		 	
			 */
	
			/*		
			1페이지	: 1-1 /5	 *5	+1		-> 0*5+1		1
			2페이지	: 2-1 /5	 *5	+1		-> 0*5+1		1
			3페이지	: 3-1 /5	 *5	+1		-> 0*5+1		1
			4페이지	: 4-1 /5	 *5	+1		-> 0*5+1		1
			5페이지	: 5-1 /5	 *5	+1		-> 0*5+1		1
			6페이지	: 6-1 /5	 *5	+1		-> 1*5+1		6
			7페이지	: 7-1 /5	 *5	+1		-> 1*5+1		6
			*/
	
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
