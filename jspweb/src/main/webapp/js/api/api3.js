//------------------------ 지도 옵션 및 생성 ----------------------------- //
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778,126.8308848), // 처음에 찍히는 지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴



//------------------------ 마커 이미지 변경 ----------------------------- //
var imageSrc = '/jspweb/img/pngegg.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(55, 60), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
    


    
//------------------------ 마커 1개 생성 ----------------------------- //
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() , 
    image: markerImage	// 해당 마커객체의 이미지객체 대입
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//------------------------ 지도 클릭 이벤트 ----------------------------- //
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});

let markers = [];



// 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 6 // 클러스터 할 최소 지도 레벨 
    });

$.ajax({
	url:"https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=300&returnType=json&serviceKey=NRQcpmSIDAXX6nXAgxoMBrAIBSh0dS19ZpH0BEs4gK942%2BEMswPGduxk575l4vUtjoRQHILalRyMKHITTU5wUw%3D%3D",
	method : "get",
	aync : false,
	success :(r)=>{
		console.log(r)
		var markers = $(r.data).map(function(i, o) {
			console.log(o)
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(o.주소, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        let marker= new kakao.maps.Marker({
			            position: coords,
			            image:markerImage
			        });
			        kakao.maps.event.addListener(marker, 'click', function() {
				
						// 모달에 정보 담기
						document.querySelector('.modal_title').innerHTML = o.약국명;
						document.querySelector('.modal_title').style.fontSize='15px';
						document.querySelector('.modal_content').innerHTML=o.주소;
				    	// 모달 띄우기
				    	openModal();
					});
			        clusterer.addMarker(marker);
			             
			    } 
			});
			// 클릭이벤트
			
		})
			// 클러스터러에 마커들/배열 을 추가합니다
	}

})






































