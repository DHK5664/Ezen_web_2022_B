
/* ------------ 공통데이터 : 모든 함수에서 공통으로 사용 할 예정 : 전역변수 ------------ */
// 등록된 카테고리'문자열' 목록 / 배열
let categoryList = [ '프리미엄' , '스페셜', '와퍼' , '올데이킹' , '치킨버거' ]
// 등록된 '버거객체' 목록 / 배열
let burgerList = [ 
	{name :'몬스터X' , price : 9200 , img :'monWimg.png' , category : '프리미엄'} ,
	{name :'몬스터와퍼' , price : 8200 , img :'몬스터와퍼img.png' , category : '프리미엄'} ,
	{name :'오믈렛킹모닝' , price : 5000 , img :'오믈렛킹모닝.png' , category : '스페셜'} 
	
]
/*
	1. 버거객체   ★★★★★★★★★★★★★★★ 버거객체는 카트배열로 가고 카트배열은 주문객체로 간다.★★★★★★★★★★★★★★★
	let burger ={
		name : ,		// 버거이름
		price: ,		// 버거가격
		img : ,			// 버거이미지
		category		// 버거 카테고리
	}
	
	2. 주문객체
	let order ={
		 no : no ,
		 items : map배열 ,					// 카트배열 ---> 새로운 배열
		 time : new Date() ,				// new Date() : 현재 날짜/시간 호출
		 state:  true ,						// true : 일단 주문	// false :주문 완료
		 complete : 0 ,						// 아직 주문 완료 되기전
		 price : total						// cartlist 배열 내 버거 객체들의 총금액 합계
	}
*/

// 카트 등록된 '버거객체' 목록/배열
let cartlist = [  ]	// 카트 목록
// '주문객체' 목록/배열
let orderList = [  ]// 주문 목록
/* ------------ 공통 DB End ------------ */

/* ------------ js 열렸을때 실행되는 함수들 ------------ */
category_print();		// 카테고리 출력하는 함수 호출
category_select( 0 );	// 카테고리 선택시 CSS 변경 / 카테고리별 제품출력 함수호출 /기본값 : 프리미엄
product_print( 0 );		// 제품출력 함수 / 기본값 : 프리미엄

// 1. 카테고리 출력하는 함수 // [1. js 열렸을때]
function category_print(){
	
	// 1. HTML 구성
	let html = `<ul>`
	
	for( let i = 0 ; i<categoryList.length ; i++){
		html += 
				`<li class = "categoryli"
				onclick="category_select( ${i} )"
				> ${categoryList[i]} </li>`
	}
		html +=	`</ul>`
	// 2. 해당 마크업에 HTML 출력
	document.querySelector('.categorybox').innerHTML = html
}// f e

// 2. 카테고리 선택 함수
function category_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장
	let categoryli = document.querySelectorAll(".categoryli")
	// 2. 모든 li 배열 반복문
	for(let j = 0 ; j< categoryli.length ; j++){// for s
		
		if(j == i){ // 만약에 li배열에서 내가 선택한 li의 인덱스와 같으면
			categoryli[j].classList.add('categoryselect') ; // 해당 마크업의 class 식별자 추가
		}else{// 선택되지 않은 li
			categoryli[j].classList.remove('categoryselect'); // 해당 마크업의 class 식별자 제거
		}
	}//for e
	// 3. 제품목록 렌더링 [ 화면 업데이트 ]
	product_print(i)
	
}
// 3. 제품출력 함수 // [ 1. js열렸을때 2. 카테고리 바뀌었을 때]
function product_print( index ){
	//1. html 구성
	let html = '';
	
	for( let i = 0 ; i<burgerList.length ; i++){
			// i는 0번째 인덱스부터 마지막 인덱스까지 버거 객체 가져온다.
			
		if(burgerList[i].category== categoryList[index]){
			// i번째 버거객체의 카테고리와 선택된 카테고리와 같으면
	html += `<div onclick ="cartadd(${i})" class="product">
							<img src="img/${burgerList[i].img}" width="100%">
							<div class="productinfo">
								<div class="ptitle">${burgerList[i].name} </div>
								<div class="pprice">${(burgerList[i].price).toLocaleString()}원~</div>
							</div>
						</div>`
		}
	}
	
	//2. 구성된 html 마크업 대입
	document.querySelector('.productbox').innerHTML =html;
}

