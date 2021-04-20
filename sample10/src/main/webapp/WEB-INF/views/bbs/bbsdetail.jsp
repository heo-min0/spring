<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 검색부분 -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

	<form action="" id="frmFormSearch" method="get">
	
		<table class="list_table" style="width: 85%" id="_list_table">
		  <colgroup>
		  	<col style="width:70px">
		  	<col style="width:auto">
		  </colgroup>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">작성자</th>
			<td style="text-align:left">&nbsp;
				${bbs.id}
			</td>
		  </tr>
		  
		  <tr>
    		<th style="background: #eee; color: #3e5fba;">제 목</th>
			<td style="text-align:left">&nbsp;
				${bbs.title}
			</td>
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
				<textarea rows="20" cols="98" readonly="readonly" style="border: 1px solid #ddd; resize: none;">${bbs.content}</textarea>
			</td>
		  </tr>
		  
		  <tr>
			 <td colspan="2">
			 	<c:if test="${bbs.id eq login.id}">
					 <span class="button blue large">
	                 	<input type="button" value="글수정" onclick="updateBbs(${bbs.seq})">
					 </span>
					 <span class="button blue large">
	                 	<input type="button" value="글삭제" onclick="deleteBbs(${bbs.seq})">
					 </span>
               	</c:if>
               	<c:if test="${bbs.id ne login.id}">
					 <span class="button blue large">
	                 	<input type="button" value="답글달기" onclick="answerbbs(${bbs.seq})">
					 </span>
                </c:if>
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
	location.href = "bbsanswer.do?seq=" + seq;	
}

</script>

