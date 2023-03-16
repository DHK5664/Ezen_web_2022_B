package model.dto;

import java.util.ArrayList;

public class PageDto {

	private int page;		// 현재 페이지
	private int listsize;	// 페이지당 표시할 게시글 개수
	private int startrow;	// 현재 페이지에서 시작되는 게시물번호
	private int totalsize;	// 총 게시물 수
	private int totalpage;	// 총 페이지 수
	private int btnsize;	// 페이지별 최대 페이징버튼수
	private int startbtn;	// 페이지별 시작 페이징버튼 번호
	private int endbtn;		// 페이지별 끝 페이징버튼의 번호
	// !! : 게시물 목록
	ArrayList<BoardDto> boardlist;	// 출력할 데이터[게시물] 리스트
	
	public PageDto() {
		// TODO Auto-generated constructor stub
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, int btnsize, int startbtn,
			int endbtn, ArrayList<BoardDto> boardlist) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnsize = btnsize;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardlist = boardlist;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBtnsize() {
		return btnsize;
	}

	public void setBtnsize(int btnsize) {
		this.btnsize = btnsize;
	}

	public int getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}

	public int getEndbtn() {
		return endbtn;
	}

	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}

	public ArrayList<BoardDto> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<BoardDto> boardlist) {
		this.boardlist = boardlist;
	}

	
	
}
