package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Find
 */
@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 입력받은 타입 요ㅓㅇ
		String type = request.getParameter("type");
		String result = null;// * 보낼 결과
		if(type.equals("1")) { // 1이면 아이디찾기
			String memail = request.getParameter("memail"); // 1. 이메일 요청
			result = MemberDao.getInstance().findid(memail);
		}else if(type.equals("2")) { // 2이면 비번찾기
			String mid = request.getParameter("mid");
			String memail = request.getParameter("memail");
			
			// 표현할 난수 문자 목록
			String ranStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			// 임시비밀번호(난수) 만들기
			String updatePwd="";
				// 1. 12자리수
			for(int i = 0 ; i<12 ; i++) {	// 12자리수
				Random random = new Random();
				// ranStr 문자열에서 0인덱스~마지막인덱스 의 난수 인덱스
				int ran = random.nextInt( ranStr.length() );
				updatePwd += ranStr.charAt(ran);	// 난수로 생성된 인덱스의 문자 1개 추출해서 대입
			}// for end
			System.out.println("updatePwd : " + updatePwd );
			
			result = MemberDao.getInstance().findpwd(mid , memail , updatePwd );
		}
		// 3.
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
