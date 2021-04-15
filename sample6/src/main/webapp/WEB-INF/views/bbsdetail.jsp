<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%MemberDto mem = (MemberDto)session.getAttribute("login");
BbsDto dto = (BbsDto)request.getAttribute("bbsdto");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center" style="margin: 20px">
<table border="1">
	<col width="100px">
<tr>
	<th>작성자</th>
	<td><%=dto.getId() %></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>
<tr>
	<th>제 목</th>
	<td><%=dto.getTitle() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>
<tr>
	<th>정 보</th>
	<td><%=dto.getRef() %>-<%=dto.getStep() %>-<%=dto.getDepth() %></td>
</tr>
<tr>
	<th>내 용</th>
	<td>
	<textarea rows="20" cols="70" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>
</table>
</div>

<div align="center">
<%if(mem.getId().equals(dto.getId()) ){ %>
	<button type="button" id="del"
	 onclick="location.href='bbsdel.do?seq=<%=dto.getSeq() %>'"
	 style="font-size: 18px">글삭제</button>
	<button type="button" id="update" onclick="location.href='bbsupdate.do?seq=<%=dto.getSeq() %>'"
	 style="font-size: 18px">글수정</button>
<%}%>
	<button type="button" id="list" onclick="location.href='pagebbslist.do'" style="font-size: 18px">글목록</button>
	<button type="button" onclick="location.href='bbsanswer.do?seq=<%=dto.getSeq() %>'"
	 style="font-size: 18px">답글</button>
</div>

</body>
</html>





