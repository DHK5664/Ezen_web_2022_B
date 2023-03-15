console.log('js 실행')

getBoard();
function getBoard(){console.log('함수실행');

	let bno = document.querySelector('.bno').innerHTML;
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
						${r.bup} /
						${r.bdown} /`
			
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			if(r.bfile == null){ // 첨부파일 없을때
				document.querySelector('.bfile').innerHTML = '첨부파일없음';
			}else{ // 첨부파일 있을때
				html = `${r.bfile} <button onclick="bdownload( '${r.bfile}' )" type="button"> 다운로드 </button>`
				document.querySelector('.bfile').innerHTML = html;	
			}			
		}
	}) // ajax end
}// m end
// 2. 다운로드 [ 다운로드할 파일명 인수로 받기 ]
function bdownload(bfile){
	console.log('선택한 파일명 : ' + bfile);
	$.ajax({
		url :"/jspweb/filedownload",
		method : "get",
		data : {"bfile" : bfile},
		success : (r)=>{
			console.log('통신');	console.log(r);
		}
	}) // ajax end
} // m end

/*
	1. onclick =  JS코드 작성구역
		1. bdownload( 짱구4.jpg ) 	: .파일확장자 구분기호가 아닌 .접근연산자로 사용됨
		2. bdownload( '짱구4.jpg' )	: .접근연산자를 파일확장자 구분기호로 사용할 수 있음
	<button onclick="bdownload( ${r.bfile} )" type="button">
		<button onclick="bdownload( 짱구4.jpg )" type="button">
	<button onclick="bdownload( '${r.bfile}' )" type="button">
	<button onclick="bdownload( '짱구4.jpg' )" type="button">
*/



