// 4. 선택한 제품을 카트에 담기

function cartadd(i){
	// 1. 선택한 i번째 버거의 객체를 cartlist에 추가
	cartlist.push(burgerList[i])
		cart_print(); // 카트 내 제품 화면 렌더링[새로고침]
	
}// f e

// 5. 주문취소 버튼
function cancel(){	// 모든 취소 이므로 i번쨰 인덱스 필요없음
	alert('주문 취소합니다.'); cartlist.splice(0);// 개수 생략시 모두 삭제
	cart_print(); // 카트 내 제품 화면 렌더링[새로고침]
}
// 6. 주문하기 버튼
function order(){
	alert('주문 합니다.')
	
	//1. 고유한 주문번호 만들기// 마지막 인덱스 : 배열명.length-1
	let no = 0;	
	if(orderList.length == 0){no = 1;}//1. 만약에 길이가 0이면 [주문 하나도 없으면 주문번호 1 ]
	else{no = orderList[orderList.length-1 ].no+1}// 2. 아니면 마지막인덱스 주문객체의 주문번호+1 을 다운 주문번호 사용
	
	// 2. 카트배열 -> 새로운배열 [주문객체에 카트배열 대입시 카트배열 초기화시 주문객체 내 카트배열도 초기화 = 메모리 동일하기 때문에 ]
	
	let map배열 = cartlist.map((o) => {console.log(o); return o;})	// map 함수에서 return된 객체를 새로운 배열에 대입
		// 간단하게 모두가 같이 사용하는 공공물건(?)인 마트카트에서 내 장바구니로 옮겼다고 생각하자
		// 물건은 그대로 변함없이 있고 담겨있는 장소(배열)만 바뀐거니까.
	// 3. 총가격 만들기
	let total = 0;
	for( let i = 0 ; i<map배열.length ; i++){total += map배열[i].price}
	
	// 1. 주문
	 // 1. order 객체 만들기
	 let order = {
		 no : no ,							// 주문번호 [인덱스사용X 중간에 있는 인덱스가 삭제되면 뒷번호 인덱스가 앞으로 당겨지므로!]
		 items : map배열 ,					// 카트배열 ---> 새로운 배열
		 time : new Date() ,				// new Date() : 현재 날짜/시간 호출
		 state:  true ,						// true : 일단 주문	// false :주문 완료
		 complete : 0 ,						// 아직 주문 완료 되기전
		 price : total						// cartlist 배열 내 버거 객체들의 총금액 합계
	 }
	 
	 // 2. order 객체 배열에 저장
	orderList.push( order )
	console.log(orderList)
	
	
		// ~~~~~~ 카트리스트 ---> 주문목록
	// 2. 주문 완료 후
	cartlist.splice(0);	// 전역변수 내 초기화 // 그 전에 안에 들어있는 데이터를 다른 곳으로 옮기자 -> 주석 2번코드
	cart_print();
	b_Order_print();
	sales_print();
}

// 7. 카트내 버거 출력 [ 1. 제품 클릭할 때 마다 , 2. 취소/주문 ]
function cart_print(){
	// 2. 버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartlist.length
	// 3. 버거 총 금액
	let total = 0;
	for (let j = 0; j<cartlist.length ; j++){total+=cartlist[j].price}
	document.querySelector('.ptotal').innerHTML = total.toLocaleString();
	// 4.
	let html = ''// 1. 기본 html 구성
	for(let j = 0 ; j<cartlist.length ; j++){	// 마지막 인덱스까지 반복 증감시킴 그래서 밑에는 해당 배열의 j번째
												// 인덱스까지 대입하는것이고 예를들어 배열에 요소가 3개 있다고 가정하면
												// 인덱스는 0 1 2 길이는 3이므로 <=이렇게 이하는 안댄다. 
		html +=`<div class="item"> <!-- 제품 1개 -->
					<div class="ititle">${cartlist[j].name}</div>
					<div class="iprice">${cartlist[j].price.toLocaleString()}원</div>
				</div>`
	}
	document.querySelector('.cartbottom').innerHTML = html;	// 2. 구성된 html 마크업에 대입
}

