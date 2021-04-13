package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	private String home(Model model) {
		logger.info("HelloController home" + new Date() );
		
		String name = "홍길동";
		model.addAttribute("_name", name);
		
		return "home";
	}

	
}
