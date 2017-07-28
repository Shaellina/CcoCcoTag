package watson.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

@WebServlet("/Speaker")
public class Speaker extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(Speaker.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String statement = request.getParameter("statement");
		String voice = request.getParameter("voice");

		logger.info("statement : " + statement + "\n voice : " + voice);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment'filename=" + URLEncoder.encode("voice.ogg", "UTF-8")); // wav와

		TextToSpeech service = new TextToSpeech("afc4f170-49f5-4970-8270-1dbe8175cae5", "57FEOBripi6m");
		InputStream stream = service.synthesize(statement, new Voice(voice, null, null), AudioFormat.OGG).execute();
		InputStream in = WaveUtils.reWriteWaveHeader(stream);
		// OutputStream out = new FileOutputStream("voice.ogg");
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int length;

		// while ((length = in.read(buffer)) > 0) {
		// out.write(buffer, 0, length);
		// }
		// out.close();

		while ((length = in.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		os.close();
		in.close();
		stream.close();

	}
}
