package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {

	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method = RequestMethod.GET)
	public String bbslist(Model model, BbsParam bbs) {
	//	logger.info("BbsController bbslist() " + new Date());
		System.out.println(bbs.toString());
		
		int start, end;
		start = 1 + 10 * bbs.getPage();
		end = 10 + 10 * bbs.getPage();
		
		bbs.setStart(start);
		bbs.setEnd(end);		
		
		List<BbsDto> list = bbsService.getBbsList(bbs);
		
		int bbsPage = bbsService.getBbsCount(bbs);
		System.out.println("bbsPage:" + bbsPage);		
		
		model.addAttribute("list", list);
		model.addAttribute("bbsPage", bbsPage);
		
		// 현재 페이지
		model.addAttribute("pageNumber", bbs.getPage());
		
		return "bbslist";
	}
	
	// insert
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
	//	logger.info("bbswrite " + new Date());
		return "bbswrite";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto dto) {
	//	logger.info("bbswriteAf " + new Date());
		logger.info(dto.toString());
		
		boolean b = bbsService.writeBbs(dto);
		if(b) {
			return "redirect:/bbslist.do";
		}else {
			return "redirect:/bbswrite.do";
		}		
	}	
	
	// detail
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(int seq, Model model) {
	//	logger.info("bbsdetail " + new Date());
		logger.info("seq:" + seq);
		
		// 접속 회수 가산
		bbsService.readCount(seq);
		
		BbsDto bbs = bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);		
				
		return "bbsdetail";
	}
	
	
	// answer
	@RequestMapping(value = "answer.do", method = RequestMethod.GET)
	public String answer(Model model, int seq) {
	//	logger.info("answer " + new Date());
		
		BbsDto bbs = bbsService.getBbs(seq);
		
		model.addAttribute("bbs", bbs);
		
		return "answer";
	}
	@RequestMapping(value = "answerAf.do", method = RequestMethod.POST)
	public String answerAf(int seq, BbsDto dto) {
	//	logger.info("answerAf " + new Date());
		
		dto.setSeq(seq);	// sequence는 넘어 온 seq로 설정		
		bbsService.reply(dto);
		
		return "redirect:/bbslist.do";
	}
	
	// delete
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, Model model) {		
		bbsService.deleteBbs(seq);
		return "redirect:/bbslist.do";		
	}
	
	// update
	@RequestMapping(value = "bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model){		
		BbsDto bbs = bbsService.getBbs(seq);		
		model.addAttribute("bbs", bbs);		
		return "bbsupdate";
	}
	
	@RequestMapping(value = "bbsupdateAf.do", 
			method = RequestMethod.POST)
	public String bbsupdateAf(BbsDto bbs, Model model) {		
		bbsService.updateBbs(bbs);
		return "redirect:/bbslist.do";
	}	
}







