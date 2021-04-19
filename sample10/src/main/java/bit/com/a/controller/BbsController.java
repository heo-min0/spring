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
	
	
	@ResponseBody
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
	
	@ResponseBody
	@RequestMapping(value = "bbslistCount.do", method = RequestMethod.GET)
	public int bbslistCount(BbsParam param) {
		int count = bbsService.getBbsCount(param);
		System.out.println("페이지안넣었는데:"+param.toString()+"글수:"+count);
		return count;
	}
	
	
}
