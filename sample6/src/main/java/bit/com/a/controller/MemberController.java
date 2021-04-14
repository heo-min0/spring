package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "login.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String login() {
		logger.info("MemberController login" + new Date());

		return "login";
	}

	@RequestMapping(value = "regi.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String regi() {
		logger.info("MemberController regi" + new Date());

		return "regi";
	}

	@ResponseBody
	@RequestMapping(value = "idchk.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String idchk(String id) {
		logger.info("MemberController idchk" + new Date());
		
		String str = "";
		str = memberService.getMember(id);
		return str;
	}

	
	@RequestMapping(value = "regiAF.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String regiAF(MemberDto dto) {
		logger.info("MemberController regiAF" + new Date());
		System.out.println(dto.toString());
		
		int count = memberService.addMember(dto);
		
		if (count>0) {
			logger.info("회원 가입되었습니다 " + new Date());
			return "login";
		}
		logger.info("가입되지 않았습니다 " + new Date());
		return "regi";
	}
	
	@RequestMapping(value = "loginAF.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String loginAF(MemberDto dto, HttpServletRequest req) {
		logger.info("MemberController loginAF" + new Date());
		
		MemberDto mem = memberService.login(dto);
		System.out.println(mem.toString());
		if(mem != null && !mem.getId().equals("")) {

			//session 저장
			req.getSession().setAttribute("login", mem);
			
			//bbslist 이동
			return "redirect:/bbslist.do"; //sendRedirect,  forward:forward
		}
		else { //로그인 실패시
			return "redirect:/login.do";
			//return "redirectMove"; //이런 jsp 만들어서 메시지만 띄워준다
		}
	
	}
}
