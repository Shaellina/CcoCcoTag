package tag.models;

import java.sql.SQLException;


import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.QueryHandler;

public class UserDAOImpl implements UserDAO {
	private static UserDAOImpl userDAO = null;
	SqlMapClient sqlMap = QueryHandler.getInstance();
	
	public static UserDAOImpl getInstance() {
		if (userDAO == null) {
			userDAO = new UserDAOImpl();
		}
		return userDAO;
	}
	
	@Override
	public UserVO login(UserVO userVO) {
		UserVO user = null;
		try {
			 user = (UserVO)sqlMap.queryForObject("user.loginAction", userVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void signup(UserVO userVO) {
		try {
			sqlMap.insert("user.signupAction", userVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int signupCheck(UserVO userVO) {
		int count = 0;
		try {
			count = (int)sqlMap.queryForObject("user.signupCheckAction", userVO);
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void cancel(UserVO userVO) {
		
	}
}
