package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.CalendarParam;
import bit.com.a.service.CalendarService;


@Controller
public class CalendarController {
	
	@Autowired
	CalendarService calService;
	
	@RequestMapping(value = "calendarlist.do", method = RequestMethod.GET)
	public String calendarlist(Model model) {
		model.addAttribute("doc_title", "일정목록");
		
		CalendarParam cp = calService.getCalendarData();
		model.addAttribute("param",cp);
		System.out.println(cp.toString());
		
		return "calendarlist.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "calendarData.do", method = RequestMethod.GET)
	public CalendarParam calendarData(CalendarParam param, Model model) {
		System.out.println(param.toString());
		CalendarParam cp= calService.getCalendarData(param);
		
		return cp;
	}
	
	
}
