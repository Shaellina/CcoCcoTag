package oop.exam10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// 내부에서 new 를 이용하여 tv를 만드는 것도 좋지 않다!
// 결합도가 증가하기 때문이다.

// class 안에 new가 있으면 compile 시점에서 사용하게 된다.
// 이렇게 사용하지 않기위해 properties를 만들어 runtime 시점에서 사용하게 한다.

// properties에서는 key , value의 형식으로 값을 저장한다.

public class TVUser {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		// TV tv = new SonyTV();
		Properties p = new Properties();
		p.load(new FileInputStream("product.properties"));

		Class clazz1 = Class.forName(p.getProperty("tv")); // class가 존재하는지 안하는지
															// 확인해서 생성까지 해준다.
		Class clazz2 = Class.forName(p.getProperty("speaker"));
		TV tv = (TV) clazz1.newInstance();
		Speaker speaker = (Speaker) clazz2.newInstance();
		tv.setSpeaker(speaker);
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}
}
