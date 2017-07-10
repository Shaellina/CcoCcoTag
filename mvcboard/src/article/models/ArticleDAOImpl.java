package article.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ArticleDAOImpl implements ArticleDAO {
	private static ArticleDAOImpl articleDAO = null;

	private String driver = null;
	private String url = null;
	private String username = null;
	private String password = null;

	private ArticleDAOImpl() {
		Properties pr = new Properties();
		String props = this.getClass().getResource("").getPath() + "/database.properties";
		try {
			pr.load(new FileInputStream(props));

			driver = pr.getProperty("driver");
			url = pr.getProperty("url");
			username = pr.getProperty("username");
			password = pr.getProperty("password");

			Class.forName(driver);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static ArticleDAOImpl getInstance() {
		if (articleDAO == null) {
			articleDAO = new ArticleDAOImpl();
		}
		return articleDAO;
	}

	private void dbClose(PreparedStatement ps, Connection cn) {
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	private void dbClose(ResultSet rs, PreparedStatement ps, Connection cn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (ps != null)
			try {
				ps.close();
			} catch (Exception e) {
			}
		if (cn != null)
			try {
				cn.close();
			} catch (Exception e) {
			}
	}

	@Override
	public void insertArticle(ArticleVO articleVO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer();

		sql.append(" insert into tb_article");
		sql.append(" (no, name, title, content, pwd)");
		sql.append(" values(seq_article.nextval, ?,?,?,?)");

		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			// conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
			// "bigdata", "bigdata");

			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, articleVO.getName());
			pstmt.setString(2, articleVO.getTitle());
			pstmt.setString(3, articleVO.getContent());
			pstmt.setString(4, articleVO.getPwd());

			pstmt.executeUpdate();
			// execute는 DDL을 작성하거나 메타데이터를 가져올 때
		} finally {
			dbClose(pstmt, conn);
		}
	}

	@Override
	public List<ArticleVO> getArticleList() throws Exception {
		List<ArticleVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();

		sql.append(" select no, name, title, regdate, viewcount");
		sql.append(" from tb_article");
		sql.append(" order by no desc");
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ArticleVO articleVO = new ArticleVO();
				articleVO.setNo(Integer.parseInt(rs.getString("no")));
				articleVO.setTitle(rs.getString("title"));
				articleVO.setName(rs.getString("name"));
				articleVO.setViewCount(Integer.parseInt(rs.getString("viewcount")));
				list.add(articleVO);
			}
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return list;
	}

	public ArticleVO getDetail(long no) throws Exception {
		ArticleVO articleVO = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();

		sql.append(" select no, title, name, content, viewcount, regdate");
		sql.append(" from tb_article");
		sql.append(" where no=?");

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleVO = new ArticleVO();
				articleVO.setNo(rs.getLong("no"));
				articleVO.setName(rs.getString("name"));
				articleVO.setTitle(rs.getString("title"));
				articleVO.setContent(rs.getString("content"));
				articleVO.setRegDate(rs.getDate("regdate"));
				articleVO.setViewCount(rs.getInt("viewcount"));
			} else {
				throw new RuntimeException("상세보기를 할 수 없습니다.");
			}
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return articleVO;
	}
}
