let monsterList = [
	{img:'주황버섯.gif' , hp : 300 , left : 910 , exp: 50},
	{img:'엉망진창버섯.gif' , hp : 400 , left : 910 , exp: 150},
	{img:'세보이는버섯1.gif' , hp : 500 , left : 910 , exp: 300},
	{img:'' ,hp:0 , left:0 , exp : 0}
]
// 1. userbox / logbox / monbox Dom객체 가져오기
let userbox = document.querySelector('.userbox')
let wrap = document.querySelector('.wrap')
let monbox = document.querySelector('.monbox')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')
let uHP	= document.querySelector('#u_HP')
let mHP	= document.querySelector('#m_HP')


// * userbox [기본/처음] 위치 좌표
let u_left = 10;		// 유저
let attlange = 0;
let userHp = 300;
 
let mindex = 0;		// 처음에 0번째 인덱스부터 시작
let m_left = 0;		// 몬스터
let monsterHp = 0;
몬스터교체(mindex);

function 몬스터교체( i ){
	monbox.style.backgroundImage = `url("img/${ monsterList[i].img }")`		// 이동모션
	 m_left = monsterList[i].left;		// 몬스터
 	monsterHp = monsterList[i].hp;
}

function attack(){
	let rand = parseInt(Math.random()*20+1);
	attlange = (m_left-u_left)
	if(0<attlange && attlange<80)
	{
		console.log('공격범위');
		monsterHp -= rand;
		if(monsterHp < 0 ) {monsterHp = 0; }
		mHP.style.width = `${ monsterHp }px`
		mDead()
	}
	
	
}

function mAttack(){
	let mLength=0;
	let rand2 = parseInt(Math.random()*10+1);
	mLength=(m_left-u_left)
	if(mLength<35 && mLength>-35){
		console.log('몬스터의 공격범위');
		userHp -= rand2;
		if( userHp < 0 ) { userHp = 0; }
		uHP.style.width =`${userHp}px`
		uDead()
	}
}

function uDead(){
	if(userHp==0){document.querySelector('.userbox').style.display='none';  wrap.innerHTML='GAMEOVER'}
}

function mDead(){
	if(monsterHp==0){  mindex++; 몬스터교체(mindex); }
	if(mindex==3){wrap.innerHTML='CLEAR';}
}

// 2. 문서 안에서 키 입력 이벤트
document.addEventListener('keydown' , (e)=>{
	
	let key = e.keyCode;	// 입력된 키 코드를 변수에 저장
	if( key == 37 ){ // 왼쪽키
		u_left -= 10;		// 왼쪽 좌표 -10 차감
		u_left = u_left < 0 ? 0 : u_left; // 만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 적용
	}else if( key == 39 ){	// 오른쪽키
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left;
		userbox.style.backgroundImage = `url("img/이동모션1.png")`		// 이동모션
		userbox.style.backgrounSize=`110%`;
	}else if( key == 65 ){	// a 키  -> 공격
		userbox.style.backgroundImage = `url("img/캐릭터3_공격.png")`		// 공격모션
		attack();
	}
		userbox.style.left = `${u_left}px`		//*  키 입력후에 css : left 변경
		// 현재 좌표를 로그에 출력
		logbox.innerHTML = `<div> 유저 좌표 : ${ u_left }</div>`
		
} )


//2. 문서 안에서 키 떼었을때 이벤트	keyup
document.addEventListener('keyup' , (e)=>{
	userbox.style.backgroundImage = `url("img/캐릭터1.png")`
})

// 3. 몬스터 이동 난수[랜덤 -> 1초]
	// 특정 시간마다 함수 실행 해주는 함수 : setInterval( ()=>{} , 밀리초(1000/1초) )

let 몬스터이동 = setInterval(mon_moving , 2000 );
let 몬스터공격 = setInterval(mAttack , 100 );

function mon_moving(){
	// 1. 난수 +-10
	let rand = parseInt(Math.random()*100+1);	//  1~100사이의 실수	// 이동 거리
	let rand2 = parseInt(Math.random()*2);		// 0 또는 1			// 이동 방향
	if( rand2 == 1) m_left += rand
	else m_left -= rand

	// 2. 게임화면 고정
	if(m_left < 0) m_left=0;
	if(m_left > 910 ) m_left=910;
	// 3. 몬스터 이동
	monbox.style.left=`${m_left}px`
	//* 현재 좌표를 로그에 출력
	logbox2.innerHTML = `<div> 몬스터 좌표 : ${m_left}</div>`
}


/*
	함수형태
		1. 일반함수 : function 함수명(){}		--> 1 , 4 이름이 있으므로 재호출 가능
		2. 익명함수 : function (){}
		3. 람다식함수 : ( )=>{ }
		4. 변수함수 : let 변수명 = () => {}
	 Math.random()
	 	 Math.random()	: 0~1 사이의 실수
	 	 Math.random()*10	: 0~10사이의 실수 (10 미만)

*/




























