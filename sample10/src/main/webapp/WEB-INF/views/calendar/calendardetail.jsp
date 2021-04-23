<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px; ">
	<form action="calendarupdate.do" id="frmFormSearch" method="get">
		<table class="list_table" style="width: 85%;" id="_write_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">작성자</th>
			<td style="text-align:left">&nbsp;
				${caldto.id}
				<input type="hidden" name="seq" value="${caldto.seq}">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;
				<input type="text" name="title" value="${caldto.title}" size="100%">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">일 정</th>
			<td style="text-align:left">&nbsp;
				<span id="skddate"></span>
				<input type="hidden" name="rdate" id="rdate">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">내 용</th>
			<td colspan="2" style="text-align:left">&nbsp;
				<textarea rows="5" cols="98" name="content" style="border: 1px solid #ddd; resize: none;">${caldto.content}</textarea>
			</td>
		  </tr>
		  
		  <tr>
			 <td colspan="2">
				 <span class="button blue">
                 	<input type="button" value="수정완료" id="skdupdate">
				 </span>
				 <span class="button blue">
                 	<input type="button" value="일정삭제" id="skddel">
				 </span>
			 </td>
		  </tr>
		  
		</table>
	</form>
</div>

<script type="text/javascript">
rsplit(${caldto.rdate});

$("#skdupdate").click( function() {
	let srdate = $("select[name=year]").val();
		srdate += $("select[name=month]").val();
		srdate += $("select[name=day]").val();
		srdate += $("select[name=hour]").val();
		srdate += $("select[name=min]").val();
	$("#rdate").val(srdate);
	$("#frmFormSearch").submit();
});

$("#skddel").click( function() {
	location.href = "calendardel.do?seq=${caldto.seq}";
});

$(document).on('change','.sel',function(){
    let yy = Number( $("select[name=year]").val() );
	let mm = $("select[name=month]").val();
	let dd = $("select[name=day]").val();
	let hh = $("select[name=hour]").val();
	let mi = $("select[name=min]").val();

	skdwrite(yy,mm,dd,hh,mi);

	/* let doc = document.getElementsByClassName('select_body')[0].getElementsByTagName('select');
	let yy = Number( doc[0].options[doc[0].selectedIndex].value );
	let mm = doc[1].options[doc[1].selectedIndex].value;
	let dd = doc[2].options[doc[2].selectedIndex].value;
	let hh = doc[3].options[doc[3].selectedIndex].value;
	let mi = doc[4].options[doc[4].selectedIndex].value;
	 
    skdwrite(yy,mm,dd,hh,mi); */
});

function rsplit (rdate) {
	let str = rdate+"";
	let yy = Number(str.substring(0,4));
	let mm = str.substring(4,6);
	let dd = str.substring(6,8);
	let hh = str.substring(8,10);
	let mi = str.substring(10,12);
	
	skdwrite (yy,mm,dd,hh,mi);
} 

function skdwrite (yy,mm,dd,hh,mi) {
	$(".select_body").remove();
	
	let date = new Date(yy,mm,0);
	let lastday = date.getDate();
	
	let app="<span class='select_body'><select name='year' class='sel'>";
	console.log(yy+5);
	for(var i=yy-3;i<=yy+3;i++){
		app += "<option ";
		if(i==yy){ app += "selected='selected'"; }
		app += ">"+i+"</option>";
	}
	app += "</select>년";
	
	app += "&nbsp;<select name='month' class='sel'>";
	for(var i=1;i<=12;i++){
		app += "<option ";
		if(i==mm){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>월";
	
	app += "&nbsp;<select name='day' >";
	for(var i=1;i<=lastday;i++){
		app += "<option ";
		if(i==dd){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>일";
	
	app += "&nbsp;<select name='hour' >";
	for(var i=0;i<=24;i++){
		app += "<option ";
		if(i==hh){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>시";
	
	app += "&nbsp;<select name='min' >";
	for(var i=0;i<=60;i+=5){
		app += "<option ";
		if(i==mi){ app += "selected='selected'"; }
		var ii = i;
		if(i<10){ii="0"+i;}
		app += ">"+ii+"</option>";
	}
	app += "</select>분</span>";	
	
	$("#skddate").append(app);
}

</script>


