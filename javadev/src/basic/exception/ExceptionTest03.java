package basic.exception;

import java.util.Scanner;

public class ExceptionTest03 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("id : ");
		String userId = s.next();
		System.out.println("pw : ");
		String userPw = s.next();

		MemberVO userInfo = new MemberVO();
		userInfo.setUserId(userId);
		userInfo.setUserPw(userPw);

		try {
			userInfo = login(userInfo);
			System.out.println(userInfo.getUserName());
		} catch (LoginFailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// System.out.println(userInfo.getUserName());
		}
		// System.out.println(DigestUtils.sha512Hex("12345678"));
		// "fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe"
	}

	public static MemberVO login(MemberVO userInfo) throws LoginFailException {
		if (userInfo.getUserId().equals("whdqhd") && userInfo.getUserPw().equals(
				"fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe")) {
			userInfo.setUserName("JB");
			return userInfo;
		} else {
			throw new LoginFailException("Id or Pw가 틀렸음", userInfo);
			
		}
	}
}
