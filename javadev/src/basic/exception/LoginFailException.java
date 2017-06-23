package basic.exception;

import java.io.FileWriter;
import java.io.IOException;

public class LoginFailException extends RuntimeException {
	public LoginFailException(String errorMsg) {
		super(errorMsg);
	}

	public LoginFailException(String errorMsg, MemberVO member) {
		super(errorMsg);
		try {
			FileWriter fw = new FileWriter("log.txt", true); // parameter -> file name , 계속 쓸건지 말건지 boolean value
			fw.write("아래와 같은 로그인 시도가 있었음\n");
			fw.write(member.toString() + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
