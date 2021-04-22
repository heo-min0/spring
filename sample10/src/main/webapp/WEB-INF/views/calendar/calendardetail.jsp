<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px; ">
	<form action="" id="frmFormSearch" method="get">
		<table class="list_table" style="width: 85%;" id="_write_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">작성자</th>
			<td style="text-align:left">&nbsp;
				${caldto.id}
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;
				${caldto.title}
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">일 정</th>
			<td style="text-align:left">&nbsp;
				<fmt:parseDate value="${caldto.rdate}" var="sdate" pattern="yyyyMMddHHmm"/>
				<fmt:formatDate value="${sdate}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				${date}
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
                 	<input type="submit" value="일정수정">
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

$("#skddel").click( function() {
	location.href = "calendardel.do?seq=${caldto.seq}";
});


</script>