//--------------- 관리자 부분 ---------------
// 버거 객체 등록을 위한 배열

let Addbtn = document.querySelector('.Addbtn')

Addbtn.addEventListener('click' , ()=>{
	
	let bIf = {
		name : document.querySelector('.name').value,
		category : document.querySelector('.category').value,
		price : parseInt(document.querySelector('.price').value),
		img : document.querySelector('.img').value
		
	}

	// 2. 유효성 검사
	let check = true;
	for(i=0; i<burgerList.length; i++){
		if(burgerList[i].name == bIf.name){
			alert('이미 등록된 버거명 입니다.'); check=false;
		}
	}
	if(isNaN(bIf.price)){alert('숫자형식으로 입력해주십시오.');check=false;
	}
	if(categoryList.includes(bIf.category) ){}
	else{alert('존재하는 카테고리 내에서 기입하여 주십시오');check=false; }
	
	if(check){burgerList.push(bIf);alert('새로운 버거를 등록했습니다'); print_BMenu(); }
	console.log(burgerList)
	category_select( 0 )
})


print_BMenu()
function print_BMenu(){
	
	let html = `<tr>
					<th> 제품번호 </th><th> 이미지 </th><th> 버거이름 </th>
					<th> 카테고리 </th><th> 가격 </th><th> 비고 </th>
				</tr>`
	
	for (let i=0; i<burgerList.length; i++){
			html += `<tr>
						<td>${i+1}</td>
						<td><img src="img/${burgerList[i].img}" width="100%"></td>
						<td>${burgerList[i].name}</td>
						<td>${burgerList[i].category}</td>
						<td>${burgerList[i].price}</td>
						<td><button class="Dbtn" onclick="onDelete( ${ i } )">삭제</button>
							<button class="Ubtn" onclick="p_OnUpdate( ${ i } )">가격수정</button></td>
					</tr>`
					
	}
		document.querySelector('.b_M_N').innerHTML= html;

}
// 삭제버튼 함수
function onDelete(i){ 				// i번째 인덱스의 삭제버튼 클릭
		burgerList.splice(i,1);		// i번째 인덱스부터 1개 삭제
		print_BMenu();	category_select(0);		// 새로고침
}// f e

// 가격수정버튼 함수
let upindex = -1 ;					// 전역변수로 사용하기 위해 선언//다른 숫자 넣어도 상관 없지만 0 이상부터는 인덱스와 겹칠 수 있어서 안정빵으로 -1 넣음
function p_OnUpdate( i ){			// i번째 인덱스 가격 수정버튼 클릭
	upindex = i 					// i값을 upindex에 대입 // 내가 선택한 i번째 인덱스
	document.querySelector('.updatetable').style.display='block'// 가려뒀던 가격수정용 테이블 재등장
	document.querySelector('.up_Price').value = burgerList[upindex].price// 수정값 대입
} // f e

let updatebtn = document.querySelector('.updatebtn')
updatebtn.addEventListener('click' , ()=>{
	
	burgerList[upindex].price = parseInt(document.querySelector('.up_Price').value)

	document.querySelector('.updatetable').style.display = 'none'

print_BMenu(); category_select(0);
})// 가격수정완료버튼 f e

