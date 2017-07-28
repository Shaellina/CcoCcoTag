package tag.models;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.QueryHandler;

public class TagDAOImpl implements TagDAO {
	private static TagDAOImpl tagDAO = null;

	private TagDAOImpl() {
	}

	public static TagDAOImpl getInstance() {
		if (tagDAO == null) {
			tagDAO = new TagDAOImpl();
		}
		return tagDAO;
	}
	
	@Override
	public void uploadTag(ArrayList<TagVO> tagList) {
		SqlMapClient sqlMap = QueryHandler.getInstance();
			try {
				for(TagVO tagVO : tagList)
					sqlMap.insert("tag.uploadTag", tagVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
