package speech2text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.catalina.webresources.war.Handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import text2wordcloud.TTW;

public class STT {

	public static void speech2Text(String realVideoName, long id) {

		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("59e618ad-9430-4897-8438-d9a5f78b0e65", "1VDT7eE1LpFl");

		RecognizeOptions options = new RecognizeOptions.Builder().contentType("audio/wav").inactivityTimeout(60).build();
		String file = "C:/dev/upload/"+ id + "/" + realVideoName + ".wav";
		SpeechResults results = service.recognize(new File(file), options).execute();

		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(results.toString());
		StringBuffer transcripts = new StringBuffer();
		JsonArray arr = (JsonArray) jsonObject.get("results");
		for (int i = 0; i < arr.size(); i++) {
			JsonObject result = (JsonObject) arr.get(i);
			JsonArray alternatives = (JsonArray) result.get("alternatives");
			for (int j = 0; j < alternatives.size(); j++) {
				JsonObject alternative = (JsonObject) alternatives.get(j);
				String transcript = alternative.get("transcript").toString();
				transcripts.append(transcript);
			}
		}
		
		String path = "C:/dev/script/"+id;
		
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		System.out.println("transcripts  : " + transcripts);
		String fileName = path+"/script.txt";

		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));
			fw.write(transcripts.toString());
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
