package tag.models;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.QueryHandler;

public class FileDAOImpl implements FileDAO {

	private static FileDAOImpl fileDAO = null;

	private FileDAOImpl() {
	}

	public static FileDAOImpl getInstance() {
		if (fileDAO == null) {
			fileDAO = new FileDAOImpl();
		}
		return fileDAO;
	}

	@Override
	public List<FileVO> getFileList() {
		List<FileVO> fileList = null;
		SqlMapClient sqlMap = QueryHandler.getInstance();
		try {
			fileList = (ArrayList<FileVO>) sqlMap.queryForList("file.getFileList");
			for (FileVO fileVO : fileList) {
				long id = fileVO.getId();
				List<TagVO> tagList = (List<TagVO>) sqlMap.queryForList("tag.getTop3TagList", id);
				fileVO.setTagList(tagList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileList;
	}

	@Override
	public void uploadFile(FileVO fileVO) {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		try {
			sqlMap.insert("file.uploadFile", fileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public FileVO getFileDetail(long fileId) {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		FileVO fileVO = null;
		try {
			fileVO = (FileVO) sqlMap.queryForObject("file.getFileDetail", fileId);
			List<TagVO> tagList = (List<TagVO>) sqlMap.queryForList("tag.getTagList", fileId);
			fileVO.setTagList(tagList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileVO;
	}

	@Override
	public int deleteFile(FileVO fileVO) {

		SqlMapClient sqlMap = QueryHandler.getInstance();
		FileVO getFile = null;
		int returnNum = 1;
		try {
			getFile = (FileVO) sqlMap.queryForObject("file.deleteFileSelect", fileVO);
			if (getFile != null) {
				returnNum = 0;
				System.out.println(getFile);
				long fileId = getFile.getId();
				sqlMap.delete("tag.deleteTag", fileId);

				File thumbnail = new File(getFile.getThumbnail());
				File wordCloud = new File(getFile.getWordCloud());

				if (thumbnail.exists()) {
					if (thumbnail.delete())
						System.out.println("Success Thumbnail DeleteAction");
					else
						System.out.println("Failed DeleteAction");
				}

				if (wordCloud.exists()) {
					if (wordCloud.delete())
						System.out.println("Success WordCloud DeleteAction");
					else
						System.out.println("Failed DeleteAction");
				}
				sqlMap.delete("file.deleteFile", fileVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnNum;
	}

	@Override
	public long getFileId(FileVO fileVO) {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		FileVO getFile = null;

		System.out.println("input id : " + fileVO.getId());
		try {
			getFile = (FileVO) sqlMap.queryForObject("file.getFileId", fileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("ouput id : " + getFile.getId());
		return getFile.getId();
	}

	/*
	 * @Override public List<FileVO> searchFile(SearchVO searchVO) {
	 * List<FileVO> fileList = null; SqlMapClient sqlMap =
	 * QueryHandler.getInstance(); try {
	 * 
	 * switch (searchVO.getOption()) { case "both": fileList = (List<FileVO>)
	 * sqlMap.queryForList("file.searchBothList", searchVO); break; case "tag":
	 * fileList = (List<FileVO>) sqlMap.queryForList("file.searchTagList",
	 * searchVO); break; case "title": fileList = (List<FileVO>)
	 * sqlMap.queryForList("file.searchTitleList", searchVO); break; default:
	 * break; } //fileList = (List<FileVO>)
	 * sqlMap.queryForList("file.searchList", searchVO); for (FileVO fileVO :
	 * fileList) { long id = fileVO.getId(); List<TagVO> tagList = new
	 * ArrayList<>(); tagList = (List<TagVO>)
	 * sqlMap.queryForList("tag.getTagList", id); fileVO.setTagList(tagList); }
	 * } catch (SQLException e) { e.printStackTrace(); } return fileList; }
	 */
}
