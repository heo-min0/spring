<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="list_table" style="width: 85%" id="_list_table">
  <colgroup>
  	<col style="width:70px">
  	<col style="width:auto">
  	<col style="width:200px">
  </colgroup>
  
  <tr>
    <th>번호</th><th>제목</th><th>일정</th>
  </tr>
  
  <c:if test="${empty daylist}">
	<tr><td colspan="3">작성된 글이 없습니다.</td></tr>
  </c:if>
  
  <c:if test="${!empty daylist}">
	<c:forEach var="list" items="${daylist}" varStatus="i">
		<tr>
			<th>${i.count}</th>
			<td>
				<a href="calendardetail.do?seq=${list.seq}">
				${list.title}
				</a>
			</td>
			<td>
				<fmt:parseDate value="${list.rdate}" var="sdate" pattern="yyyyMMddHHmm"/>
				<fmt:formatDate value="${sdate}" var="date" pattern="yyyy-MM-dd HH:mm"/>
				${date}
			</td>
		</tr>
	</c:forEach>
  </c:if>
  
</table>

