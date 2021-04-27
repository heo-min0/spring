package bit.com.a.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		return "login.tiles";
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		return "regi.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public String idcheck(MemberDto mem) {
		System.out.println(mem.toString());
		
		int count = memberService.getId(mem);
		System.out.println(count);
		
		String msg = "";
		if(count > 0) {	msg = "n";}
		else {msg = "y";}
		
		return msg;
	}
	
	@RequestMapping(value = "regiAF.do", method = RequestMethod.POST)
	public String regiAF(MemberDto mem) {
		System.out.println(mem.toString());
		
		int count = memberService.addMember(mem);
		if(count > 0) {	return "login.tiles";}
		else {return "regi.tiles";}
	}

	@RequestMapping(value = "loginAF.do", method = RequestMethod.POST)
	public String loginAF(MemberDto dto, HttpServletRequest req) {
		System.out.println(dto.toString());
		
		MemberDto mem = memberService.login(dto);
		
		if(mem != null && !mem.getId().equals("")) {
			req.getSession().setAttribute("login", mem);
			req.getSession().setMaxInactiveInterval(60*60*24); //로그인 섹션 시간 주기
		//	req.getSession().setMaxInactiveInterval(5);
			System.out.println("2번째:"+mem.toString());
			return "redirect:/bbslist.do";
		}
		else {return "redirect:/login.do";}
	}
	
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("login");
		return "login.tiles";
	}
	
	@RequestMapping(value = "sessionOut.do", method = RequestMethod.GET)
	public String sessionOut() {
		return "sessionOut.tiles";
	}
	
	
}
