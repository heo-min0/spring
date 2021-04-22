package bit.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;


public class DownloadView extends AbstractView {

	@Autowired
	PdsService service;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("다운로드 실행 DownloadView renderMergedOutputModel");
		
		int seq = (int)model.get("seq");
		PdsDto dto = service.getPds(seq);
		String orifilename = dto.getFilename(); //원본 파일이름 찾기
		
		File file = (File)model.get("downloadFile");  //이거 겟 어트리뷰트 랑 동일 getAttribute
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		//IE, chrome 설정 (파이어폭스 , 사파리? )
		String userAgent = request.getHeader("user-Agent");
		boolean ie = userAgent.indexOf("MSIE")  > -1;
		
		String filename = null;
		if(ie) {
			filename = URLEncoder.encode(file.getName(), "utf-8");
		}
		else {
			filename = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		}
		
		//다운로드 창
		response.setHeader("Content-Disposition", "attachment; filename=\"" + orifilename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); 
		response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = new FileInputStream(file);
		
		//실제 파일이 만들어지는 부분
		FileCopyUtils.copy(fi, out);
		
		//다운 횟수 증가
		
		///나중에 만들어 보자
		
		
		if(fi != null) {fi.close();}

		
	}

}





