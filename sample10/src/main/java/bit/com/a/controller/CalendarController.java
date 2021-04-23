package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarParam;
import bit.com.a.service.CalendarService;


@Controller
public class CalendarController {
	
	@Autowired
	CalendarService calService;
	
	@RequestMapping(value = "calendarlist.do", method = RequestMethod.GET)
	public String calendarlist(Model model) {
		model.addAttribute("doc_title", "일정목록");
		return "calendarlist.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "calendarData.do", method = RequestMethod.GET)
	public CalendarParam calendarData(CalendarParam param) {
		System.out.println(param.toString());
		CalendarParam cp= calService.getCalendarData(param);
		System.out.println(cp.toString());
		return cp;
	}
	
	@ResponseBody
	@RequestMapping(value = "calendarListData.do", method = RequestMethod.GET)
	public List<CalendarDto> calendarListData(CalendarParam param, CalendarDto dto) {
		System.out.println(param.toString());
		System.out.println("dto:"+dto.toString());
		
		List<CalendarDto> list = calService.getCalendarList(dto);
		System.out.println("리스트:"+list);
		
		return list;
	}
	
	@RequestMapping(value = "addcalendar.do", method = RequestMethod.GET)
	public String addcalendar(CalendarDto dto,String year,String month,String day,String hour,String min) {
		String rdate = year+month+day+hour+min;
		dto.setRdate(rdate);
		calService.addCalendar(dto);
		System.out.println(dto.toString());
		
		return "redirect:/calendarlist.do";
	}
	
	@RequestMapping(value = "calendardaylist.do", method = RequestMethod.GET)
	public String calendardaylist(CalendarDto dto,Model model) {
		System.out.println(dto.toString());
		
		List<CalendarDto> list = calService.getCalendarList(dto);
		model.addAttribute("daylist", list);
		
		return "calendardaylist.tiles";
	}
	
	@RequestMapping(value = "calendardetail.do", method = RequestMethod.GET)
	public String calendardetail(CalendarDto dto,Model model) {
		System.out.println(dto.toString());
		
		CalendarDto cal = calService.getCalendar(dto);
		System.out.println(cal.toString());
		model.addAttribute("caldto", cal);
		
		return "calendardetail.tiles";
	}
	
	@RequestMapping(value = "calendardel.do", method = RequestMethod.GET)
	public String calendardel(CalendarDto dto) {
		System.out.println(dto.toString());
		
		calService.delCalendar(dto);
		
		return "redirect:/calendarlist.do";
	}
	
	@RequestMapping(value = "calendarupdate.do", method = RequestMethod.GET)
	public String calendarupdate(CalendarDto dto) {
		System.out.println(dto.toString());
		
		calService.updateCalendar(dto);
		
		return "redirect:/calendarlist.do";
	}
	
}
