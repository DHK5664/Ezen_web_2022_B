package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.AdminPageDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Info() {super();}
    
    
    // 1. 회원가입
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		// ------------- 첨부파일 있을때 --------------------//
 		/*
 			request는 첨부파일(대용량) 에 대한 요청이 불가 --> 외부 라이브러리 cos.jar
 			1. 프로젝트 build path 에 cos.jar 추가
 			2. 프로젝트 WEB-INF -> lib -> cos.jar 추가
 				서버폴더 경로 찾기 : request.getSession().getServletContext().getRealPath("(webapps생략)폴더명");
 			3. 첨부파일 혀용 범위 용량[바이트단위]
 			4. 첨부파일 요청 한글 인코딩
 			5. 첨부파일 파일명 중복일경우 뒤에 자동으로 숫자 붙여서 식별
 			---------
 			MultipartRequest 클래스 제공
 				1. 요청방식 : HTTP request
 				2. 저장폴더 : 1.프로젝트[Git] 2.서버[워크스페이스]
 				 
 				1024*1024 * 10	:10MB
 			----------
 			용량
 				1bit : 0 , 1
 				1byte : 01010101	8bit = 1byte
 				1kbyte : 1024byte	--> 1kb
 				1MByte : 1024kb		--> 1MB
 				1GByte : 1024mb		--> 1GB
 			
 		*/
 		// * 현재 서버의 배포된 프로젝트 내 경로 찾기
 		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
 		System.out.println( uploadpath );
 		
 		// * 업로드 [ 유저파일 --> 서버폴더내 이동 ]
 		MultipartRequest multi = new MultipartRequest(
 				request, 						// 1. 요청방식
 				uploadpath , 					// 2. 첨부파일 가져와서 저장할 서버내 폴더
 				1024*1024 * 10 ,				// 3. 첨부파일 허용 범위 용량 [ 바이트 단위 ] 10MB
 				"UTF-8" ,						// 4. 첨부파일 한글 인코딩
 				new DefaultFileRenamePolicy()	// 5. 동일한 첨부파일명이 존재했을때 뒤에 숫자 붙여서 식별
 				);
 		// 그 외 매개변수 요청 [ request --> multi / form 하위태그 내 input 태그의 name 식별자 ]
 		String mid = multi.getParameter("mid");	// 호출할 input의 name
 		String mpwd = multi.getParameter("mpwd");
 		String memail = multi.getParameter("memail");
 		String mimg = multi.getFilesystemName("mimg");	// 첨부파일된 파일명 호출[.getFilesystemName ]
 		
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 			System.out.println("dto : " + dto );
 		boolean result = MemberDao.getInstance().signup(dto);
 		response.getWriter().print(result);
 		
 		// ------------- 첨부파일 없을때 --------------------//
 		/*
 		// 1. ajax에게 데이터 요청
 		request.setCharacterEncoding("UTF-8");
 		String mid = request.getParameter("mid");
 		String mpwd = request.getParameter("mpwd");
 		String memail = request.getParameter("memail");
 		String mimg = request.getParameter("mimg");
 		// 2. DTO 만들기
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 			System.out.println("dto : " + dto );
 		// 3. Dao 호추랗고 결과받기
 		boolean result = MemberDao.getInstance().signup(dto);
 		// 4. 결과 응답하기
 		response.getWriter().print(result);
 		*/
 	}
 	
 	
    // 2. 로그인 / 회원1명 /회원 여러명 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ----------- 1. 검색 조건 전달
		String key = request.getParameter("key");			
		String keyword = request.getParameter("keyword");
		
		
		int page = Integer.parseInt(request.getParameter("page"));
		//int listsize = 3;
		int listsize = Integer.parseInt( request.getParameter("listsize") ) ;
		int startrow = (page-1)*listsize;
		
		
		// 1. Dao에게 모든 회원명단 요청 후 저장
		ArrayList<MemberDto> result = MemberDao.getInstance().getMemberList( startrow , listsize , key , keyword);
		// 1. 전체페이지수[ 총회원레코드수/페이지당 표시수 ] 2. 페이지 표시할 최대버튼수 3. 시작버튼 번호
			// 1. 검색이 업슬때
				// int totalsize = MemberDao.getInstance().gettotalsize();
			// 2. 검색이 있을때
		int totalsize = MemberDao.getInstance().gettotalsize(key , keyword);
		int totalpage = totalsize%listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
		
		int btnsize = 5; // 최대 페이징버튼 출력수
		int startbtn = ( (page-1) / btnsize ) * btnsize +1 ; 
		int endbtn = startbtn + (btnsize-1);
		
		
		
		if(endbtn>totalpage) { endbtn=totalpage;}
		
		AdminPageDto adminPageDto = new AdminPageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
		
		// 2. JAVA객체 ---> JS객체 형변환 [ 서로 다른 언어 사용하니까 ]
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(adminPageDto);					System.out.println("jsonArray : " + jsonArray );
		// 3. 응답
		response.setCharacterEncoding("UTF-8");			// 한글인코딩
		response.setContentType("application/json");	// 전송할 데이터 타입
		response.getWriter().print(jsonArray);			// 응답 데이터 보내기
		
	}
	

	

	// 4. 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 로그인된 회원이 탈퇴함
			// 1. 로그인된 회원 아이디 가져오기 [ 세션(object) ]
		String mid = (String)request.getSession().getAttribute("login");		System.out.println("mid:" + mid);
		String mpwd = request.getParameter("mpwd");								System.out.println("mpwd:" +mpwd);
		// 2. Dao에게 요청 후 결과 받기 
		boolean result = MemberDao.getInstance().delete(mid , mpwd);			System.out.println("result : " + result);
		// 3. 결과 ajax에게 보내기
		response.getWriter().print(result);
	}
	
	// 3. 회원 정보 수정
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 1. 업로드 코드 구현
				// 1. 업로드 한 파일을 해당 서버 경로로 업로드
			String path = request.getSession().getServletContext().getRealPath("/member/pimg");
				// 2. 객체
			MultipartRequest multi = new MultipartRequest(
					request, path , 1024*1024*10 , "UTF-8" ,
					new DefaultFileRenamePolicy());
			// 2.
			String mid = (String)request.getSession().getAttribute("login");	System.out.println("mid:" + mid);
			String mpwd = multi.getParameter("mpwd");							System.out.println("mpwd:" + mpwd);
			String newmpwd = multi.getParameter("newmpwd");						System.out.println("newmpwd" + newmpwd);
			String memail = multi.getParameter("memail");						System.out.println("memail:" + memail);
			String newmimg = multi.getFilesystemName("newmimg");				System.out.println("newmimg :" + newmimg);
			String defaultimg = multi.getParameter("defaultimg");
			
			// 3. 만약에 새로운 첨부파일이 없으면
			if( newmimg == null ) {// 기존 이미지 파일 그대로 사용
				newmimg = MemberDao.getInstance().getMember(mid).getMimg();
			}
			// 3. 만약에 기존 프로필 사용체크 했으면
			if(defaultimg.equals("true")) {// 기본 프로필 사용
				newmimg = null;
			}
			// * 프로필 변경시 기존프로필 실제파일을 서버에서 삭제[ 누적으로 쌓일 시 용량이 너무 커짐 ]
			
			boolean result = MemberDao.getInstance().update(mid, mpwd, newmpwd, memail, newmimg);
			response.getWriter().print(result);
		}
}


/*
	// 1. 로그인된 회원수정
				// 1. 필요한 데이터 요청
			String mid = (String)request.getSession().getAttribute("login");	System.out.println("mid:" + mid);
			String mpwd = request.getParameter("mpwd");							System.out.println("mpwd:" + mpwd);
			String newmpwd = request.getParameter("newmpwd");					System.out.println("newmpwd" + newmpwd);
			String memail = request.getParameter("memail");						System.out.println("memail:" + memail);
				// 2.
			boolean result = MemberDao.getInstance().update(mid, mpwd, newmpwd , memail);
				// 3. 
			response.getWriter().print(result);
*/





















