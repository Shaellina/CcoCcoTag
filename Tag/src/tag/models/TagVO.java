package tag.models;

public class TagVO {
	private Long fileId;
	private String name;
	private int count;

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TagVO() {}
	
	public TagVO(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public TagVO(Long fileId, String name, int count) {
		this.fileId = fileId;
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "TagVO [fileId=" + fileId + ", name=" + name + ", count=" + count + "]";
	}
	
	

}
