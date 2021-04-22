package bit.com.a.util;

import java.util.Date;

public class PdsUtil {
	/*
	파일명 변경하는 거 시간으로
	myfile.txt > f.indexOf('.') > 6
	파일명, 확장자명
	f.substring (6) > .txt
	f.substring (0, 6) > myfile
	*/
	
	//myfile.txt > 1384618.txt
	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.lastIndexOf('.') >= 0) { //확장자 명이 있다
			fpost = f.substring(f.lastIndexOf('.')); // 확장자를 가지고 온다 '.txt'
			filename = new Date().getTime() + fpost; 
		}
		else {
			filename = new Date().getTime() + ".back";
		}
		
		return filename;
	}
	
	
}
