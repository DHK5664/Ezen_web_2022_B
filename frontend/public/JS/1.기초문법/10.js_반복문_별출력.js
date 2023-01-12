/*	
	-출력
		콘솔출력 : console.log( )
		알람메시지: alert()
		html출력: 
		1. document.write()
		2. document.querySelector( ).innerHTML
		
	-입력
		1. 알람메시지 입력 : prompt()
		2. html입력 : document.querySelcector().value
*/
/*
let output = '' // 출력변수		- 공백을 만들어서 *을 넣던 뭘 넣던 글케 만들 공간을 만든다고 생각 만약 저기에 뭘 넣으면 같이 출력되어버림 
// 예시1) 입력받은 수 만큼 * 출력 	// 아무튼 그래서 맨 아래 console.log(output)도 위에 for문 등 공백인 output에 출력함으로써 보이게 함 그래서 공백을 넣음
let s1 = Number(prompt(' 예시 1 별 개수 ') )
for(let i = 1 ; i<=s1 ; i++ ){	//for s
	// i는 1부터 입력받은 수(s1) 까지 1씩 증가반복	
	output += '*'	// =대입[기존데이터 없어짐] vs += 더하고 대입 즉 누적대입[기존데이터에 추가]
}//for e
console.log(output)
*/
/*
	만약에 5를 입력했을때 s1=5
	output
	for(let i = 1 ; i<=s1 ; i++)
	
		i			조건[i<=s1]		실행문	   	   [output]				증감식
		i=1일때		1<=5		T	output += '*'	output = '*'		i++
		i=2일때 		2<=5		T	output += '*'	output = '**'		i++
		i=3일때		3<=5		T	output += '*'	output = '***'		i++
		i=4일때 		4<=5		T	output += '*'	output = '****'		i++
		i=5일때		5<=5		T	output += '*'	output = '*****'	i++
		i=6일때 		6<=5		F	실행 X


*/
/*
// 예시2) 입력받은 수 만큼 * 출력[ 3줄(3qotn)마다 줄 바꿈 ]
output = '' // 앞전에서 사용한 output 변수를 다시 ''[공백]으로 변경 + 위에서 한번 let을 써서 주민번호가 2개가 생길 수 없듯 걍 선언함
let s2 = Number(prompt('예시 2 별 개수'))
for(let i = 1 ; i <= s2 ; i++){//for s
	// 1. 별출력
	output += '*'
	// 2. 줄 바꿈출력
	if(i%3==0 ){output += '\n' }
}//for e
console.log(output)
*/
/*

	만약 5를 입력했을때 s2 = 5
	output = ''
	
	for(let i = 1 ; i<=s1 ; i++)
	
		i			조건[i<=s1]		실행문	   	    조건1[i%3==0]			 [output]			증감식
		i=1일때		1<=5		T	output += '*'	1%3 == 1			output = '*'			i++
		i=2일때 		2<=5		T	output += '*'	2%3 == 2			output = '**'			i++
		i=3일때		3<=5		T	output += '*'	3%3 == 0			output = '***\n'			i++
		i=4일때 		4<=5		T	output += '*'	4%3 == 0			output = '***\n*'			i++
		i=5일때		5<=5		T	output += '*'	5%3 == 0			output = '***\n**'		i++
		i=6일때 		6<=5		F	실행 X



*/
/*
1. 입력받은 '줄' 수 만큼 출력
예시) 5
					i[line](줄 개수랑 똑같이 늘어나므로)	s[star]
	*			   i=1								s = 1
	**			   i=2								s = 1 2	
	***			   i=3								s = 1 2 3
	****           i=4								s = 1 2 3 4
	*****		   i=5								s = 1 2 3 4 5
				- i는 1부터 입력받은 수 까지 1씩 증가 - for(let i = 1 ; i<=line ; i++)
				- s는 1부터 1까지
				- s는 1부터 2까지
				- s는 1부터 3까지
				- s는 1부터 4까지
				- s는 1부터 5까지
						- s는 1부터 i까지			- for (let s = 1 ; s<=i ; s++)

output = ''
let line1 = Number(prompt('문제 1 줄수'))
for(let i = 1 ; i <= line1 ; i++){//for s
	// 1. 별찍기
	for(let s = 1 ; s<=i ; s++){ //for s
		output += '*'
		}// for e
	output += '\n'// 2. 줄바꿈
}// for e
console.log(output)
*/
/*
2. 입력받은 줄 수 만큼 출력
예시)5
			i[line]				s[star]					[예시]
	*****   i=1					s= 1 2 3 4 5			입력받은 줄 수 - 현재줄수+1 : 5 - 1+1	5
	****	i=2					s= 1 2 3 4				입력받은 줄 수 - 현재줄수+1 : 5 - 2+1	4
	***		i=3					s= 1 2 3				입력받은 줄 수 - 현재줄수+1 : 5 - 3+1	3
	**		i=4					s= 1 2					입력받은 줄 수 - 현재줄수+1 : 5 - 4+1	2
	*		i=5					s= 1					입력받은 줄 수 - 현재줄수+1 : 5 - 5+1	1
	i는 1부터 입력받은 줄 까지 1씩증가 		= for(let i = 1 ; i<=line2 ; i++)
	s는 1부터 (입력받은 줄 수 - 현재줄수+1)까지 = for(let s = 1 ; s<= line2-i+1 ; s++) 
			s는 1부터 5까지
			s는 1부터 4까지
			s는 1부터 3까지
			s는 1부터 2까지
			s는 1부터 1까지
*/
/*
output = ''
let line2 = Number(prompt('문제 2 줄수'))
for(let i = 1 ; i <= line2 ; i++){//for s	:줄마다 별 / 줄바꿈 출력

	// 1. 별
	for(let s = 1 ; s<= line2-i+1 ; s++){//for s
	output += '*'
	
		
	}//for e
	output += '\n'
	// 2. 줄바꿈
}// for e
console.log(output)
*/
/*	
3. 입력받은 줄 수 만큼 출력
예시)5
					i[line]			b[공백]:문제2			s[별]:문제1
			  *		i=1				b= 1 2 3 4			s= 1
             **		i=2				b= 1 2 3			s= 1 2
            ***		i=3				b= 1 2				s= 1 2 3
           ****		i=4				b= 1				s= 1 2 3 4
          *****		i=5				b= 					s= 1 2 3 4 5
          		
          			i는 1부터 입력받은 줄 까지 1씩 증가				=for(let i = 1 ; i<=line3 ; i++)
          			b는 1부터 (입력받은 줄 - 현재 줄 수) 까지 1씩증가	=for(let b = 1 ; b<=line3-1 ; b++)
					s는 1부터 현재줄 수 까지 1씩 증가					=for(let s = 1 ; s<=i ; s++)
				!!! 줄마다 공백과 별과 줄바꿈 출력	
					
*/
/*
output=''
let line3 = Number(prompt('문제 3 줄수'))
for(i=1 ; i<=line3 ; i++){//for s
	//1. 공백 출력
	for(let b=1 ; b<=line3-i ; b++ ){
		output += ' '
		
	}
	//2. 별 출력
	for(let s=1 ; s<=i ; s++){
		output+='*'
	}
	//3. 줄바꿈
	output += '\n'
}//for e
console.log(output)
*/

