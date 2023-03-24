console.log('dd')
/*$.ajax({
	url:"/jspweb/product/info",
	method : "get",
	success : (r)=>{
		console.log(r)
	}
})
*/
// vs

$.get("/jspweb/product/info", (r)=>{console.log(r)});

let productList = null;
function productlistprint(){
		let html = '<h3>제품목록페이지</h3>';
		productList.forEach((p)=>{
			html +=`<div>
						<span> ${p.pname} </span>
						<span> ${p.pcomment} </span>
						<span> ${p.pprice} </span>
						<span> ${p.pstate} </span>
						<span> ${p.pview} </span>
						<span> ${p.pdate} </span>
						<span> <button type="button"> ♡ </span>
					</div>`
			
		});
		document.querySelector('.productlistbox').innerHTML=html;
}

  var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.3218778 , 126.8308848), // 지도의 중심좌표 
        level : 6 // 지도의 확대 레벨 
 });
    
     // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 7 // 클러스터 할 최소 지도 레벨 
    });
 
    // 1. 제품목록 호출 [ 1. 현재 보이는 지도 조표내 포함된 제품만 2. ]
function getproductlist(동 , 서 , 남 , 북){	
	$.ajax({
		url : "/jspweb/product/info",
		method : "get" ,
		async : false,
		data : {"동" : 동 , "서" : 서 , "남" : 남 , "북" : 북},
		success:(r)=>{
		console.log(r)
		// ------------------- 사이드바 제품 목록 --------------------------
		productList = r;		// 제품목록 결과를 전역변수 담아주기 
		productlistprint(  );
		//--------------------- 마커 작업 -----------------------
        var markers = r.map((p)=>{
			console.log(p)
			
            let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng)
            });
            
            // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
				let html = '<button onclick="productlistprint()"> <== </button><h3>제품상세페이지</h3>';
				html +=`<div>
						<div> ${p.pname} </div>
						<div> ${p.pcomment} </div>
						<div> ${p.pprice} </div>
						<div> ${p.pstate} </div>
						<div> ${p.pview} </div>
						<div> ${p.pdate} </div>
						<div> <button type="button"> ♡ </div>
					</div>`
				document.querySelector('.productlistbox').innerHTML=html;
				}); // 클릭이벤트 end
	            
	            return marker;
	            
	        }); // map end
	
	        // 클러스터러에 마커들을 추가합니다
	        clusterer.addMarkers(markers);
	        //-----------------------------------------
	    } // success end
	}); // ajax end
} // m end
    
    
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
 
// -------------- 
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {

    
    var bounds = map.getBounds(); // 지도의 현재 영역을 얻어옵니다 
    
    
    var swLatLng = bounds.getSouthWest(); // 영역의 남서쪽 좌표를 얻어옵니다 
    
    
    var neLatLng = bounds.getNorthEast();  // 영역의 북동쪽 좌표를 얻어옵니다
    
    
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    getproductlist(동,서,남,북);
    console.log(북)
});
    
    
    	// $(r).map((인덱스,반복객체명)=>{})		실행문에서 return 값을 배열에 대입
		// r.map ((반복객체명,인덱스)=>{})		실행문에서 return 값을 배열에 대입
		// vs
		// .forEach((반복객체명,인덱스)=>{})	실행문에서 return X