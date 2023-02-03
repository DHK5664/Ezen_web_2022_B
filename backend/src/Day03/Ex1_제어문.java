package Day03;

import java.util.Random;

public class Ex1_제어문 { // c s

	public static void main(String[] args) { // m s
		
		// IF 형태
			// 1. IF(조건식) 실행문;
			// 2. IF(조건식) {실행문; 실행문; }
			/* 3.
			   if(조건식){
					true
				}else{
					false
				}
			 */
		
			/*
			 
			 	4. 
			 	if( 조건식1 ) {
			 		true1
			 	}else if( 조건식2 ){
			 		true2
			 	}else if( 조건식3 ){		-----> 이 중 하나만 실행됨
			 		true3
			 	}else{
			 		false
			 	}
			 
			 */
		
			  /*
			   	5. if 중첩 
			 	if( 조건식 ) {
			 		if( 조건식 ) {
			 		
			 		}else{
			 		
			 		}
			 	}else{
			 	
			 	}
			   
			   */
		// 1. [p.111]
		int score = 93;	// 1. 변수선언  (초기값 설정)
		
		if( score >= 90 ) { // if s
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}// if e
		if( score < 90 )  // if s
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");			//!!!
		 // if e
		
		// 2. [p.113]
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");		
		}else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		// 3. [p.114]
		if(score >= 90) {
			System.out.println("점수가 100~90 입니다.");
			System.out.println("등급은 A입니다.");
		}else if(score >= 80) {
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");			// ------> true 1개 즉 얘가 더 빠름
		}else if(score >= 70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		}else{
			System.out.println("점수가 70 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		
		if(score >= 90) {
			System.out.println("점수가 100~90 입니다.");
			System.out.println("등급은 A입니다.");
		}if(score >= 80) {
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");			// ------> true 여러개(if 하나당 구역 하나로 취급하는데 얘는 구역이 4개인 샘)
		}if(score >= 70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		}if(score < 70){
			System.out.println("점수가 70 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		
		
		// * [ p. 116 ]
		System.out.println(Math.random() );	//---> 0~1사이 실수 난수
		System.out.println(Math.random()+1 );	//---> 1~2 사이 실수
		System.out.println( (int)Math.random()+1 );	//---> 1~2 사이 정수
		System.out.println( (int)(Math.random()*6)+1 );	//---> 1~6 사이 정수
		
		/*
			Math : 수학관련 메소드를 제공하는 클래스
					Math.random()
			Random : 난수 관련 메소드를 제공하는 클래스
		*/
		Random random = new Random();
		System.out.println(random.nextInt());	// int가 표현 할 수 있는 범위 내 난수 생성
		System.out.println(random.nextInt(3) );	//	0 ~ 2
		System.out.println(random.nextInt(6)+1 );	// 	1 ~ 6
		char c1 = (char)(random.nextInt(26)  +97 );	//	97~122	소문자 a~z
		System.out.println(c1);
		
		int num = (int)(Math.random()*6) + 1;		// 주사위 번호 1개 뽑기( 강제 형변환으로 인해 int가 정수라서 소수점 X)
		
		if(num==1) {
			System.out.println("1번이 나왔습니다.");
		}else if(num==2) {
			System.out.println("2번이 나왔습니다. ");
		}else if(num==3) {
			System.out.println("3번이 나왔습니다. ");
		}else if(num==4) {
			System.out.println("4번이 나왔습니다. ");
		}else if(num==5) {
			System.out.println("5번이 나왔습니다. ");
		}else {System.out.println("6번이 나왔습니다.");}
		
		// 5. [ p. 117 ]
		int score2 = (int)(Math.random()*20) +81;	// 81 ~ 100
		System.out.println("점수 : " +score2 );
		
		String grade;
		
		if (score2 >=90 ) {if( score2 >= 95 ) grade = "A+"; else{grade ="A";} }
		else {if (score2>=85) {grade = "B+";} else {grade="B";} }
		// if(조건식){if(조건식){}else{} }
		// else{if(조건식){} else{}}	
		System.out.println("학점 : " + grade);
		
	} // m e
	
} // c e




















