package text2wordcloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import rcaller.RCaller;
import rcaller.RCode;
import tag.models.TagVO;

public class TTW {

	public static ArrayList<TagVO> text2wordcloud(String fileName, long id) {
		System.out.println("text2wordcloud start");

		RCaller rCaller = new RCaller();
		RCode rCode = new RCode();
		rCaller.setRscriptExecutable("C:/Program Files/R/R-3.4.1/bin/x64/Rscript.exe");
		
		StringBuilder code = new StringBuilder();
		BufferedReader readRcode;
		
		String path = "C:/dev/script/"+id;
		
//		File dir = new File(path);
//		if (!dir.exists()) {
//			dir.mkdir();
//		}
		try {
			readRcode = new BufferedReader(new FileReader("C:/dev/workspace/Tag/src/script.R"));
			String lineRcode= null;
			
			code.append("setwd(\""+path +"\")\n");
			
			while((lineRcode=readRcode.readLine()) != null)
				code.append(lineRcode+"\n");
			
			code.append("write.table(r,file=");
			code.append("\""+path+"/"+fileName+".txt\",append=F,sep=\",\")\n");
			code.append("set.seed(1234)\n");
			code.append("png(\""+fileName+".png\", width=250, height=250)\n"); // png("#.png", width=250, height=250)
			code.append("par(bg=\"#292E3D\")\n");
			code.append("wordcloud(words=d$word, freq=d$freq, min.freq=1, random.order=F, max.words=200, rot.per=0.35, colors=palvec)\n");
			code.append("dev.off()");
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		rCode.addRCode(code.toString());
		rCaller.setRCode(rCode);
		rCaller.runOnly();
		System.out.println("스크립트 수행완료");

		ArrayList<TagVO> tagList = new ArrayList<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(path+"/"+fileName+".txt")));

			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] v = line.split(","); // v[0] : word, v[1] : count
				v[0] = v[0].replaceAll("\"", "");
				System.out.println(v[0] + " : " + v[1]);

				tagList.add(new TagVO(v[0], Integer.parseInt(v[1])));
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return tagList;
	}
}
