
if(memberInfo.mid == null){
	alert('로그인 후 이용 가능합니다.')
	location.href="/jspweb/member/login.jsp"}

// 전역변수
let plat = 0;
let plng = 0;

// 제품 등록 함수
function onwrite(){
	
	// 1. 폼 객체
	let writeForm = document.querySelectorAll('.writeForm')[0];
	// 2. 폼데이터 객체 선언
	let writeFormData = new FormData(writeForm);
	// 3. 좌표[위도/경도]추가
	//폼데이터 객체에 필드 추가 [ set 필드명 중복 불가능 ]
	writeFormData.set("plat" , plat);
	writeFormData.set("plng" , plng);
	
	if(plat == 0 || plng == 0){alert('위치 선택후 등록해주세요'); return;}
	
	if(fileList.length < 1 ){alert('1개 이상의 이미지 등록하시게.'); return; }
	
	// 폼에 첨부파일 등록
	fileList.forEach((f)=>{
		// 배열에 존재하는 파일들을 하나씩 폼에 등록
		// [ append 필드명 중복 가능 ]
	writeFormData.append( "fileList" , f );
	})
	
	$.ajax({
		url:"/jspweb/product/info",
		method:"post",
		data:writeFormData,
		contentType : false ,
		processData : false ,
		success:(r)=>{
			console.log(r)
			if(r=='true'){
				alert('등록성공')
				location.href="/jspweb/index.jsp"
			}else{
				alert('등록실패')
			}
		}
	})
}

// -------------------------- 카카오 지도를 표시할 div 객체 -------------------------- //  
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.3218778,126.8308848), // 처음에 찍히는 지도의 중심좌표.
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// -------------------------- 지도를 클릭한 위치에 표출할 마커입니다 -------------------------- //
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// -------------------------- 지도에 클릭 이벤트를 등록합니다 -------------------------- //
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
    
    var latlng = mouseEvent.latLng;    // 클릭한 위도, 경도 정보를 가져옵니다  
    
    marker.setPosition(latlng);    // 마커 위치를 클릭한 위치로 옮깁니다
    plat =latlng.getLat();	console.log("위도 :" +latlng.getLat())
    plng =latlng.getLng();    console.log("경도 :" +latlng.getLng())
});

// ----------------------- 드래그앤 드랍 구현 ----------------------- //
// 1. 드래그앤 드랍할 구역 [DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');
// * 해당 구역에 드래그된 파일들을 저장하는 리스트/배열
let fileList = [];
// 2. 해당 구역에 이벤트 등록
	// 1. dragenter
fileDrop.addEventListener("dragenter" , (e)=>{
	console.log('드래그 요소가 해당 구역에 닿았을때')
	e.preventDefault(); // 고유/기존[브라우저 내] 이벤트 제거
})
	// 2. dragover
fileDrop.addEventListener("dragover",(e)=>{
	console.log('드래그 요소가 해당 구역에 위치하고 있을때')
	e.preventDefault(); // 고유/기존[브라우저 내] 이벤트 제거
	fileDrop.style.backgroundColor = "#e8e8e8";
})
	// 3. dragleave
fileDrop.addEventListener("dragleave" , (e)=>{
	console.log('드래그 요소가 해당 구역에서 나갔을때')
	e.preventDefault(); // 고유/기존[브라우저 내] 이벤트 제거
	fileDrop.style.backgroundColor = "#ffffff";
})
	// 4. drop
fileDrop.addEventListener("drop" , (e)=>{
	console.log('드래그 요소가 해당 구역에 드랍 되었을때')
	// 문제점 : 브라우저 영역 에 드랍했을때 해당 페이지가 열림 [브라우저 이벤트가 먼저 실행]
	e.preventDefault(); // 고유/기존[브라우저 내] 이벤트 제거
	// 1. 드랍된 파일[dataTransfer]을 호출
	let files = e.dataTransfer.files // forEach 사용불가
	console.log(files);
	for(let i = 0 ; i<files.length; i++){
		console.log(files[i])
		if(files[i]!=null && files[i] != undefined){// 비어있지 않고 정의되어 있으면
			fileList.push(files[i]); // 각 파일들을 하나씩 배열에 저장
		}
	} // for end
	fileDrop.style.backgroundColor = "#ffffff";
	printfiles(); // 파일목록 출력
	console.log(fileList)
})// event end
// 3. 해당 구역에 드랍된 파일 목록 출력
function printfiles(){
	let html = '';
	fileList.forEach((f,i)=>{
		let fname = f.name;	// 파일명 호출
			console.log(f.name);
		let fsize = (f.size / 1024 ).toFixed(1) ;	// 파일 용량[바이트 --> MB 변경]
			// toFixed(표시할소수자리수)
			console.log(f.size);
		
		html +=`<div>
					<span> ${fname} </span>
					<span> ${fsize}KB </span>
					<span> <button type="button" onclick="filedelete(${i})"> 삭제 </button> </span>
				</div>
				`
	})
	fileDrop.innerHTML = html;	
}// end
// 4. 드래그앤드랍된 파일 목록에 특정 파일 제거
function filedelete(i){fileList.splice(i,1); printfiles();}



















