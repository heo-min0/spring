<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 검색부분 -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

	<form action="bbswriteAf.do" id="frmFormSearch" method="get">
	
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
                 	<input type="submit" value="글쓰기">
				 </span>
			 </td>
		  </tr>
		  
		</table>
		
	</form>
	
</div>



