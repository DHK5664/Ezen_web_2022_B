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

	
	
	// *-* 접속한 클라이언트명단[목록]	(클라이언트소켓 여러개 저장)
	public static ArrayList<ClientDto> 접속명단 = new ArrayList<>();
	
	// 클라이언트 소켓이 접속했을때의 실행되는 메소드/함수
	@OnOpen		// session [접속한 클라이언트소켓 객체]	// 서버 엔드포인트의 URL 매개변수[@PathParam] 가져오기
	public void OnOpen(Session session , @PathParam("mid") String mid ) throws Exception {
		System.out.println("클라이언트 웹소켓이 들왔다.");
		System.out.println("session:" + session);
		// 접속한 클라이언트소켓들을 보관
		ClientDto clientDto = new ClientDto(session, mid); 
		접속명단.add(clientDto);
		
		// 연결된 클라이언트 소켓을 모든 접속명단에게 알림 메시지 보내기
		onMessage(session, "enter");	// 예외처리가 무조건 필수인데 우리가 만든 함수가 아니라서 수정이 불가능하기에 걍 던짐
		
	} // end
	
	
	
	@OnClose	// 클라이언트소켓이 나갔을때(F5 눌렀을때)
	public void onClose(Session session) throws Exception {
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
		// 접속이 끊긴 세션의 dto 찾아서 제외
		for(ClientDto dto : 접속명단) {
			// 회원명단 에서 세션과 접속이 끊긴 세션이 일치하면
			if(dto.getSession()==session) {
				접속명단.remove(dto);	// 접속명단에서 제외시키기
				
				// 연결 끊긴 클라이언트 소켓을 모든 접속명단에게 알림 메시지 보내기
				// 1. 문자열타입의 JSON형식 직접 작성하기 [VS ObjectMapper ]
					// {"필드명" : "데이터" , "필드명2" : "데이터2"}
				String msg = "{\"type\":\"alarm\",\"msgbox\":\""+dto.getMid()+"님이 채팅방을 나갔습니다.\"}";
				onMessage(session , msg);
				// 연결 끊긴 클라이언트 소켓을 모든 접속명단 목록 알림 메시지 보내기
				onMessage(session, "enter");
				
				break;	//	나갔으면 한번만 실행하면 되니까
			}
		}
		//접속명단.remove(session);	// F5 눌렀을때 소켓이 사라져서 접속명단에서 제외 시키기(js다보니 새로고침때마다 초기화대서)
	}// end
	// 클라이언트 소켓이 메시지를 보냈을때[서버가 메시지 받기]
	@OnMessage	// [ Session[누가] , String[내용물] ]
	public void onMessage(Session session , String msg) throws Exception {
		
		// 메시지 받는 프로그램[JS] : JSON 으로 형변환 // * Session 객체를 json형식으로 변환 불가능
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		// 2. 접속명단 알림
		if(msg.equals("enter")) {
			ArrayList<MessageDto> list = new ArrayList<>();	// 회원명단[이미지 , 아이디] 포함된 회원리스트 생성
			for(ClientDto dto : 접속명단) {
				list.add(new MessageDto(dto.getSession() , null));	// 현재 접속된 회원정보 객체 생성
			}
			json = mapper.writeValueAsString(list);	// 접속자 명단 객체 여러개
		// 1.메시지
		}else {
			MessageDto messageDto = new MessageDto(session, msg);
			json = mapper.writeValueAsString(messageDto);			// 메시지 보낸 정보 객체 1개
		}
		
		// 메시지형식 구성
		
		
		 
		

		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( ClientDto dto : 접속명단 ) {
									// json형식[모양]의 타입은 문자열로 전송됨
										// String a = "10"; 숫자형식[모양] 타입은 문자열
			dto.getSession().getBasicRemote().sendText(json);// ---> 클라이언트소켓.onmessage (js의 클라이언트소켓.onmessage로 가는데 클라이언트소켓.onmessage에 새로 만든 함수를 대입해서 onmessage 실행시 해당 함수를 실행)
		}
	}
	
}
