package api;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest2 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("a", "aaa");
		map.put("b", "bbb");

		for (String key : map.keySet())
			System.out.println(key);

		// 순서같은 게 없다. 무작위로 가져오게 된다.
		// Hash라는 것은 최대한 흩어 놓게 하는 것이 목적이다.
	}
}
