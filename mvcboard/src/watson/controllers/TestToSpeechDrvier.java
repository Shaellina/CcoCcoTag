package watson.controllers;

import java.util.List;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TestToSpeechDrvier {

	public static void main(String[] args) {
		TextToSpeech service = new TextToSpeech("afc4f170-49f5-4970-8270-1dbe8175cae5", "57FEOBripi6m");

		ServiceCall call = service.getVoices();
		List<Voice> voices = (List<Voice>) call.execute();

		for (Voice voice : voices) {
			System.out.println(voice.getName() + " : " + voice.getLanguage());
		}
	}
}
