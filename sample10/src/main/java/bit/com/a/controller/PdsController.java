package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.BbsParam;
import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;
import bit.com.a.util.PdsUtil;

@Controller
public class PdsController {

	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String pdslist(Model model) {
		model.addAttribute("doc_title", "자료실 목록");
		
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist",list);
		
		return "pdslist.tiles";
	}
	
	@RequestMapping(value = "pdswrite.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String pdswrite(Model model) {
		model.addAttribute("doc_title", "자료 올리기");
		
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value = "pdsdetail.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String pdsdetail(int seq,Model model) {
		System.out.println("pdsdetail "+seq);
		PdsDto dto = service.getPds(seq);
		model.addAttribute("pdsdto", dto);
		
		return "pdsdetail.tiles";
	}
	
	@RequestMapping(value = "pdsupdate.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String pdsupdate(int seq,Model model) {
		System.out.println("pdsupdate "+seq);
		
		PdsDto dto = service.getPds(seq);
		model.addAttribute("pdsdto", dto);
		
		return "pdsupdate.tiles";
	}
	
	
	@RequestMapping(value = "pdsupload.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String pdsupload(PdsDto pdsdto, 
							@RequestParam(value = "fileload", required = false)
							MultipartFile fileload,
							HttpServletRequest req) {
		
		System.out.println(pdsdto.toString());
		
		if(fileload.getSize()<=0) {
			System.out.println("비었다"+pdsdto.toString());
			service.updatePds(pdsdto);
			return "redirect:/pdslist.do";
		}
		
		//filename 취득
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename); //원본 파일명을 넣어줌
		
		//upload 경로 설정
			//1. 서버(톰켓)에 올리는 것
		String fupload = req.getServletContext().getRealPath("/upload");
			//2. 폴더에 올리는 것
		//String fupload = "d:\\tmp";
		System.out.println("fupload:"+fupload);
		
		//파일명 변경 처리
		String newfilename = PdsUtil.getNewFileName(pdsdto.getFilename());
		pdsdto.setNewfilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		try {
			
			//실제로 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			if(pdsdto.getSeq()==0) {
				service.uploadPds(pdsdto); //db 저장
			}else {
				service.updatePds(pdsdto);
			}
			
		}
		catch (IOException e) {e.printStackTrace();}
		
		
		return "redirect:/pdslist.do";
	}
	
	
	@RequestMapping(value = "fileDownLoad.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String fileDownLoad(String newfilename,int seq,HttpServletRequest req,Model model) {
		
		//서버경로
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//폴더경로
		//String fupload = "d:\\tmp";
		
		File downloadFile = new File(fupload + "/" + newfilename);
		
		model.addAttribute("downloadFile",downloadFile);
		model.addAttribute("seq",seq);
		
		return "downloadView";
	}
	
	@RequestMapping(value = "pdsdel.do", method = RequestMethod.GET)
	public String pdsdel(int seq) {
		System.out.println("pds 지우는" + seq);
		
		service.delPds(seq);
		
		return "redirect:/pdslist.do";
	}
	
	
}



