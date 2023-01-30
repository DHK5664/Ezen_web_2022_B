console.log('글쓰기 js실행')

$(document).ready(function() {
  $('#summernote').summernote( {height : 300 , lang: 'ko-KR' } );
});

/*
	썸머노트 기능속성
	$('#summernote').summernote( {속성명 : 값 , 속성명 : 값 } );
		1. height : 		: 높이
		2. lang: 'ko-KR' 	: 한글버전[<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js">]
*/