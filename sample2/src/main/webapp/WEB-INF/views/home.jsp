<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>home.jsp</h2>

<%-- <% String name = (String)request.getAttribute("_name"); %>
이름 : <%=name%> --%>

이름 : ${_name }
<br>

<form action="world.do">
이름입력:<input type="text" value="" name="name">
<br>
나이입력:<input type="text" value="" name="age">
<input type="submit" value="전송">
</form>

<!-- <a href="world.do?age=24&name=일지매">world 이동</a> -->


</body>
</html>