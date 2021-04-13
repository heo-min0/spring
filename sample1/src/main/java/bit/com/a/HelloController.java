package bit.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("hello")
	public String helloMethod() {
		System.out.println("HelloController helloMethod");
		return "hello"; //hello.jsp로 가라!
				
	}
}
