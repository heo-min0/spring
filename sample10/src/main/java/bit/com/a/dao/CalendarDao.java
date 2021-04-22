package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.CalendarDto;

public interface CalendarDao {
	
	List<CalendarDto> getCalendarList(CalendarDto dto);
	CalendarDto getCalendar(CalendarDto dto);
	void addCalendar(CalendarDto dto);
	void delCalendar(CalendarDto dto);
}
