package board.model;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class BoardVO {

	private long no;
	private String name;
	private String title;
	private String content;
	private String password;
	private Date regDate;
	private int viewCount;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	// public void setPassword(String password) {
	// this.password = DigestUtils.sha512Hex(password);
	// }

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", name=" + name + ", title=" + title + ", content=" + content + ", password="
				+ password + ", regDate=" + regDate + ", viewCount=" + viewCount + "]";
	}
}
