<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./fcalLib/main.css">
<script type="text/javascript" src="./fcalLib/main.js"></script>
<!-- https://fullcalendar.io/ -->


</head>
<body>

<div id="calendar"></div>

<style type="text/css">
#calendar{
	max-width: 800px;
	margin: 50px auto;
}
</style>


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
		events:[
			{title:'비즈니스 점심 약속',start:'2021-04-23',	constraint: '김사장'},
			{title:'비즈니스',start:'2021-04-22T16:30:00', constraint: '사장'}, //new Date() 사용가능
			{title:'점심약속',start:'2021-04-22 12:00:00',constraint: '김사장',color:'#f00'},
			{title:'운동',start:'2021-04-19',end:'2021-04-23'},
			{title:'데이트',start:'2021-04-24 18:00:00',constraint:'영화관람',display:'background-color',color:'#0f0'},
			{title:'데이트',start:'2021-04-26 18:00:00',constraint:'영화관람',display:'background'}
		]
	});
	
	calendar.render(); //렌더링 그려주는거
	
	//이벤트
	calendar.on("dateClick", function (info) {
		//alert(JSON.stringify(info));
		alert(info.dateStr);
	});
	calendar.on("eventClick", function (info) {
		alert(info.event.title);
	});
	calendar.addEvent({'title':'추가이벤트','start':'2021-04-30 12:00:00','constraint':'내용'});
	
	
});

</script>




</body>
</html>