package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String bbslist(Model model) {
		//logger.info("BbsController bbslist" + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		model.addAttribute("list",list);
		return "bbslist";
	}
	
	@RequestMapping(value = "pagebbslist.do", method = RequestMethod.GET)
	public String pagebbslist(BbsParam p, Model model) {
		//logger.info("BbsController pagebbslist" + new Date());
		System.out.println(p.toString());
		
		List<BbsDto> list = bbsService.getBbsList(p);
		int page = bbsService.getBbspage(p);
		
		model.addAttribute("bbsparam",p);
		model.addAttribute("list",list);
		model.addAttribute("pageNum",page);
		
		return "bbslist";
	}
	
	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
		//logger.info("BbsController bbswrite " + new Date());
		return "bbswrite";
	}
	
	@RequestMapping(value = "writeAF.do", method = RequestMethod.POST)
	public String writeAF(BbsDto dto) {
		//logger.info("BbsController writeAF " + new Date());
		System.out.println(dto.toString());
		
		int count = bbsService.writeBbs(dto);
		
		if (count>0) {
			logger.info("글작성이 완료되었습니다 " + new Date());
			return "redirect:/pagebbslist.do";
		}
		
		logger.info("글작성이 되지않았습니다 " + new Date());
		return "bbswrite";
	}

	
	@RequestMapping(value = "bbsdetail.do", method = RequestMethod.GET)
	public String bbsdetail(BbsDto dto, Model model) {
		//logger.info("BbsController bbsdetail " + new Date());
		System.out.println(dto.toString());
		
		BbsDto bbsdto = bbsService.bbsdetail(dto);
		bbsService.readCount(dto);
		
		model.addAttribute("bbsdto",bbsdto);
		
		return "bbsdetail";
	}

	
	@RequestMapping(value = "bbsanswer.do", method = RequestMethod.GET)
	public String bbsanswer(BbsDto dto, Model model) {
		//logger.info("BbsController bbsanswer " + new Date());
		System.out.println(dto.toString());
		
		BbsDto bbsdto = bbsService.bbsdetail(dto);
		model.addAttribute("bbsdto",bbsdto);
		
		return "answer";
	}
	
	@RequestMapping(value = "answerAF.do", method = RequestMethod.POST)
	public String answerAF(BbsDto dto) {
		//logger.info("BbsController answerAF " + new Date());
		System.out.println(dto.toString());
		
		int count = bbsService.bbsAnswer(dto);
		if (count>0) {
			logger.info("답글작성이 완료되었습니다 " + new Date());
			return "redirect:/pagebbslist.do";
		}
		return "redirect:/bbsanswer.do";
	}
	
	
	@RequestMapping(value = "bbsupdate.do", method = RequestMethod.GET)
	public String bbsupdate(BbsDto dto, Model model) {
		//logger.info("BbsController bbsupdate " + new Date());
		System.out.println(dto.toString());
		
		BbsDto bbsdto = bbsService.bbsdetail(dto);
		model.addAttribute("bbsdto",bbsdto);
		
		return "bbsupdate";
	}

	
	@RequestMapping(value = "updateAF.do", method = RequestMethod.POST)
	public String updateAF(BbsDto dto) {
		//logger.info("BbsController updateAF " + new Date());
		System.out.println(dto.toString());
		
		int count = bbsService.bbsUpdate(dto);
		if (count>0) {
			logger.info("수정이 완료되었습니다 " + new Date());
			return "redirect:/pagebbslist.do";
		}		
		return "redirect:/bbsdetail.do";
	}
	
	
	@RequestMapping(value = "bbsdel.do", method = RequestMethod.GET)
	public String bbsdel(BbsDto dto) {
		//logger.info("BbsController bbsdel " + new Date());
		System.out.println(dto.toString());
		
		int count = bbsService.bbsDel(dto);
		if (count>0) {
			logger.info("삭제가 완료되었습니다 " + new Date());
			return "redirect:/pagebbslist.do";
		}		
		return "redirect:/bbsdetail.do";
	}
	
}
