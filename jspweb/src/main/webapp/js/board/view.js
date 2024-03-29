

// * 로그인이 안되어있으면 사용 불가
if(memberInfo.mid == null){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rwritebtn').disabled = '로그인 후 작성 쌉가능';
	document.querySelector('.rwritebtn').disabled = true;
}

// * 현재 보고있는게시물 번호
let bno = document.querySelector('.bno').value;

// 1. 해당 게시물 호출
getBoard();
function getBoard(){console.log('함수실행');


	console.log("bno :" + bno);
	
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type" : 2 , "bno": bno} ,
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
			let html = `${r.bdate} /
						${r.bview} /
						<button onclick="bIncrease(2)" type="button">${r.bup}</button> /
						<button onclick="bIncrease(3)" type="button">${r.bdown}</button> /`
						
			document.querySelector('.mimg').src=`/jspweb/member/pimg/${r.mimg==null ? 'default.webp' : r.mimg}`
			document.querySelector('.mid').innerHTML=r.mid;
			document.querySelector('.bdate').innerHTML=r.bdate;
			document.querySelector('.bview').innerHTML=r.bview;
			document.querySelector('.bup').innerHTML=r.bup;
			document.querySelector('.bdown').innerHTML=r.bdown;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if(r.bfile == null){ // 첨부파일 없을때
			
			}else{ // 첨부파일 있을때
				//html = `${r.bfile} <button onclick="bdownload( '${r.bfile}' )" type="button"> 다운로드 </button>`
				html = `<a href="/jspweb/filedownload?bfile=${r.bfile}"> 
								<i class="fas fa-download"></i> ${r.bfile}</a>`
								
								/*html = `<a href="/jspweb/filedownload?bfile=${ r.bfile }" > 
							<i class="fas fa-download"></i>${ r.bfile } 
						</a>`*/
				document.querySelector('.bfile').innerHTML = html;	
			}
			// ----------------230317↓------------------//
			// 로그인 된 회원과 작성자가 일치하면 수정/삭제 버튼 출력
			if(memberInfo.mid == r.mid){
				html =`
					<button onclick="bdelete( ${bno} , ${r.cno} )" type="button" class="bbtn">삭제</button>
					<button onclick="bupdate( ${bno} )" "type="button" class="bbtn">수정</button>
				`;
				document.querySelector('.btnbox').innerHTML=html;
			}
			// 댓글출력
			getReplyList();
		}
	}) // ajax end
}// m end
// 2. 다운로드 [ 다운로드할 파일명 인수로 받기 ]
function bdownload(bfile){
	console.log('선택한 파일명 : ' + bfile);
	/*$.ajax({
		url :"/jspweb/filedownload",
		method : "get",
		data : {"bfile" : bfile},
		success : (r)=>{
			console.log('통신');	console.log(r);
		}
	}) // ajax end*/
	location.href="/jspweb/filedownload?bfile="+bfile;
} // m end

// 3. 조회수[1] 좋아요수[2] 싫어요수[3] (취소 X , 좋아요 싫어요 누가 눌렀는지 모름 , 세가지 한번에 올림(타입으로 구분))
bIncrease(1);	// 현재 jsp/js가 열리는 순간 [조회수 증가]
function bIncrease(type){
	// 1. 현재 게시물의 번호 [ 증가할 대상 ]
	console.log("bno : " +bno);
	// 2.
	$.ajax({
		url:"/jspweb/board/view",
		method : "get",
		data : {"type" : type , "bno" : bno},
		success:(r)=>{
			console.log('통신'); console.log(r);
			getBoard();	// 새로고침
		}
	})
} 

