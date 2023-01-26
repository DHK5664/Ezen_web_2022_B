
let productlist = [
	{ img : 'p1.gif' ,title : '나인 스판 데님 팬츠', size : '[ M , L ]', price : 189000 , discount : 0.23 , like : 54 , review : 412},
	{ img : 'p2.gif' ,title : '포멀 세미오버 옥스포드 셔츠', size : '[ FREE ]', price : 89000 , discount : 0.3 , like : 2 , review : 110},
	{ img : 'p3.gif' ,title : '시엠 코듀로이 오버핏 셔츠', size : '[ M , L ]', price : 279000 , discount : 0.2 , like : 7 , review : 240},
	{ img : 'p4.gif' ,title : '활용성 좋은 피치코트 셔츠', size : '[ FREE ]', price : 69000 , discount : 0.1 , like : 8 , review : 78},
	{ img : 'p5.gif' ,title : '히든버튼 베러 핀턱 셔츠', size : '[ M , L ]', price : 99000 , discount : 0.5 , like : 12 , review : 55},
	{ img : 'p6.gif' ,title : '실용성 좋은 루즈핏 셔츠자켓', size : '[ XL ]', price : 87500 , discount : 0.15 , like : 1 , review : 31}
]


product_print();
// 1. 제품 출력 // 1. js 열릴때
function product_print(){
	let html = ``
	productlist.forEach(( o )=>{
		html+=`
	<div class="item">							<!-- 제품 1개 -->
				<img src="img/${o.img}">					<!-- 제품이미지 -->
				<div class="item_info">					<!-- 제품정보 구역 -->
					<div class="item_title">${o.title} </div>	<!-- 제품명 -->
					<div class="item_size">${o.size}</div>		<!-- 제품사이즈 -->
					<div class="item_price">${o.price.toLocaleString()}원</div>	<!-- 원가 -->
					<div>
						<span class="item_sale">${parseInt(o.price - (o.price*o.discount)).toLocaleString()}원</span>		<!-- 판매가 -->
						<span class="item_discount">${parseInt(o.discount*100)}%</span>	<!-- 할인율 -->
					</div>
				</div>
			
			<div class="item_bottom">	<!-- 제품정보 하단 구역 -->
				<div>
					<span class="badge rounded-pill text-bg-warning">주문폭주</span>		<!-- 배지 -->
					<span class="badge rounded-pill text-bg-danger">1+1</span>
				</div>
				<div class="item_review">찜 ${o.like} 리뷰수 ${o.review}</div>
				<!-- · alt누른 상태로 + 1 + 8 + 3 순서대로 누르기 -->
			</div>
			</div>`
	})
	document.querySelector('.itembox').innerHTML=html
}