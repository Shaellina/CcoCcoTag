
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		// String savePath = "upload";
		String savePath = "C:/dev/upload";
		int uploadFileSizeLimit = 5 * 1024 * 1024 * 1024;
		String encType = "UTF-8";

		boolean isImage = false;
		boolean isAudio = false;

		ServletContext context = getServletContext();
		// String uploadFilePath = context.getRealPath(savePath);
		String uploadFilePath = savePath;

		System.out.println("서버상의 실제 디렉토리 : ");
		System.out.println(uploadFilePath);

		File dir = new File(uploadFilePath);
		if (!dir.exists()) {
			dir.mkdir();
		}

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
					new DefaultFileRenamePolicy());
			// String fileName = multi.getFilesystemName("uploadFile");
			// System.out.println(multi.getContentType("uploadFile"));

			Enumeration files = multi.getFileNames();

			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();

				// isImage = multi.getContentType("uploadFile").substring(0,
				// 6).toLowerCase().equals("image/");
				// isAudio =
				// multi.getContentType("uploadFile").equals("audio/mp3");
				isImage = file.substring(0, 6).toLowerCase().equals("image/");
				isAudio = file.equals("audio/mp3");
				
				System.out.println(file);

				String ext = multi.getContentType("uploadFile").substring(0, 6).toLowerCase();

				if (isImage) {
					ParameterBlock pb = new ParameterBlock();
					pb.add(uploadFilePath + "/" + file);
					RenderedOp rOp = JAI.create("fileload", pb);

					BufferedImage bi = rOp.getAsBufferedImage();
					BufferedImage thumb = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
					Graphics2D g = thumb.createGraphics();
					g.drawImage(bi, 0, 0, 100, 100, null);

					File f = new File(uploadFilePath + "/thumb_" + file);
					ImageIO.write(thumb, ext, f);
				}

				if (file == null)
					System.out.println("파일이 업로드 되지 않았음");
				else {
					// out.println("<br> 글쓴이 : " + multi.getParameter("name"));
					// out.println("<br> 제 &nbsp; 목 : " +
					// multi.getParameter("title"));
					out.println("upload가 성공하였습니다.");
					// out.println("<br> 저장 된 파일명 : " + fileName);
					out.println("<br> 저장 된 파일명 : "
							+ multi.getOriginalFileName(multi.getFileNames().nextElement().toString()));

					if (isImage) {
						out.println("<hr/>");
						// download.do를 이용하기에 uploadFilePath가 필요하지 않다.
						// out.println("<br/><img src='" + uploadFilePath +
						// "/thumb_" + fileName +"'>");
						// out.println("<br/><img src='" + uploadFilePath + "/"
						// +
						// fileName +"'>");

						// out.println("<br/><img
						// src='download.do?fileName=/thumb_"+fileName+"'/>");
						out.println("<br/><img src='download.do?fileName=" + file + "'/>");
					} else if (isAudio) {
						out.println("<hr/>");
						out.println("<br/><audio src='download.do?fileName=" + file
								+ "' autoplay='autoplay' controls='controls'/>");
					} else {
						out.println("<hr/>");
						out.println("<br/><video src='download.do?fileName=" + file
								+ "' autoplay='autoplay' controls='controls'/>");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}
}
