package video2audio;

import java.io.File;

public class Main {
	public static void main(String[] args) throws Exception {
		VideoToAudio.ConvertToAudio(new File("C:/dev/upload/Kenneth Cukier- Big data is better data.mp4"), "flac", null, 0);
		
		//System.out.println(DigestUtils.sha512Hex("1234"));
		//
		//STT.speech2Text("my.mp4");
		//
		// TTW.text2wordcloud();

		// BufferedReader br = new BufferedReader(new FileReader(new
		// File("C:/dev/script/result_text.txt")));
		//
		// String line = br.readLine();
		// while ((line = br.readLine()) != null) {
		// String[] v = line.split(","); // v[0] : word, v[1] : count
		// v[0] = v[0].replaceAll("\"", "");
		// System.out.println(v[0] + " : " + v[1]);
		// }
	}
}
