package Day19.Ex4;

public class Calculator { // 계산기 클래스
	private int memory;	// 필드
	public int getMemory() {return memory;}// getter
	
	public synchronized void setMemory(int memory) {// setter
		this.memory = memory;
		try {Thread.sleep(2000); // 해당 메소드 작업시간 추가
		}catch (Exception e) {}
		System.out.println(this.memory);
	}
	
	
}
