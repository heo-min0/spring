<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<% List<BbsDto> list = (List<BbsDto>)request.getAttribute("bbslist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="list" items="${bbslist}">
	<c:out value="${list}"/><br>
</c:forEach>


</body>
</html>