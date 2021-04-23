<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table class="list_table">

	<tr>
		<th>아이디</th>
		<td style="text-align:left">
			<input type="text" name="id" readonly="readonly" value="${login.id}" size="50">
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td style="text-align:left">
			<input type="text" name="title" size="50" value="${pdsdto.title}" readonly="readonly">
		</td>
	</tr>
	
	<tr>
		<th>업로드한 파일</th>
		<td style="text-align:left">
			<input type="text" value="${pdsdto.filename}" readonly="readonly">
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td style="text-align:left">
			<textarea rows="10" cols="50" name="content" readonly="readonly" style="resize: none;">${pdsdto.content}</textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align:center; height: 50px;">
			<a href="#none" id="_btnPds" title="자료수정">
				<img alt="" src="image/bupdate.png">
			</a>
			<a href="#none" id="_delPds" title="자료수정">
				<img alt="" src="image/del.png">
			</a>
		</td>
	</tr>

</table>
	
<script type="text/javascript">
$("#_btnPds").click (function name() {
	location.href="pdsupdate.do?seq=${pdsdto.seq}";
});
$("#_delPds").click (function name() {
	location.href="pdsdel.do?seq=${pdsdto.seq}";
});
</script>










