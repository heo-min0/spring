package bit.com.a.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarParam;
import bit.com.a.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarDao dao;
	
	@Override
	public CalendarParam getCalendarData(CalendarParam param) {
		Calendar cal = Calendar.getInstance();
		System.out.println("서비스:"+param.toString());
		
		int year, month, day;
		year=0;month=0;day=0;
		
		if(param.getMonth()<0) {
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH)+1;
			day = cal.get(Calendar.DATE);
		}else {
			year = param.getYear();
			month = param.getMonth();
			day = param.getDay();
		}
		
		cal.set(year,month-1,1);
		int firstweek = cal.get(Calendar.DAY_OF_WEEK); //1일 요일
		
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //막날
		cal.set(Calendar.DATE, lastday);
		int lastweek = cal.get(Calendar.DAY_OF_WEEK); //막요일
		
		CalendarParam cp = new CalendarParam(year, month, day, lastday, firstweek, lastweek);
		
		return cp;
	}

	@Override
	public List<CalendarDto> getCalendarList(CalendarDto dto) {
		return dao.getCalendarList(dto);
	}



}