/*4.입력받은 줄 수[line] 만큼 출력 예시 )5
				i[line]		  b[공백]:2		s[별]

        *****	i = 1			b=			s= 1 2 3 4 5
		 ****	i = 2			b=1			s= 1 2 3 4
		  ***   i = 3			b=1 2		s= 1 2 3
		   **	i = 4			b=1 2 3		s= 1 2
		    *	i = 5			b=1 2 3 4	s= 1
		    
		    i는 1부터 입력받은 줄 까지 1씩 증가				=for(let i = 1 ; i<=line4 ; i++)
		    b는 1부터 (현재줄수-1)까지 1씩 증가 				=for(let b = 1 ; b<=i-1 ; b++)
		    s는 1부터 (입력받은 줄 수 - 현재줄수+1)까지 1씩 증가	=for(let s = 1 ; s<=line4-i+1 ; s++)
		    
*/
/*output=''
let line4 = Number(prompt('문제 4 줄수'))
for(let i = 1 ; i<=line4 ; i++){//for s
	//1. 
	for(let b= 1; b<=i-1 ; b++){//for s
		output += ' '
	}//for e
	//2.
	for(let s = 1 ; s<=line4-i+1 ; s++){//for s
		output += '*'
	}//for e
	//3.
	output+='\n'
	
}//for e
console.log(output)
*/
/* 만약에 줄 수가 3을 입력했으면 line4 = 3
	i= 1 일때
	
		b = 1일때 	b<=i-1	1<=1-1			F
		
		s = 1일때	s<=line4-i+1  1<=3-1+1  T		output = '*'
		s = 2일때	s<=line4-i+1  2<=3-1+1  T		output = '**'
		s = 3일때	s<=line4-i+1  3<=3-1+1  T		output = '***'
		
			output+= '\n'							output+= '***\n'
		
	i= 2 일때
	
		b = 1일때   b<=i-1	1<=2-1			T		output = '***\n '
		b = 2일때   b<=i-1	2<=2-1			F		
	
		s = 1일때	s<=line4-i+1  1<=3-2+1  T		output = '***\n *'
		s = 2일때	s<=line4-i+1  2<=3-2+1  T		output = '***\n **'
		s = 3일때	s<=line4-i+1  3<=3-2+1  F		
	
			output+= '\n'							output = '***\n **\n'
	
	i= 3 일때
	
		b = 1일때   b<=i-1	1<=3-1			T		output = '***\n **\n '
		b = 2일때   b<=i-1	2<=3-1			T		output = '***\n **\n  '
		b = 3일때   b<=i-1	2<=3-1			F		
		
		s = 1일때	s<=line4-i+1  1<=3-2+1  T		output = '***\n**\n'
		s = 2일때	s<=line4-i+1  2<=3-2+1  F
	
/*5.입력받은 줄 수[line] 만큼 출력 예시 )5

							i[line]				b[공백]				s[별]
			*				i=1					b=1 2 3 4			s= 1
		   ***				i=2					b=1 2 3				s= 1 2 3
		  *****				i=3					b=1 2				s= 1 2 3 4 5
		 *******			i=4					b=1 				s= 1 2 3 4 5 6 7		--> 가운데를 기준으로 반으로 나누면 삼각형 2개가 나오는데 
		*********			i=5					b=					s= 1 2 3 4 5 6 7 8 9		다 위에서 봤던 s=1; s<=i ; s++삼각형이다
				-i는 1부터 입력받은 줄 수 까지 1씩 증가 			= for(let i = 1 ; i<=line5 ; i++)	그래서 *2를 해주고 가운데 1개짜리들을 빼주면 된다.
				-b는 1부터 (입력받은 줄 수 - 현재줄수) 까지 1씩증가 	= for(let b = 1 ; b<=line5-i ; b++)
				-s는 1부터 (현재줄수*2-1)	까지 1씩 증가			= for(let s = 1 ; s<=i*2-1 ; s++)
					1부터 i까지		1부터 i*2까지		i부터 i*2-1까지
					1부터 1까지		1부터  2까지		1부터 1까지
					1부터 2까지		1부터  4까지		1부터 3까지
					1부터 3까지		1부터  6까지		1부터 5까지
					1부터 4까지		1부터  8까지		1부터 7까지
					1부터 5까지		1부터 10까지		1부터 9까지
*/
/*
output = ''
let line5 = Number(prompt('문제 5 줄 수'))
for(let i = 1 ; i<=line5 ; i++){//for s
	
	//1. 공백
	for(let b = 1 ; b<=line5-i ; b++){//for s
		output +=' '
	}//for e
	//2. 별
	for(let s = 1 ; s<=i*2-1 ; s++){//for s
		output += '*'
	}// for e
	//3. 줄바꿈
	
	
	output += '\n'
}//for e
console.log(output)
*/
/*6.입력받은 줄 수[line] 만큼 출력 예시 )7

         *     *
          *   *
		   * *
            *
           * *
		  *   *
		 *     *
*/
output=''
let line7 = Number(prompt('과제 1 줄 수'))// 다이아를 4등분을 했는데
for(let i=1 ; i<=line7 ; i++){ // i가 1부터 과제 1의 줄 수까지 1씩 증가하면서 반복 (줄 개수)
	for(let b = 1 ; b<=line7-i ; b++){// b는 공백이고 위쪽 피라미드 모양 특성상 공백의 개수가 4 3 2 1 일케 대는데 
		output+=' '						//만약 5를 line7에 대입했다고 가정할 시 처음은 5-1=4 즉 T 실행 두번째는 5-2=3 즉 1<=3 T 이런식으로 돼서 공백이 4개 3개 2개 1개 0개가 된다.
	}
	for(let s1 = 1; s1<=i ; s1++){ //위에서 왼쪽 삼각형모양으로 별을 찍었다 근데 별의 갯수가 1 2 3 4 5 일케 증가해야 하므로 줄 수에 맞춰서 s<=i로 적었다.
		
		output +='*'
	}
	for(let s2 = 1; s2<=i-1 ; s2++)	// 이번엔 위에서 오른쪽 삼각형인데 왼쪽에 비해서 1칸씩 적어져서 첫줄 0개 두번째줄 1 일케 대야해서 바로 위의 for문에서 -1을 추가하였다. 
		
		output +='*'
	
	output += '\n'
}
//위쪽 완성

for(let i=1 ; i<=line7-1 ; i++){	// 위에서 반을 또 나눴듯 아래도 반을 나눴는데 우리는 한칸 적은 마름모를 만들어서 위에서 -1을 추가했다
	
	for(let b = 1; b<=i; b++){		// 공백의 모양이 위의 s1 for문의 삼각형의 모양과 같으므로 이렇게 하였다.
		output +=' '
	}
	for(let s1 = 1 ; s1<=line7-i ; s1++){	// 반대로 별의 모양이 위의 공백 for문과 같으므로 이렇게 하였다.
		output += '*'
	}
	
	for(let s2=1 ; s2<=line7-i-1 ; s2++){	// 위의 s2for문과 같은 이유로 이렇게 하였다.
		
		output += '*'
	}	
	output+= '\n'
	
}
console.log(output)









