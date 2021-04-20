package bit.com.a.service.impl;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import bit.com.a.dto.CalendarParam;
import bit.com.a.service.CalendarService;

@Service
public class CalendarParamImpl implements CalendarService {

	@Override
	public CalendarParam getCalendarData() {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;

		CalendarParam cp = new CalendarParam(year, month, 0,0,0,0);
		return cp;
	}
	
	@Override
	public CalendarParam getCalendarData(CalendarParam param) {
		Calendar cal = Calendar.getInstance();
		System.out.println(param.toString());
		
		int year, month, day;
		year=0;month=0;day=0;
		
		if(param.getMonth()<1) {
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DATE);
		}else {
			year = param.getYear();
			month = param.getMonth();
			day = cal.get(Calendar.DATE);
		}
		
		cal.set(Calendar.DATE, 1);
		int firstweek = cal.get(Calendar.DAY_OF_WEEK); //1일 요일
		
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //막날
		cal.set(Calendar.DATE, lastday);
		int lastweek = cal.get(Calendar.DAY_OF_WEEK); //막요일
		
		CalendarParam cp = new CalendarParam(year, month, day, lastday, firstweek, lastweek);
		
		return cp;
	}



}
