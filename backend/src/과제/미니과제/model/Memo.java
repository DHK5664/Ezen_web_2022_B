package 과제.미니과제.model;
/*
   쪽지 클래스 : Memo 
      String title         -   쪽지 제목
      String content         -   쪽지 내용
      Product product         -   상품 내용
      Member member1         -   보낸 사람
      Member member2         -   받는 사람
*/
public class Memo {
	// 1. 필드
	private String title;
	private String content;
	private Product product;
	private Member member1;
	private Member member2;
	
	// 2. 생성자
	public Memo() {}

	public Memo(String title, String content, Product product, Member member1, Member member2) {
		super();
		this.title = title;
		this.content = content;
		this.product = product;
		this.member1 = member1;
		this.member2 = member2;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Memo [title=" + title + ", content=" + content + ", product=" + product + ", member1=" + member1
				+ ", member2=" + member2 + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember1() {
		return member1;
	}

	public void setMember1(Member member1) {
		this.member1 = member1;
	}

	public Member getMember2() {
		return member2;
	}

	public void setMember2(Member member2) {
		this.member2 = member2;
	}
	
}
