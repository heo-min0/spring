package bit.com.a.util;

import java.sql.Date;

public class UtilEx {
	
	public static String two(String msg) {
		return msg.trim().length()<2?"0"+msg.trim():msg.trim(); 
	}
	
	public static Date toDate(int year, int month, int day) {
		String s = year + "-" + two(month+"") + "-" + two(day+"");
		Date d = Date.valueOf(s);
		return d;
	}
}
