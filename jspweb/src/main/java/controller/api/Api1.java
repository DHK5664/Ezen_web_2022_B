package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 공공데이터 포털에서 신청한 데이터 가져오기 [안산시 전기차충전소 현황]	--> 목적지 설정
			// URl 클래스
			// 1. .openStream()	: 해당 객체의 연결된 url 스트림 제공 함수 [ 반환 : InputStream ]
		// URL url = new URL("신청한공공데이터 URL");
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=NRQcpmSIDAXX6nXAgxoMBrAIBSh0dS19ZpH0BEs4gK942%2BEMswPGduxk575l4vUtjoRQHILalRyMKHITTU5wUw%3D%3D");
		
		// 2. 해당 URL 의 데이터 [ 스트림[바이트] ] 읽어오기 위한 스트림 객체 생성 --> 도로깔기
		// InputStream inputStream = url.openStream();
		// InputStreamReader reader = new InputStreamReader(url.openStream() , "UTF-8" );
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		
			// *
			// byte[] array1 = new byte[100000];
			// char[] array2 = new char[100000];
		
		// 3. 스트림으로 바이트 읽어오기 --> 여기에 저장
		// inputStream.read(array1);	// 바이트byte 배열로 읽어오기
		// reader.read(array2);			// 문자char 배열로 읽어오기
		String result = bf.readLine();	// 모든 바이트 읽은 후 문자열 반환
		
		System.out.println(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
