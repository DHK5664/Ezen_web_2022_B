
// 예1) 1부터 10이하까지 1씩 증가하면서 반복 [한 줄씩 출력] 
console.log('----------예1----------')
for (let i = 1 ; i <=10 ; i++ ){ // for s
	console.log(i)
}	// for e

// 예2 i는 1부터 10 이하까지 1씩 증가 반복[한 줄에 모두 출력]
console.log('----------예2----------')
let output = ' '// 공백을 넣어서 문자 변수로 선언 ( 깡통 )
for(let i = 1 ; i<=10 ; i++){ // for s
	output += i+"\t"; 	// vs output = output + i	//	 누적 기록
}// for e
console.log( output )

// 예3) i는 1부터 10 이하까지 1씩 증가 반복[ html 출력 ]
console.log('----------예3----------')
output = ''				// 위에서 사용했기 때문에 지우고 ''으로 변경
for(let i = 1 ; i<= 10 ; i++){// for s
	output += i+ "\t"
}// for e
document.querySelector('body').innerHTML = output

// 예4) i는 1부터 10 이하까지 1씩 증가 반복 누계
console.log('----------예4----------')
let sum = 0;
for(let i = 1 ; i<=10 ; i++){ 
	console.log( "i = " + i + "\t"+i+"<=10 " + (i<=10 ) +"\t"+ sum+"+="+i +"\t i++" ) 
	sum += i }
console.log( sum )
/* 초기값 : i= 1 sum = 0
for 시작 	
										기존 sum+=현재의 i값
													sum = 0
		i				조건				실행			<누계>	증감식
		i = 1 일때  		1<=10 T			sum+=1		sum=1	i++
		i = 2 일때		2<=10 T			1+=2		sum=3   i++
		i = 3 일때		3<=10 T			3+=3		sum=6	i++
		i = 4 일때  		4<=10 T			6+=4		sum=10	i++
		i = 5 일때		5<=10 T			10+=5		sum=15  i++
		i = 6 일때		6<=10 T			15+=6		sum=21	i++
		i = 7 일때  		7<=10 T			21+=7		sum=28	i++
		i = 8 일때		8<=10 T			28+=8		sum=36  i++
		i = 9 일때		9<=10 T			36+=9		sum=45	i++
		i = 10 일때		10<=10T			45+=10		sum=55	i++
		i = 11 일때		11<=10F			for end
*/
// 예5) 0부터 100까지 7배수 누적합계
console.log('----------예5----------')
// 1.[i+=7]
sum = 0;
for(let i = 0; i <= 100 ; i+=7 ){ 
	console.log( "i = " + i + "\t"+i+"<=100 " + (i<=100 ) +"\t"+ sum+"+="+i +"\t i++" ) 
	sum += i}
console.log(sum)
//2. if(i%7==0)
sum = 0;
for(let i = 1 ; i<=100 ; i++) { //for s
	if(i %7 == 0) {//if s
		sum+=i
		}// if e
	}// for e
console.log(sum)

// 예6) (2단 구구단)	[단 : 2 		곱 : 변수]
console.log('----------예6----------')

output = ''

for (let 곱 = 1 ; 곱 <= 9 ; 곱++){	// for start
	// 곱은 1부터 9까지 1씩 증가하면서 반복처리
	
	console.log(" 2 * "+ 곱 + " = " + (2*곱) );	// 변수는 문자처리 X
				//'문자' + 변수 + '문자' + (계산식)  ※ 큰따옴포 작은 따옴표 똑같음
	output += " 2 * "+ 곱 + " = " + (2*곱) +'<br/>'		// 누계
}//for end

document.querySelector('body').innerHTML=output

// 예7) 구구단		[단 : 2~9변수 곱 : 1~9 변수]
//1. 단 만들기
	for(let 단 = 2 ; 단 <= 9 ; 단++){
		//단은 2부터 9까지 1씩 증가 반복처리를 하고있다.
		console.log(단)
	}
//2. 곱 만들기
	for(let 곱 = 1 ; 곱<=9 ; 곱++ ){
		//곱은 1부터 9까지 1씩 증가 반복처리를 하고있다.
		console.log(곱)
	}

//3. 단 / 곱 코드 합치기 단 안에 곱이 들와야함			['단'이 한바퀴 돌때 '곱'은 9바퀴를 돈다] 
	for(let 단 = 2 ; 단 <= 9 ; 단++){
		console.log(단)
		for(let 곱 = 1 ; 곱<=9 ; 곱++ ){
		console.log(곱)
	}
	}
//4. 출력
	for(let 단 = 2 ; 단 <= 9 ; 단++){// for 1 s
	
		for(let 곱 = 1 ; 곱<=9 ; 곱++ ){// for 2 s
			console.log(단 +' * ' + 곱 + ' = ' + (단*곱) )
	}// for 2 e
	}// for 1 e





















