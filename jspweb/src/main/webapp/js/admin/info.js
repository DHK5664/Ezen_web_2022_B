// js -> admin -> info.js

/*
	JSON = JS객체
	let 객체명 = { 필드명/키 : 데이터 , 필드명/키 : 데이터 , 필드명/키 : 데이터 }
	
		1. 해당 객체의 필드명만 호출/추출
			Object.keys(객체명) : 객체내 모든 필드명/키 이름을 배열로 추출
		
		2. 해당 객체의 값만 호출/추출
			Object.values(객체명) : 객체내 모든 데이터 를 배열로 추출
*/

const ctx = document.getElementById('myChart');

$.get("/jspweb/point" , (r)=>{
	console.log(r); console.log(Object.keys(r)); console.log(Object.values(r));
	
	// ---------------- chart.js 차트 -----------------//

	// new Chart( 'dom객체' , {차트옵션} );
	// { type : '차트이름' , data : { 차트에 표시할 데이터 } , options : {차트옵션} }
		// labels : 가로축

  new Chart(ctx, {
    type: 'line', // bar : 막대차트 , line : 선차트
    data: {
      labels: Object.keys(r),	// 가로축	// 날짜필드명
      datasets: 
      [
		  {
	        label: '포인트 충전 내역', // 데이터 항목명
	        data: Object.values(r), // 해당 항목의 데이터 // 데이터 값  
	        borderWidth: 1
	      }
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
	
	
	
})

let memberPageObject = {
	page : 1 ,
	key : "",
	keyword : "" ,
	listsize : 3
};

console.log('js열림')

getMemberList(1);
function getMemberList(page){
	console.log(page)
	memberPageObject.page = page;
	console.log(memberPageObject)
	$.ajax({
		url:"/jspweb/member",
		method : "get",
		data:memberPageObject,
		success : (r)=>{
			console.log('통신');
			console.log(r);	// 응답 결과 데이터 화긴 (만일 안왔다 하면 서블릿 확인)
			
			// 1. 응답데이터 처리
			let html = `<tr>
							<th width="10%"> 번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일주소 </th>
							<th width="10%"> 비고 </th>
						</tr>`
			r.memberList.forEach((o,i)=>{
				// 2. 테이블 내용물 추가구성
				// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용
				html += `<tr>
							<td> ${o.mno} </td>
							<td> <img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg }" width="100%"> </td>
							<td> ${o.mid} </td>
							<td> ${o.memail} </td>
						</tr>`
			}); // for end
				// 3. 구성된 html을 table 대입
			document.querySelector('.mListTable').innerHTML = html;
			html = ''
			html+=page <= 1 ?
			`<button onclick="getMemberList(${ page })" type="button"> 이전 </button>`
			:
			` 
			<button onclick="getMemberList(${page-1})" type="button"> 이전 </button>
			`
			for(i = r.startbtn ; i<=r.endbtn ; i++){
				html += 
				`
					<button onclick="getMemberList(${i})" type="button"> ${i} </button>
				`
			}
			html += page >=r.totalpage ? 
			`
			<button onclick="getMemberList(${ page })" type="button"> 다음 </button>
			`
			:
			`
			<button onclick="getMemberList(${ page+1 })" type="button"> 다음 </button>
			`
			document.querySelector('.adminpagebox').innerHTML = html;
			document.querySelector('.seachcount').innerHTML = `회원 수 : ${ r.totalsize } `
		}
	})
}

function getsearch(){
	console.log('admingetsearch()버튼 눌림')
	memberPageObject.key = document.querySelector('.key').value;
	memberPageObject.keyword = document.querySelector('.keyword').value;
	
	getMemberList(1);
}

function setsearch(){
	memberPageObject.key = '';	// 검색 없애기
	memberPageObject.keyword ='';	// 검색 없애기
	getMemberList(1);		// 재호출
}
	
	
function setlistsize(){
	// 1. select 에서 선택된 값 가져오기 
	console.log("연결")
	let listsize 
		= document.querySelector('.listsize').value;
	// 2. pageObject 필드에 대입 
	memberPageObject.listsize = listsize;
	// 3.  
	getMemberList(1);	
	
} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	