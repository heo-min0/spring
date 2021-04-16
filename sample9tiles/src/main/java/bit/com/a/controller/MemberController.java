package bit.com.a.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value = "login.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String login() {
		logger.info("MemberController login 타일즈 " + new Date());

		return "login.tiles";
	}
	
	@RequestMapping(value = "bbslist.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String bbslist() {
		logger.info("MemberController bbslist" + new Date());

		return "bbslist.tiles";
	}
	
}
