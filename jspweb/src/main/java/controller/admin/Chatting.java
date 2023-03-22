package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MessageDto;
// URL 매개변수 받을때 : /경로/{매개변수1}/{매개변수2}			--> @PathParam("경로상의매개변수명") 타입 변수명
				/* 
				   회원아이디 qweqwe라고 가정할때
				   /jspweb/chatting/qweqwe
				   /jspweb/chatting/{mid}
				   @PathParam("mid") String 매개변수;
				   매개변수 = qweqwe
				 */
// URL 매개변수 받을때 : /경로?매개변수명 = 데이터 & 매개변수명2=데이터	--> request.getParameter("매개변수명");

@ServerEndpoint("/chatting/{mid}")// 해당 클래스를 서버소켓[종착점] 으로 만들기	// URL : /경로/{매개변수1}/{매개변수2}
public class Chatting {

	// 클라이언트 소켓이 접속했을때의 실행되는 메소드/함수
	
	// *-* 접속한 클라이언트명단[목록]	(클라이언트소켓 여러개 저장)
	public static ArrayList<ClientDto> 접속명단 = new ArrayList<>();
	
	@OnOpen		// session [접속한 클라이언트소켓 객체]	// 서버 엔드포인트의 URL 매개변수[@PathParam] 가져오기
	public void OnOpen(Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 웹소켓이 들왔다.");
		System.out.println("session:" + session);
		// 접속한 클라이언트소켓들을 보관
		ClientDto clientDto = new ClientDto(session, mid); 
		접속명단.add(clientDto);
		System.out.println(접속명단.toString());
	}
	
	@OnClose	// 클라이언트소켓이 나갔을때(F5 눌렀을때)
	public void onClose(Session session) {
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
		// 접속이 끊긴 세션의 dto 찾아서 제외
		for(ClientDto dto : 접속명단) {
			// 회원명단 에서 세션과 접속이 끊긴 세션이 일치하면
			if(dto.getSession()==session) {
				접속명단.remove(dto);	// 접속명단에서 제외시키기
			}
		}
		//접속명단.remove(session);	// F5 눌렀을때 소켓이 사라져서 접속명단에서 제외 시키기(js다보니 새로고침때마다 초기화대서)
	}// end
	// 클라이언트 소켓이 메시지를 보냈을때[서버가 메시지 받기]
	@OnMessage	// [ Session[누가] , String[내용물] ]
	public void onMessage(Session session , String msg) throws Exception {
		
		// 메시지형식 구성
		MessageDto messageDto = new MessageDto(session, msg);
			System.out.println(messageDto.toString());
		
		// 메시지 받는 프로그램[JS] : JSON 으로 형변환 // * Session 객체를 json형식으로 변환 불가능 
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(messageDto);
			System.out.println(json);
		
		//System.out.println("클라이언트 웹소켓이 메시지를 보냈다. [서버가 메시지를 받았다.]");
		//System.out.println("msg : " +msg);
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( ClientDto dto : 접속명단 ) {
									// json형식[모양]의 타입은 문자열로 전송됨
										// String a = "10"; 숫자형식[모양] 타입은 문자열
			dto.getSession().getBasicRemote().sendText(json);// ---> 클라이언트소켓.onmessage (js의 클라이언트소켓.onmessage로 가는데 클라이언트소켓.onmessage에 새로 만든 함수를 대입해서 onmessage 실행시 해당 함수를 실행)
		}
	}
	
}