// 4. 삭제
function bdelete(bno , cno){
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"delete",
		data:{"bno" : bno , "type" : 1},
		success :(r)=>{
			console.log(r);
			if(r== 'true'){
				alert('삭제성공');
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}else{
				alert('삭제실패...');
			}
		}
	})	
}
// 5. 수정 페이지로 이동
function bupdate(bno){
	location.href="/jspweb/board/update.jsp?bno="+bno;
}
// 6. 댓글 쓰기
function rwrite(){
	$.ajax({
		url : "/jspweb/board/reply",
		method : "post" ,
		data : {
			"type" : 1 ,	// 1: 상위댓글 / 2: 하위댓글
			"bno" : bno ,
			"rcontent" : document.querySelector('.rcontent').value },
		success :(r)=>{
			console.log(r)
			if(r=="true"){
				alert('댓글작성성공');
				document.querySelector('.rcontent').value=''
				// jquery : 특정 div만 새로고침[랜더링]↓
				// $(".replylistbox").load( location.href+' .replylistbox');
				// js : 현재페이지(전체) 새로고침[랜더링]↓
				location.reload();
			}
			else{alert('댓글작성실패');}
		}
	});
}
// 7. 댓글 출력
function getReplyList(){
	$.ajax({
		url:"/jspweb/board/reply",
		method:"get",
		data:{"type" : 1 , "bno":bno},
		success:(r)=>{
			console.log(r);
			
			let html = ''
			r.forEach((o,i)=>{
				html +=`
					<div>
						<span>${o.mimg} </span>
						<span>${o.mid} </span>
						<span>${o.rdate}</span>
						<span>${o.rcontent} </span>
						<button onclick="rereplyview(${o.rno})" type="button">답변보기</button>
						<div class="rereplybox${o.rno}"></div>
					</div>
				`
			})
			document.querySelector('.replylistbox').innerHTML=html;
		}
	})
}// end
// 8. 하위 댓글 구역 표시
function rereplyview(rno){
	$.ajax({
		url : "/jspweb/board/reply" ,
		async : 'false',	// 동기화 통신
		method : "get" ,
		data : {"type" : 2 , "rindex" : rno , "bno" : bno},
		success:(r)=>{
			console.log(r);
			
			let html = ''
			r.forEach((o)=>{ // 대댓글 html 구성
				
				html +=`-------------------------
				<div>
						<span>${o.mimg} </span>
						<span>${o.mid} </span>
						<span>${o.rdate}</span>
						<span>${o.rcontent} </span>
					</div>
				`
				
			});
			html += `
				<textarea class="rrcontent${rno}">  </textarea>
				<button type="button" onclick="rrwrite(${rno})"> 대댓글작성 </button>
			`
			document.querySelector('.rereplybox'+rno).innerHTML = html;
		}// success end
	})// ajax end

	

	
	
}// end
// 9. 하위 댓글 쓰기 (대댓글, 대대댓글 다 포함!)
function rrwrite(rno){
	// bno , mno , rrcontent , rindex(상위댓글번호) , type
	console.log('rno' + rno)
	$.ajax({
		url:"/jspweb/board/reply",
		method : "post" ,
		data : {
			"type" : 2 , "bno" : bno , "rindex" : rno , 
			"rcontent" : document.querySelector('.rrcontent'+rno).value},
		success:(r)=>{
			console.log(r)
			if(r == "true"){
				alert('대댓글 출력');
				location.reload();
			}
		}
	})
}// end
	


/*
	1. onclick =  JS코드 작성구역
		1. bdownload( 짱구4.jpg ) 	: .파일확장자 구분기호가 아닌 .접근연산자로 사용됨
		2. bdownload( '짱구4.jpg' )	: .접근연산자를 파일확장자 구분기호로 사용할 수 있음
	<button onclick="bdownload( ${r.bfile} )" type="button">
		<button onclick="bdownload( 짱구4.jpg )" type="button">
		
	<button onclick="bdownload( '${r.bfile}' )" type="button">
	<button onclick="bdownload( '짱구4.jpg' )" type="button">
*/

/*
	rno			X
    rcontent	longtext ,
    rdate		X
    rindex		X
    mno			세션[서블릿]
    bno			전역변수
 */















