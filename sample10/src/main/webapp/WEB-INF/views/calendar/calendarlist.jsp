<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">
	<form action="" id="frmFormSearch" method="get">
	</form>
</div> -->


<table class="list_table" style="width: 85%" id="_list_table">
  <colgroup>
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  	<col style="width:14.2%">
  </colgroup>
  
  <tr>
    <td colspan="7" height="100px">
    	<a href='#none' class="next"><img src='./image/left.gif'></a>
    	<a href='#none' class="next"><img src='./image/prec.gif'></a>
	    <span style="font: 35px bold; margin: 0 10px;">
	    <span id="year">${param.year}</span>년 <span id="month">${param.month}</span>월
	    </span>
    	<a href='#none' class="next"><img src='./image/next.gif'></a>
    	<a href='#none' class="next"><img src='./image/last.gif'></a>
	</td>
  </tr>
  
  <tr>
    <th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
  </tr>
  
  
  
</table>

<script type="text/javascript">
getCalendarData();

function getCalendarData() {
	$.ajax({
		url:"./calendarData.do",
		type:"get",
		data:{
			year:$("#year").html(),
			month:$("#month").html()
		},
		success:function(cal){//alert(JSON.stringify(data));
			
			$("#year").html(cal.year);
			$("#month").html(cal.month);
			
			let app = "<tr height='100'>";
			let blank = "<td style='background-color: #d1e7fc;'>&nbsp;</td>";
			
			for(var i=1;i<cal.firstweek;i++){
				app += blank;
			}
			
			for(var i=1;i<=cal.lastday;i++){
				app += "<td style='text-align: left; vertical-align: top; font: 15px bold;'>"+i+"</td>"; //여기에 이미지링크랑 일정테이블도 들어가야 하는데 함수로 빼야할듯
				
				if( (i+cal.firstweek-1)%7==0 && i!=cal.lastday){
					app += "</tr><tr height='100'>";
				}
			}
			
			for(var i=0;i<7-cal.lastweek;i++){
				app += blank;
			}
			
			$("#_list_table").append(app);
		},
		error:function(){alert('error');}
	});
}

function showPen(year,month,day) {
	let img = "<img src='image/pen2.png' width='10px' height='10px'>";
	let str = "<a href='calwrite.jsp?year="+year
			+ "&month="+month+"&day="+day+"'>"+img+"</a>";
	return str;
}

$(".next").on("click",function(){
	//getCalendarData();
	//let year = $("#year").html();
	//let month = $("#month").html();
	//location.href = "calendarlist.do?year="+year+"&month"+month;
});

</script>



