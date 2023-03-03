package practice.day02;

public class Q2Dto {
	private String Qdata1;
	private String Qdata2;
	private double Qdata3;
	private int Qdata4;
	private String Qdata5;
	private String Qdata6;
	private boolean Qdata7;
	private String Qdata8;
	private String Qdata9;
	
	public Q2Dto() {}

	public Q2Dto(String qdata1, String qdata2, double qdata3, int qdata4, String qdata5, String qdata6, boolean qdata7,
			String qdata8, String qdata9) {
		super();
		Qdata1 = qdata1;
		Qdata2 = qdata2;
		Qdata3 = qdata3;
		Qdata4 = qdata4;
		Qdata5 = qdata5;
		Qdata6 = qdata6;
		Qdata7 = qdata7;
		Qdata8 = qdata8;
		Qdata9 = qdata9;
	}

	
	
	@Override
	public String toString() {
		return "Q2Dto [Qdata1=" + Qdata1 + ", Qdata2=" + Qdata2 + ", Qdata3=" + Qdata3 + ", Qdata4=" + Qdata4
				+ ", Qdata5=" + Qdata5 + ", Qdata6=" + Qdata6 + ", Qdata7=" + Qdata7 + ", Qdata8=" + Qdata8
				+ ", Qdata9=" + Qdata9 + "]";
	}

	public String getQdata1() {
		return Qdata1;
	}

	public void setQdata1(String qdata1) {
		Qdata1 = qdata1;
	}

	public String getQdata2() {
		return Qdata2;
	}

	public void setQdata2(String qdata2) {
		Qdata2 = qdata2;
	}

	public double getQdata3() {
		return Qdata3;
	}

	public void setQdata3(double qdata3) {
		Qdata3 = qdata3;
	}

	public int getQdata4() {
		return Qdata4;
	}

	public void setQdata4(int qdata4) {
		Qdata4 = qdata4;
	}

	public String getQdata5() {
		return Qdata5;
	}

	public void setQdata5(String qdata5) {
		Qdata5 = qdata5;
	}

	public String getQdata6() {
		return Qdata6;
	}

	public void setQdata6(String qdata6) {
		Qdata6 = qdata6;
	}

	public boolean getQdata7() {
		return Qdata7;
	}

	public void setQdata7(boolean qdata7) {
		Qdata7 = qdata7;
	}

	public String getQdata8() {
		return Qdata8;
	}

	public void setQdata8(String qdata8) {
		Qdata8 = qdata8;
	}

	public String getQdata9() {
		return Qdata9;
	}

	public void setQdata9(String qdata9) {
		Qdata9 = qdata9;
	}
	
	
}
