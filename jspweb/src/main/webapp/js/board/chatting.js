/*

	코드 작성 = 요리사		JS = 개발자
	코드 실행 = 먹는사람		JS = 유저

	소켓	: 두 프로그램간의 양방향 통신 종착점[ 도착지 ]
	서버소켓		: [JAVA] 서버가 가지고 있는 소켓(대부분은 1개인데 여러개여도 관리가 어려워지기만 할 뿐 문제는 X)
	클라이언트소켓	: [↓JS] 클라이언트가 가지고 있는 소켓[ 각 클라이언트마다 ] 
				  (만드는건 개발자지만 유저가 사용하니까)
				  
	카카오톡유저								카카오톡 본사/서버실
	클라이언트								서버
	new WebSocket(서버소켓);				@ServerEndpoint("/서버소켓URL")
		1.클라이언트소켓.Open			<----연결-----		@OnOpen
		2.클라이언트소켓.send			----보내기----->		@OnMessage
		3.클라이언트소켓.onmessage	<----보내기-----		세션명.getBasicRemote().sendText(보내고싶은 내용)
		4.클라이언트소켓.OnClose		<----연결끊기---->		@OnClose
		
	유재석		안녕------------------->
	(소켓)	<-------------------안녕
	안산
					
	강호동								(서버소켓) 채팅방(유재석,강호동,신동엽)
	(소켓)	<-------------------안녕	제주도
	수원
			
	신동엽
	(소켓)	<-------------------안녕
	서울
			
			
	JS WebSocket
		1. JS 에서 제공하는 클래스 WebSocket
		2. 소켓 객체 만들기
			let 클라이언트소켓 = new WebSocket(ws://서버소켓URL);
		3. 소켓이 서버소켓과 연동
			1. WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
			
	JAVA serverSocket
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스위에 @ServerEndpoint("ws://ip:포트번호/프로젝트명서버소켓경로URL")
			- @ServerEndpoint : 서버소켓의 URL 만들기
			- @WebServlet	  : HTTP의 URL 만들기
		3. 클라이언트 소켓이 서버소켓[엔드포인트]으로 접속했을때
			@Onopen : 클라이언트소켓이 접속했을때 매핑[연결]
		
*/
/* 채팅창 내용들이 출력되는 상자 */
let contentbox = document.querySelector('.contentbox')

let 클라이언트소켓 = null;

if(memberInfo.mid == null){ // memberInfo : 헤더js에 존재하는 객체
	alert('로그인부터 하고 온나잉ㅡㅡ'); location.href="/jspweb/member/login.jsp";
}else{
	// ☆☆☆☆☆☆ 1. 클라이언트소켓 생성과 서버소켓 연결 [ @OnOpen ]☆☆☆☆☆☆
	클라이언트소켓 = new WebSocket('ws://192.168.17.123:8080/jspweb/chatting/'+memberInfo.mid);
	//클라이언트소켓 = new WebSocket('ws://localhost:8080/jspweb/chatting/'+memberInfo.mid);
	클라이언트소켓.onopen = function(e){서버소켓연결(e);}			// 클라이언트소켓 객체에 정의한 함수 대입
	클라이언트소켓.onmessage = function(e){메시지받기(e);}	// java에서 통신된 이벤트 결과를 e로 받음
	클라이언트소켓.OnClose = function(e){연결해제(e)}
}

// ☆☆☆☆☆☆ 2. 클라이언트소켓이 접속했을때 이벤트/함수 정의 ☆☆☆☆☆☆	굳이 안넣어도 open은 되는데 open했을때 이 함수를 실행한다
function 서버소켓연결(e){contentbox.innerHTML += `<div class="alarm"><span>채팅방 입장하셨습니다</span></div>`;}		// 접속했을때 하고 싶은 함수 정의


// ☆☆☆☆☆☆ 3. 클라이언트소켓이 서버에게 메시지를 보내기 [ @OnMessage ] ☆☆☆☆☆☆
function 보내기(){
	let msgbox = document.querySelector('.msgbox').value;
	// ** 서버소켓에게 메시지 전송하기
	클라이언트소켓.send(msgbox);
	// 전송 성공시 채팅입력창 초기화
	document.querySelector('.msgbox').value = '';
}
// ☆☆☆☆☆☆ 4. 서버로부터 메시지가 왔을때 메시지 받기 ☆☆☆☆☆☆
function 메시지받기(e){	// <--------- e <--------getBasicRemote().sendText(msg)
	console.log(e);
	console.log(e.data);	// e.data : 문자열타입 vs JSON.parse(e.data) : 객체타입
	console.log(JSON.parse(e.data)); // 문자열json -> 객체json 형변환
	
	let data = JSON.parse(e.data);		// 전달받은 메시지 dto
	
	// 보낸사ㅓ람과 현재 유저가 일치하면 [ 내가 보낸 메시지 ]
	if(data.frommid == memberInfo.mid){
		contentbox.innerHTML += `<div class="secontent">
									<div class="date">${data.time}</div>
									<div class="content">${data.msg}</div>
								</div>`
	}else{ // [ 내가 받은 메시지 ]
		contentbox.innerHTML += `<div class="tocontent">
									<div> <img src="/jspweb/member/pimg/${data.frommimg == null ? 'default.webp' : data.frommimg}" class="hpimg"> </div>
									<div class="rcontent">
										<div class="name"> ${data.frommid }</div>
										<div class="contentdate">
											<div class="content"> ${data.msg} </div>
											<div class="date"> ${data.time} </div>
										</div>
									</div>
								</div>`
	}
	// ------------- 스크롤 최 하단으로 내리기 ------------- //
/*	let top = contentbox.scrollTop;	// 현재 스크롤의 상단위치 좌표
		console.log(top);
	let height = contentbox.scrollHeight; // 현재 스크롤 전체의 높이 [ 기본값 contentbox height ];
		console.log(height);
	contentbox.scrollTop = height;*/
	// 스크롤막대의 상단 위치를 스크롤막대의 가장 아래의 위치로 대입
	contentbox.scrollTop = contentbox.scrollHeight;

}


// ☆☆☆☆☆☆ 5. 서버와 연결이 끊겼을때.[ 클라이언트소켓 객체가 초기화될때 -> F5 , 페이지 전환할때 등등 ] ☆☆☆☆☆☆
function 연결해제(e){
	console.log('연결해제');
}

// 6. 엔터키 눌렀을때
function enterkey(){
	// 만약에 입력한 키 코드가 13[엔터] 이면 메시지전송
	console.log(window.event.keyCode)
	if(window.event.keyCode == 13){
		보내기();
	}
}

/*
	클라이언트소켓 필드							서버소켓
	(↑얘는 이미 정의가 되어있는 상태(존재하는상태)라서 = 대입연산자 사용 즉 = 없어도 실행은 된다)
		onopen		=
		onclose		=
		onmessage	=
		
		// 통신 결과	
		1번 : 클라이언트소켓.onclose = function(e){console.log('연결해제');}
			vs
		2번 : 클라이언트소켓.onclose = (e)=>{console.log('연결해제');}			---> 1 2 3 셋 다 같은 함수
			vs
		3번 : function 함수명(e){console.log('연결해제');}
		클라이언트소켓.onclose = (e)=>{함수명(e)}
	
	AJAX 필드	<--(얘는 생성 하면서 성공했을때 결과를 정의하는거라 아직 없는놈임 그래서 : 사용) 
		// 통신결과
		success : function(r){}
		success : (r)=>{}
*/

















