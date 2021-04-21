package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalendarDto;

@Repository
public class CalendarDaoImpl implements CalendarDao {
	
	@Autowired
	SqlSession session;
	String ns = "Cal.";

	@Override
	public List<CalendarDto> getCalendarList(CalendarDto dto) {
		return session.selectList(ns+"getCalendarList",dto);
	}
	
	
}
