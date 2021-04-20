package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model) {
		model.addAttribute("doc_title", "글목록");
		return "bbslist.tiles";
	}
	
	
	@ResponseBody //ajax로 리스트만 받아서 데이터로 넘겨줌
	@RequestMapping(value = "bbslistData.do", method = RequestMethod.GET)
	public List<BbsDto> bbslistData(BbsParam param, Model model) {
		
		//paging 처리
		int sn = param.getPage();
		int start = sn*10 + 1;
		int end = sn*10 + 10;
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = bbsService.getBbsList(param);
		
		return list;
	}
	
	@ResponseBody //총 페이지 수를 구하는
	@RequestMapping(value = "bbslistCount.do", method = RequestMethod.GET)
	public int bbslistCount(BbsParam param) {
		int count = bbsService.getBbsCount(param);
		System.out.println("페이지안넣었는데:"+param.toString()+"글수:"+count);
		return count;
	}
	
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite(Model model) {
		model.addAttribute("doc_title", "글쓰기");
		return "bbswrite.tiles";
	}
	
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.GET)
	public String bbswriteAf(BbsDto dto) {
		System.out.println(dto.toString());
		
		if(dto.getContent().equals("") || dto.getTitle().equals("")){
			return "bbswrite.tiles";
		}
		
		boolean b = bbsService.writeBbs(dto);
		System.out.println(dto.toString()+b);
		
		if(b) return "redirect:/bbslist.do";
		else return "redirect:/bbswrite.do";
	}


	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(Model model, int seq) {
		model.addAttribute("doc_title", "글상세");
		
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		bbsService.readCount(seq);
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbsupdate.do", method = RequestMethod.GET)
	public String bbsupdate(Model model, int seq) {
		model.addAttribute("doc_title", "글수정");
		
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsupdate.tiles";
	}
	
	@RequestMapping(value = "bbsupdateAf.do", method = RequestMethod.GET)
	public String bbsupdateAf(Model model, BbsDto dto) {
		System.out.println(dto.toString());
		
		bbsService.updateBbs(dto);
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = RequestMethod.GET)
	public String bbsdelete(int seq) {
		System.out.println("삭제할 번호:"+seq);
		bbsService.deleteBbs(seq);
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsanswer.do", method = RequestMethod.GET)
	public String bbsanswer(Model model, int seq) {
		model.addAttribute("doc_title", "답글달기");
		
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsanswer.tiles";
	}
	
	@RequestMapping(value = "bbsanswerAF.do", method = RequestMethod.GET)
	public String bbsanswerAF(BbsDto dto) {
		System.out.println(dto.toString());
		
		bbsService.reply(dto);
		
		return "redirect:/bbslist.do";
	}
}
