package tag.models;

import java.util.List;

public class FileVO {
	private long id;
	private String title;
	private String thumbnail;
	private String category;
	private String description;
	private String wordCloud;
	private List<TagVO> tagList;
	private long userId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWordCloud() {
		return wordCloud;
	}

	public void setWordCloud(String wordCloud) {
		this.wordCloud = wordCloud;
	}

	public List<TagVO> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagVO> tagList) {
		this.tagList = tagList;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FileVO [id=" + id + ", title=" + title + ", thumbnail=" + thumbnail + ", category=" + category
				+ ", description=" + description + ", tagList=" + tagList + "]";
	}

	
	
}
