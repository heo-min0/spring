<%@page import="bit.com.a.dto.CalendarPlugDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/fcalLib/main.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/fcalLib/main.js"></script>

<style type="text/css">
.body {
  margin: 40px 10px;
  padding: 0;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 12px;
}
#calendar {
  max-width: 900px;
  margin: 20px auto;
} 
</style>

<% List<CalendarPlugDto> list = (List<CalendarPlugDto>)request.getAttribute("callist"); %>
<%
/* for(CalendarPlugDto c : list){
	System.out.println(c.toString());
} */

// JSONObject, JSONArray 자바를 json으로

String events = "[";
for(CalendarPlugDto c : list){
	events += "{id:'"+c.getId()+"',title:'"+c.getTitle()+"',start:'"+c.getStartdate()+"',end:'"+c.getEnddate()+"',constraint:'"+c.getContent()+"'},";
}
events = events.substring(0,events.lastIndexOf(","));
events += "]";

System.out.println(events);

request.setAttribute("events", events);
%>



<script type="text/javascript">
document.addEventListener("DOMContentLoaded",function(){
	let calendarEl = document.getElementById("calendar");
	let calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar:{
			left:"prev,next today",
			center:"title",
			right:"dayGridMonth,timeGridWeek,timeGridDay,listMonth"
		},
		initialDate: new Date(), //'2021-05-01' 처음 실행시 기본날짜
		locale:"ko", //한글설정
		navLinks: true,
		businessHours:true,
		events:<%=request.getAttribute("events")%>
	});
	calendar.render(); //렌더링 그려주는거
});
</script>


<div class="body">
	<div id="calendar"></div>
</div>



