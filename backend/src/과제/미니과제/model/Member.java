package 과제.미니과제.model;

import java.util.ArrayList;
/*
 회원 클래스 : Member
      String id            -   회원 아이디
      String pw            -   회원 비밀번호
      String name         -   회원 이름
      String phone         -   회원 핸드폰 번호
      ArrayList<Product> product      -   본인이 올린 제품리스트
      ArrayList<Memo> memo      -   본인에게 온 쪽지
      ArrayList<Memo> memo2      -   본인에게 보낸 쪽지
*/
public class Member {
	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	private ArrayList<Product> productList; 
	private ArrayList<Memo> memoList ;
	private ArrayList<Memo> memo2List;
	
	// 생성자
	public Member() {}

	public Member(String id, String pw, String name, String phone, ArrayList<Product> productList,
			ArrayList<Memo> memoList, ArrayList<Memo> memo2List) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.productList = productList;
		this.memoList = memoList;
		this.memo2List = memo2List;
	}
	// 3. 메소드

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", productList="
				+ productList + ", memoList=" + memoList + ", memo2List=" + memo2List + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public ArrayList<Memo> getMemoList() {
		return memoList;
	}

	public void setMemoList(ArrayList<Memo> memoList) {
		this.memoList = memoList;
	}

	public ArrayList<Memo> getMemo2List() {
		return memo2List;
	}

	public void setMemo2List(ArrayList<Memo> memo2List) {
		this.memo2List = memo2List;
	}
	
}






























