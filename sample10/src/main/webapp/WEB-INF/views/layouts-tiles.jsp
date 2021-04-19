<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 	<!-- 포맷 tag   time, encoding -->
<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<tiles:insertAttribute name="header"/> <!-- 링크파일만 모아놓는 --> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css"> <!-- 현재경로를 불러온다 request.getContextPath() -->

</head>
<body>

<div id="body_wrap">

	<div id="main_wrap">
		<tiles:insertAttribute name="top_inc"/>
		<tiles:insertAttribute name="top_menu"/>
	</div>
	
	<div id="middle_wrap">
	
		<div id="sidebar_wrap">
			<tiles:insertAttribute name="left_menu"/>
		</div>
	
		<div id="content_wrap">
			<div id="content_title_wrap">
				<div class="title">${doc_title}</div>
			</div>
			
			<tiles:insertAttribute name="main"/>
			
		</div>
		
	</div>
	
	<div id="footer_wrap">
		<tiles:insertAttribute name="bottom_inc"/>
	</div>
	
</div>


<script type="text/javascript">
$(document).ready(function(){
	$("content_title_wrap div.title").css("background-color","url('./image/ico_sub_sb.gif')")
});

</script>


</body>
</html>









