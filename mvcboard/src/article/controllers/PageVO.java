package article.controllers;

public class PageVO {
	private long startNum;
	private long endNum;

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getEndNum() {
		return endNum;
	}

	public void setEndNum(long endNum) {
		this.endNum = endNum;
	}

	public PageVO() {

	}

	public PageVO(long startNum, long endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public String toString() {
		return "PageVO [startNum=" + startNum + ", endNum=" + endNum + "]";
	}

}
