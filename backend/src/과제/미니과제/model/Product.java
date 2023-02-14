package 과제.미니과제.model;
/*
	제품 클래스 : Product
      String name         -    제품 이름
      String content         -   제품 설명
      int price            -   제품 가격
      Member member         -   올린 사람
*/
public class Product {
	// 1. 필드
	private String name;
	private String content;
	private int price;
	private Member member;
	
	// 2. 생성자
	public Product() {}

	public Product(String name, String content, int price, Member member) {
		super();
		this.name = name;
		this.content = content;
		this.price = price;
		this.member = member;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Product [name=" + name + ", content=" + content + ", price=" + price + ", member=" + member + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
