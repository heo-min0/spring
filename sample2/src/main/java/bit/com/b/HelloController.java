package bit.com.b;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.b.dto.Human;

@Controller
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("hello")
	public String helloMethod() {
		//System.out.println("HelloController helloMethod");
		logger.info("HelloController helloMethod" + new Date() );
		
		return "hello"; //hello.jsp로 가라!
				
	}
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	private String home(Model model) {
		logger.info("HelloController home" + new Date() );
		
		//짐싸기 = request.setAttribute
		String name = "홍길동";
		model.addAttribute("_name", name);
		
		return "home";
	}
	/*
	@RequestMapping(value = "world.do", method = RequestMethod.GET)
	private String world(String name, int age) {
		logger.info("HelloController world" + new Date() );
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		return "home";
	}*/
	
	@RequestMapping(value = "world.do", method = RequestMethod.GET)
	private String world(Human ha) {
		logger.info("HelloController world" + new Date() );
		
		System.out.println(ha.toString());

		return "home";
	}
	
	
}
