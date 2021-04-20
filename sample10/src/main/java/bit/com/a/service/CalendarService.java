package bit.com.a.service;

import bit.com.a.dto.CalendarParam;

public interface CalendarService {
	
	CalendarParam getCalendarData();
	CalendarParam getCalendarData(CalendarParam param);
	
}
