package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.CalendarDto;
import bit.com.a.dto.CalendarParam;

public interface CalendarService {
	
	CalendarParam getCalendarData(CalendarParam param);
	List<CalendarDto> getCalendarList(CalendarDto dto);
}
