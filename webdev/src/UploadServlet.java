
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//String savePath = "upload";
		String savePath = "C:/dev/upload";
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";

		ServletContext context = getServletContext();
		//String uploadFilePath = context.getRealPath(savePath);
		String uploadFilePath = savePath;
		
		System.out.println("서버상의 실제 디렉토리 : ");
		System.out.println(uploadFilePath);

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
					new DefaultFileRenamePolicy());
			String fileName = multi.getFilesystemName("uploadFile");

			if (fileName == null) {
				System.out.print("파일이 업로드 되지 않았음");
			} else {
				//out.println("<br> 글쓴이 : " + multi.getParameter("name"));
				//out.println("<br> 제 &nbsp; 목 : " + multi.getParameter("title"));
				out.println("upload가 성공하였습니다.");
				// out.println("<br> 저장 된 파일명 : " + fileName);
				out.println("<br> 저장 된 파일명 : " + multi.getOriginalFileName(multi.getFileNames().nextElement().toString()));
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}

}