b_Order_print();
function b_Order_print(){// 주문현황
	
	let state = ''
	let html = `<tr>
					<th> 주문번호 </th><th> 버거이름 </th>
					<th> 상태 </th><th> 비고 </th>
				</tr>`
				
	for(let i = 0 ; i<orderList.length ; i++){
		
		if(orderList[i].state){state='주문요청'}
		else{state='주문완료'}
		
		for(let j=0 ; j<orderList[i].items.length ; j++){
			html += `<tr>
						<th>${orderList[i].no}</th>
						<th><${orderList[i].items[j].name}></th>
						<th>${orderList[i].state ? "주문요청" : "주문완료"}</th>
						<th>
							${	orderList[i].state ? 
								'<button onclick="orderEnd( '+i+' )">주문완료</button>' : ''
							}
						</th>
					</tr>`
			}

		}
	document.querySelector('.orderprint').innerHTML = html;
}


// 6. 주문상태 변경 [state 상태]
function orderEnd(i){console.log(i);
	orderList[i].state = false; // 주문완료
	b_Order_print(); // 주문현황 렌더링
	console.log(orderList)
}

sales_print()
// 7.매출 현황 테이블 출력 
function sales_print(){	// 1. js 열렷을때 // 2. 주문 들어왔을때
	let html=`<tr>
				<th width="10%">제품번호</th>
				<th width="30%">버거이름</th>
				<th width="10%">판매수량</th>
				<th width="10%">매출액</th>
				<th width="10%">순위</th>
			</tr>`
	burgerList.forEach((burger , i )=>{ // * 현재 등록된 모든 버거 반복 중
		html +=
			`<tr>
				<th width="10%">${i+1}</th>
				<th width="30%">${burger.name}</th>
				<th width="10%">${sales_count(i)}</th>
				<th width="10%">${(sales_count(i)*burger.price).toLocaleString()}</th>
				<th width="10%">${sales_rank(i)}</th>
			</tr>`
	})		
			
	document.querySelector('.salestable').innerHTML = html;
} // f e



// 8. index 번쨰 버거의 판매수량 찾기
function sales_count(index){ console.log(index+'번버거 선택');
	
	let count = 0; // 1. i번째 제품의 누적 판매수량 저장하는 변수
	
	orderList.forEach( (order, i )=>{	// 주문목록 반복문
		order.items.forEach(( burger,j )=>{ // 주문 마다 버거리스트 반복문 (주문목록 안에 버거리스트가 또 있으므로)
			// 만약에 주문목록 내 버거리스트중에서 버거이름과 index 번째 버거이름과 같으면
			if(burger.name == burgerList[index].name){count++;}
		})
	})
	
	
	return count ; // * index번째 제품의 누적 판매수량 변수 반환
}

// 9. 순위
function sales_rank(index){console.log(index+'번째 버거 순위');
	let rank = 1; // 1. index 번째 버거의 순위 저장하는 변수 [기본값 1등]
	// 2. index 번째 버거의 순위를 구하기
	// 1. index 번째 버거의 매출액 // 매출액 : 수량 * 금액
	let total = sales_count(index)*burgerList[index].price ;  
		// 2. 모든 버거들의 마다의 매출액
	burgerList.forEach(( burger , i ) => {
		let total2 = sales_count(i)*burger.price;
		// 3. 비교[ 만약에 index번쨰 버거의 매출액 보다 현재 반복되는 버거의 i번쨰 버거의 매출액보다 작으면 rank 증가(1등에서 2등으로 감)]
		if(total < total2){rank++;}
	})	
	
	return rank;	// * index 번째 버거의 순위 반환

}














/*
 뭐가 뭔지 모르겠으면 무조건 콘솔 찍어보기
*/





/*

`` 백틱에서 삼항연산자
`${조건?
	참 : 거짓
}` 

*/






/* 함 = 상자 / 수 = 숫자
		인수 : 매개변수 : 함수 안으로 들어가는 수
		반환 : 결과값 : 함수 밖으로 나가는 수 [ 함수 종료시 함수 내 메모리 초기화]
	function 함수(){					상자(1)
		return 반환값
		
	}






*/

