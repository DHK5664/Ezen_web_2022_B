package model.dto;

import java.util.ArrayList;

public class PageDto {

	private int page;		// 현재 페이지
	private int listsize;	// 페이지당 표시할 게시글 개수
	private int startrow;	// 현재 페이지에서 시작되는 게시물번호
	private int totalsize;	// 총 게시물 수
	private int totalpage;	// 총 페이지 수
	
	// !! : 게시물 목록
	ArrayList<BoardDto> boardlist;	// 출력할 데이터[게시물] 리스트
	
	public PageDto() {
		// TODO Auto-generated constructor stub
	}

	public PageDto(int page, int listsize, int startrow, int totalsize, int totalpage, ArrayList<BoardDto> boardlist) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.startrow = startrow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
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

	public ArrayList<BoardDto> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<BoardDto> boardlist) {
		this.boardlist = boardlist;
	}
	
	
}
