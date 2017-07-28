package watson.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import article.controllers.AbstractController;
import article.controllers.ModelAndView;

public class Text2SpeechAction extends AbstractController {

	private static Logger logger = LoggerFactory.getLogger(Text2SpeechAction.class);
	
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		String statement = request.getParameter("statement");
		String voice = request.getParameter("voice");

		logger.info("statement : " + statement + "\n voice : " + voice);

//		ModelAndView mav = new ModelAndView();
//		TextToSpeech service = new TextToSpeech("afc4f170-49f5-4970-8270-1dbe8175cae5", "57FEOBripi6m");
//		try {
//			String text = "";
//			InputStream stream = service.synthesize(text, Voice.EN_ALLISON, AudioFormat.WAV).execute();
//			InputStream in = WaveUtils.reWriteWaveHeader(stream);
//			// OutputStream out = new FileOutputStream("hello_world.wav");
//			byte[] buffer = new byte[1024];
//			int length;
//			/*
//			 * while ((length = in.read(buffer)) > 0) { out.write(buffer, 0,
//			 * length); } out.close();
//			 */
//			in.close();
//			stream.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mav;
		return null;
	}

}
