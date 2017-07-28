package tag.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import speech2text.STT;
import tag.models.FileDAO;
import tag.models.FileDAOImpl;
import tag.models.FileVO;
import tag.models.TagDAO;
import tag.models.TagDAOImpl;
import tag.models.TagVO;
import text2wordcloud.TTW;
import video2audio.VideoToAudio;

@WebServlet("/tag/upload.do")
public class UploadAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);// 전달 해주어야 한다.
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		boolean isVideo = false;
		boolean isThumbnail = false;

		int uploadFileSizeLimit = 100 * 1024 * 1024;
		String encType = "UTF-8";

		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		long id = Long.parseLong((String) session.getAttribute("user_id"));
		String uploadFilePath = "C:/dev/upload/" + id;

		System.out.println("서버상의 실제 디렉토리 : ");
		System.out.println(uploadFilePath);

		File dir = new File(uploadFilePath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
					new DefaultFileRenamePolicy());

			Enumeration files = multi.getFileNames();
			int i = 1;
			System.out.println("files : " + files);

			FileVO fileVO = new FileVO();
			String videoFileName = null;
			String thumbnailFileName = null;
			String realFileName = null;
			while (files.hasMoreElements()) { // 역순 입력
				String file = (String) files.nextElement(); // input name value
				String contentType = multi.getContentType(file);
				if (file.equals("uploadVideoFile") && contentType.substring(0, 5).toLowerCase().equals("video")) {
					System.out.println("video ok");
					videoFileName = multi.getFilesystemName(file);
					StringTokenizer tokens = new StringTokenizer(videoFileName);
					realFileName = tokens.nextToken(".");
					System.out.println("name : " + realFileName);
				} else if (file.equals("uploadThumbnailFile")
						&& contentType.substring(0, 5).toLowerCase().equals("image")) {
					System.out.println("image ok");
					thumbnailFileName = multi.getFilesystemName(file);
					fileVO.setThumbnail(uploadFilePath + "/" + thumbnailFileName);
				} else {
					request.setAttribute("msg", "파일이 잘못되었습니다.");
					request.setAttribute("url", "javascript:history.back();");
					doProcess(request, response, "/WEB-INF/result.jsp");
				}
			}

//			if () {
//				request.setAttribute("msg", "파일이 업로드 되지 않았음");
//				request.setAttribute("url", "javascript:history.back();");
//				doProcess(request, response, "/WEB-INF/result.jsp");
//			} else {
			VideoToAudio.ConvertToAudio(new File(uploadFilePath +"/"+ videoFileName), realFileName, "pcm_s16le", id);
			STT.speech2Text(realFileName, id);
			ArrayList<TagVO> tagList = TTW.text2wordcloud(realFileName, id);

			String wordCloudPath = "C:/dev/script/" + id;
			System.out.println("wordcloud : " + wordCloudPath + "/" + realFileName + ".png");
			//System.out.println("id : " + id);

			// DB Connect
			FileDAO fileDAO = FileDAOImpl.getInstance();
			fileVO.setTitle(multi.getParameter("title"));
			fileVO.setCategory(multi.getParameter("category"));
			fileVO.setDescription(multi.getParameter("description"));
			fileVO.setWordCloud(wordCloudPath + "/" + realFileName+".png");
			fileVO.setUserId(id);

			fileDAO.uploadFile(fileVO);

			long fileId = fileDAO.getFileId(fileVO);
			if(fileId == 0) {
				request.setAttribute("msg", "upload error");
				request.setAttribute("url", "javascript:history.back();");
			} else {
				TagDAO tagDAO = TagDAOImpl.getInstance();
				for (TagVO tagVO : tagList)
					tagVO.setFileId(fileId);
				tagDAO.uploadTag(tagList);
				request.setAttribute("msg", "Success uploadAction");
				request.setAttribute("url", "list");
			}
			doProcess(request, response, "/WEB-INF/result.jsp");
//			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
