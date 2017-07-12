package article.models;

import java.util.List;

public interface ArticleDAO {
	void insertArticle(ArticleVO articleVO) throws Exception;

	List<ArticleVO> getArticleList() throws Exception;

	List<ArticleVO> getArticlePageList(int page, int pageSize) throws Exception;

	int getPageList(int pageSize) throws Exception;

	ArticleVO getDetail(long no) throws Exception;

	void updateViewCount(long no) throws Exception;

	void updateArticle(ArticleVO articleVO) throws Exception;

	String getCheckPassword(long no) throws Exception;

	void deleteArticle(long no, String pwd) throws Exception;

	long getTotalCount() throws Exception;
}
