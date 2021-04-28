package bit.com.a.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;


@Component //인스턴스값을 스프링에 맡기고 일단 생성해라
public class YoutubeParser {
//스태틱으로 만들어도됨
	String urls = "https://www.youtube.com/results?search_query=";
	
	public String search(String s) {
		
		System.out.println("검색:" + s);
		
		BufferedReader br = null;
		String str = "";
		
		try {
			String ss = URLEncoder.encode(s, "utf-8");
			
			URL url = new URL(urls+ss);
			br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			
			String msg = "";
			String text = "";
			
			while( (msg = br.readLine()) != null ) {
				text += msg.trim();
			}
			
			//System.out.println(text);
			//시작위치
			int pos = text.trim().indexOf("\"responseContext\"");
			
			//끝위치
			int endpos = text.indexOf("};", pos);
			
			str = text.substring(pos-1, endpos+1); // 제이손 형태로 만들었지만 결국은 스트링
			//System.out.println(str);
			
			str = str.replace("\"", "\\\""); //    "  ->  \"
			str = str.replace("\'", "\\\'"); //    '  ->  \'
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	
}
