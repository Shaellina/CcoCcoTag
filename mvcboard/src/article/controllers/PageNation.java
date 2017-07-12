package article.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;

public class PageNation {
	private static Logger logger = 
			LoggerFactory.getLogger(PageNation.class);
	
	long pg = 1;
	long pageCount = 0;							// 전체 페이지 수
	long totalCount = 0;						// 전체 게시물 수
	long blockSize = 10;						// 한페이지에 출력할 페이지수
	int pageSize = 10;	// 페이지당 출력할 게시물 수
	long startPage = 0; //(pg - 1)/blockSize * blockSize + 1;	// 페이지 블럭 시작페이지
	long endPage = 0;   //(pg - 1)/blockSize * blockSize + blockSize; // 페이지 블럭 끝페이지
	
	long startnum = 0; //
	long endnum = 0; //
	private StringBuffer display = new StringBuffer();
	
	public PageNation(long pg) throws Exception {
		this.pg = pg;
		startnum = (pg - 1) * pageSize + 1;
		endnum = pg * pageSize;
		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();
		totalCount = articleDAO.getTotalCount();	// 전체 게시물 갯수 조회
		pageCount = totalCount / pageSize;	// 전체 페이지 수
		if (totalCount % pageSize != 0){
			pageCount++;
		}
		if (pageCount < endPage) endPage = pageCount;
		
		if (startPage == 1) {
			display.append(" [이전블럭] ");
		} else {
			display.append(" <a href='list?pg=" + (startPage - 1) + "'>[이전블럭]</a> ");
		}
		for(long p = startPage; p <= endPage; p++) {
			if (p == pg) {
				display.append(" " + p + " ");
			} else {
				display.append("<a href='list?pg="+ pg + "'>" + p + "</a> ");
			}
		}
		if (endPage == pageCount) {
			display.append(" [다음블럭] ");
		} else {
			display.append(" <a href='list?pg=" + (endPage + 1) + "'>[다음블럭]</a> ");
		}
	}

	public long getPg() {
		return pg;
	}

	public void setPg(long pg) {
		this.pg = pg;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(long blockSize) {
		this.blockSize = blockSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getStartPage() {
		return startPage;
	}

	public void setStartPage(long startPage) {
		this.startPage = startPage;
	}

	public long getEndPage() {
		return endPage;
	}

	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}

	public long getStartnum() {
		return startnum;
	}

	public void setStartnum(long startnum) {
		this.startnum = startnum;
	}

	public long getEndnum() {
		return endnum;
	}

	public void setEndnum(long endnum) {
		this.endnum = endnum;
	}

	public StringBuffer getDisplay() {
		return display;
	}

	public void setDisplay(StringBuffer display) {
		this.display = display;
	}
	
	
}
