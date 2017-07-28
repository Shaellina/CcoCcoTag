package watson.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

import article.controllers.AbstractController;
import article.controllers.ModelAndView;

public class Text2Speech extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		TextToSpeech service = new TextToSpeech("afc4f170-49f5-4970-8270-1dbe8175cae5", "57FEOBripi6m");

		ServiceCall call = service.getVoices();
		List<Voice> voices = (List<Voice>) call.execute();

		return new ModelAndView("/WEB-INF/views/watson/text2speech.jsp", "voices", voices);
	}
}
