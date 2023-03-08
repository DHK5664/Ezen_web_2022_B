// js -> admin -> info.js

console.log('js열림')

getMemberList();
function getMemberList(){
	$.ajax({
		url:"/jspweb/member",
		method : "get",
		//data:"",
		success : (r)=>{
			console.log('통신');
			console.log(r);	// 응답 결과 데이터 화긴 (만일 안왔다 하면 서블릿 확인)
			
			// 1. 응답데이터 처리
			let html = `<tr>
							<th> 번호 </th>
							<th> 프로필 </th>
							<th> 아이디 </th>
							<th> 이메일주소 </th>
							<th> 비고 </th>
						</tr>`
			r.forEach((o,i)=>{
				// 2. 테이블 내용물 추가구성
				html += `<tr>
							<th> ${o.mno} </th>
							<th> ${o.mig} </th>
							<th> ${o.mid} </th>
							<th> ${o.memail} </th>
						</tr>`
			}); // for end
				// 3. 구성된 html을 table 대입
			document.querySelector('.mListTable').innerHTML = html;
		}
	})
}