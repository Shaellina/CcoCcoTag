package api;

import java.util.HashMap;
import java.util.Map;

public class CollectionTest3 {
	public static void main(String[] args) {
		Map<String, FriendVO> friendMap = new HashMap<>();

		friendMap.put("최지웅", new FriendVO("010-1111-1111", 29, 1));
		friendMap.put("지웅지웅", new FriendVO("010-2222-2222", 19, 1));

		for (String key : friendMap.keySet())
			System.out.println(friendMap.get(key));
	}
}
