<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px; ">
	<form action="addcalendar.do" id="frmFormSearch" method="get">
		<table class="list_table" style="width: 85%;" id="_write_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;
				<input type="text" name="title" size="100%" style="border: 1px solid #ddd">
				<input type="hidden" name="id" value="${login.id}">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">일 정</th>
			<td style="text-align:left" class="schedule"></td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">내 용</th>
			<td colspan="2" style="text-align:left">&nbsp;
				<textarea rows="5" cols="98" name="content" style="border: 1px solid #ddd; resize: none;"></textarea>
			</td>
		  </tr>
		  
		  <tr>
			 <td colspan="2">
				 <span class="button blue">
                 	<input type="submit" value="일정추가">
				 </span>
				 <span class="button blue ex">
                 	<input type="button" value="창닫기">
				 </span>
			 </td>
		  </tr>
		  
		</table>
	</form>
</div>


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
    	<a href='#none' class="next"><img src='./image/left.gif' ></a>
    	<a href='#none' class="next"><img src='./image/prec.gif'></a>
	    <span style="font: 35px bold; margin: 0 10px;">
	    <span id="year"></span>년 <span id="month"></span>월
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
$(".box_border").css("display","none");

let y = $("#year").html();
let m = $("#month").html();

if(m==""&&y==""){ //값 없을때 초기값
	y="-1"; m="-1";
	getCalendarData(y,m);
}

/* $(".box_border").focusout(function() {
    $(".box_border").css("display","none");
}); */

$(".next").on("click",function(){
	y = $("#year").html();
	m = $("#month").html();
	
	let i = $(this).index();
	switch(i){
		case 0: y--; break;
		case 1: m--; break;
		case 3: m++; break;
		case 4: y++; break;
	}

	if(m<1){m=12;y--;}
	if(m>12){m=1;y++;}
	
	getCalendarData(y,m);
});



function getCalendarData(yy,mm) {
	$.ajax({
		url:"./calendarData.do",
		type:"get",
		data:{year:yy,month:mm},
		success:function(cal){//alert(JSON.stringify(data));
			$("._list_body").remove();

			let cy=cal.year;
			let cm=cal.month;
			if(cal.month < 10){	cm = 0+""+cal.month;}
			
			$("#year").html(cy);
			$("#month").html(cm);
			
			let app = "<tr height='100' class='_list_body'>";
			let blank = "<td style='background-color: #d1e7fc;'>&nbsp;</td>";
			
			for(var i=1;i<cal.firstweek;i++){
				app += blank;
			}
			
			for(var i=1;i<=cal.lastday;i++){
				let cd = i;
				if(i < 10){cd = 0+""+i;}
				
				app += "<td style='text-align: left; vertical-align: top; font: 15px bold;'>"
					+ callist(cy,cm,cd) //날짜 누르면 세부사항 가능 함수도 필요
					+"  "+showPen(cy,cm,cd)//여기에 이미지링크랑 일정테이블도 들어가야 하는데 함수로 빼야할듯
					+ makeTable(cy,cm,cd)//여기에는 테이블을 넣어야 할거 같은데 이것도 함수로
					+"</td>";
					
				if( (i+cal.firstweek-1)%7==0 && i!=cal.lastday){
					app += "</tr><tr height='100' class='_list_body'>";
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

function callist(year,month,day) {
	let rdate = year+""+month+""+day
	let str = "&nbsp;<a href='calendardaylist.do?id=${login.id}&rdate="+rdate+"'>"+day+"</a>";
	return str;
}

function showPen(year,month,day) {
	let img = "<img src='image/pen.png' width='20px' height='20px' ";
		img += "onclick='calendarwrite("+year+","+month+","+day+")'>";
	let str = "<a href='#none'>"+img+"</a>";
	return str;
}

$(".ex").on("click",function(){
	$(".box_border").slideUp();
});

$(document).on('change','.sel',function(){
	let sy = document.getElementById("_year");
	let sm = document.getElementById("_month");
	let sd = document.getElementById("_day");
    let yy = Number( sy.options[sy.selectedIndex].value );
    let mm = sm.options[sm.selectedIndex].value;
    let dd = sd.options[sd.selectedIndex].value;
    console.log(yy+mm+dd);
	calendarwrite(yy,mm,dd);
});

function calendarwrite(yy,mm,dd) {
	$(".select_body").remove();
	$(".box_border").slideDown();
	//$(".box_border").css("display","block");
	
	let date = new Date(yy,mm,0);
	let lastday = date.getDate();
	//alert ( lastday + date );
	
	let app="<span class='select_body'>&nbsp;&nbsp;<select name='year' id='_year' class='sel'>";
	console.log(yy+5);
	for(var i=yy-5;i<=yy+5;i++){
		app += "<option ";
		if(i==yy){ app += "selected='selected'"; }
		app += ">"+i+"</option>";
		
	}
	app += "</select>년";
	
	app += "&nbsp;<select name='month' id='_month' class='sel'>";
	for(var i=1;i<=12;i++){
		app += "<option ";
		if(i==mm){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>월";
	
	app += "&nbsp;<select name='day' id='_day'>";
	for(var i=1;i<=lastday;i++){
		app += "<option ";
		if(i==dd){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>일";
	
	app += "&nbsp;<select name='hour'>";
	for(var i=0;i<=24;i++){
		app += "<option ";
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>시";
	
	app += "&nbsp;<select name='min'>";
	for(var i=0;i<=60;i+=5){
		app += "<option ";
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>분</span>";	
	
	$(".schedule").append(app);
}

function makeTable(yy,mm,dd) {
	let mdate = ""+yy+mm+dd;
	let str = "";
	$.ajax({
		url:"./calendarListData.do",
		type:"get",
		async: false,
		data:{id:"${login.id}", rdate:mdate},
		success:function(list){//alert(JSON.stringify(list));
			str = "<table style='margin:0;' border='1'> <col width='100'>";
			str += "<div align='center'>";
			str += "<ul>";

			$.each(list,function (i,val){
				str += "<li><a href='calendardetail.do?seq="+val.seq+"'>";
				str += "<font style='font-size:8px; color:black'>";
				str += val.title;
				str += "</font>";
				str += "</a></li>";
			});
			
			str += "</ul>";
			str += "</div>";
			str += "</table>";
		},
		error:function(){alert('error');}
	});
	return str;
}


</script>



