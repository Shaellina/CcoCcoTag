package tag.models;

import java.util.List;

public interface FileDAO {

	//public List<FileVO> searchFile(SearchVO searchVO);
	
	public List<FileVO> getFileList();
	
	public void uploadFile(FileVO fileVO);
	
	public FileVO getFileDetail(long no);
	
	public int deleteFile(FileVO fileVO);
	
	public long getFileId(FileVO fileVO);
}
