<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%MemberDto mem = (MemberDto)session.getAttribute("login");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>bbswrite</title>
</head>
<body>
<!-- 글 작성 -->

<form action="writeAF.do" method="post">

	<div align="center" style="margin: 30px">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=mem.getId() %><input type="hidden" name="id" value="<%=mem.getId()%>"></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" size="68" id="title" name="title"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td align="center"><textarea rows="20" cols="70" name="content"></textarea></td>
			</tr>
		</table>
	</div>

	<div align="center">
		<button type="submit" style="font-size: 18px;">글추가</button>
	</div>
	
</form>


</body>
</html>

