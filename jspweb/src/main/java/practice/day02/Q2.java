package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Q2
 */
@WebServlet("/Q2")
public class Q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<Q2Dto> Qlist = Q2Dao.getInstance().QGetData();
	ObjectMapper QobjectMapper = new ObjectMapper();
	String QjsonArray = QobjectMapper.writeValueAsString(Qlist);
	
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json");
	response.getWriter().print(QjsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Qdata1 = request.getParameter("Qdata1");
		String Qdata2 = request.getParameter("Qdata2");
		double Qdata3 = Double.parseDouble(request.getParameter("Qdata3"));
		int Qdata4 = Integer.parseInt(request.getParameter("Qdata4"));
		String Qdata5 = request.getParameter("Qdata5");
		String Qdata6 = request.getParameter("Qdata6");
		boolean Qdata7 = Boolean.parseBoolean(request.getParameter("Qdata7"));
		String Qdata8 = request.getParameter("Qdata8");
		String Qdata9 = request.getParameter("Qdata9");
		
		Q2Dto q2Dto = new Q2Dto(Qdata1, Qdata2, Qdata3, Qdata4, Qdata5, Qdata6, Qdata7, Qdata8, Qdata9);
		System.out.println(q2Dto.toString());
		boolean result = Q2Dao.getInstance().QSetData(q2Dto);
		
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().print(result);
	}

}
