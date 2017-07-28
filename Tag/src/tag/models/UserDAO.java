package tag.models;

public interface UserDAO {
	public UserVO login(UserVO userVO);

	public void signup(UserVO userVO);
	
	public void cancel(UserVO userVO);
	
	public int signupCheck(UserVO userVO);
}
