package bit.com.a.dto;

import java.io.Serializable;

public class CalendarParam implements Serializable{
	private int year, month, day, lastday, firstweek, lastweek;
	private String hour, min;
	
	public CalendarParam() {	}
	public CalendarParam(int year, int month, int day, int lastday, int firstweek, int lastweek, String hour,
			String min) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.lastday = lastday;
		this.firstweek = firstweek;
		this.lastweek = lastweek;
		this.hour = hour;
		this.min = min;
	}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	public int getMonth() {return month;}
	public void setMonth(int month) {this.month = month;}
	public int getDay() {return day;}
	public void setDay(int day) {this.day = day;}
	public int getLastday() {return lastday;}
	public void setLastday(int lastday) {this.lastday = lastday;}
	public int getFirstweek() {return firstweek;}
	public void setFirstweek(int firstweek) {this.firstweek = firstweek;}
	public int getLastweek() {return lastweek;}
	public void setLastweek(int lastweek) {this.lastweek = lastweek;}
	public String getHour() {return hour;}
	public void setHour(String hour) {this.hour = hour;}
	public String getMin() {return min;}
	public void setMin(String min) {this.min = min;}
	@Override
	public String toString() {
		return "CalendarParam [year=" + year + ", month=" + month + ", day=" + day + ", lastday=" + lastday
				+ ", firstweek=" + firstweek + ", lastweek=" + lastweek + ", hour=" + hour + ", min=" + min + "]";
	}
}
