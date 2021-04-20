<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

	<form action="bbsanswerAF.do" id="frmFormSearch" method="get">
		<h3 style="text-align: left;">원본글</h3>
		<table class="list_table" style="width: 85%" id="_list_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>
		  
		  <tr>
	   		<th style="background: #eee; color: #3e5fba;">작성자</th>
			<td style="text-align:left">&nbsp;${bbs.id}<input type="hidden" name="seq" value="${bbs.seq}"></td>
			
		  </tr>
		  
		  <tr>
	   		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;${bbs.title}</td>
		  </tr>
		  
		  <tr>
	   		<th style="background: #eee; color: #3e5fba;">작성일</th>
			<td style="text-align:left">&nbsp;
				<fmt:parseDate value="${bbs.wdate}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				${date}
			</td>
		  </tr>
		  
		  <tr>
	   		<th style="background: #eee; color: #3e5fba;">내 용</th>
			<td colspan="2" style="text-align:left">&nbsp;
				<textarea rows="8" cols="98" readonly="readonly" style="border: 1px solid #ddd; resize: none;">${bbs.content}</textarea>
			</td>
		  </tr>
		  
		</table>
		
		<br><hr>
		<h3 style="text-align: left;">답글</h3>
		<table class="list_table" style="width: 85%" id="_list_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>

		  <tr>
    		<th style="background: #eee; color: #3e5fba;">아이디</th>
			<td style="text-align:left">&nbsp;
				<input type="text" name="id" value="${login.id}" size="100%" readonly="readonly" style="border: 1px solid #ddd">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;
				<input type="text" name="title" size="100%" style="border: 1px solid #ddd">
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">내 용</th>
			<td colspan="2" style="text-align:left">&nbsp;
				<textarea rows="20" cols="98" name="content" style="border: 1px solid #ddd;"></textarea>
			</td>
		  </tr>
		  
		  <tr>
			 <td colspan="2">
				 <span class="button blue large">
                 	<input type="submit" value="답글작성완료">
				 </span>
			 </td>
		  </tr>
		
		</table>
		
	</form>
	
</div>



<script type="text/javascript">
function updateBbs(seq) {
	location.href = "bbsupdate.do?seq=" + seq;
}

function deleteBbs(seq) {
	location.href = "bbsdelete.do?seq=" + seq;
}

function answerbbs(seq) {
	location.href = "answer.do?seq=" + seq;	
}

</script>

