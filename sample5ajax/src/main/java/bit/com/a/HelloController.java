package bit.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.dto.Human;
import bit.com.a.dto.MyClass;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	/*1*/
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("HelloController hello" + new Date());

		MyClass cls = new MyClass(1001, "홍길동");
		model.addAttribute("mycls", cls);

		return "hello";
	}

	/*2*/
	@RequestMapping(value = "move.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String move(Model model, MyClass mycls) {
		logger.info("HelloController move" + new Date());

		System.out.println(mycls.toString());
		model.addAttribute("mycls", mycls);

		return "hello";
	}

	/*3*/
	@ResponseBody /*ajax사용시에 반드시 사용*/
	@RequestMapping(value = "idcheck.do", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/String; charset=utf-8")
	public String idcheck(String id) {
		logger.info("HelloController idcheck" + new Date());

		System.out.println("id:" + id);

		String str = "오케이";
		/*ajax는 들어오는것도 데이타 나가는 것도 데이타다!
		리스폰스 바디는 무조건 붙여야 한다*/
		return str;
	}

	/*4*/
	@ResponseBody
	@RequestMapping(value = "account.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> account(Human h) {
		logger.info("HelloController account" + new Date());
		System.out.println(h.toString());

		//DB접근
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "내가 보낸 메시지");
		map.put("name", "성춘향");
		
		return map;
	}

	
	/*5*/
	@ResponseBody
	@RequestMapping(value = "read.do", method = { RequestMethod.GET, RequestMethod.POST })
	public List<MyClass> read() {
		logger.info("HelloController read" + new Date());
		System.out.println();

		List<MyClass> list = new ArrayList<MyClass>();
		list.add(new MyClass(1,"홍길동"));
		list.add(new MyClass(2,"성춘향"));
		list.add(new MyClass(3,"일지매"));
		
		return list;
	}
	
	
	
	
}
