package tag.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/tag/download.do")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		//String uploadPath = "C:/dev/upload"+userId;
		String fileName = request.getParameter("fileName");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

		byte[] dataBuffer = new byte[1024 * 100];

		//InputStream is = new BufferedInputStream(new FileInputStream(uploadPath + "/" + fileName));
		System.out.println(fileName);
		InputStream is = new BufferedInputStream(new FileInputStream(fileName));

		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		while (is.read(dataBuffer) != -1) {
			os.write(dataBuffer);
		}
		if (os != null) {
			try {
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (is != null) {
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
