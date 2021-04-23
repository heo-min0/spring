<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="frmForm" id="_frmForm" action="pdsupload.do" method="post" enctype="multipart/form-data">

	<table class="list_table">
	
		<tr>
			<th>아이디</th>
			<td style="text-align:left">
				<input type="text" name="id" readonly="readonly" value="${login.id}" size="50">
				<input type="hidden" name="seq" value="${pdsdto.seq}">
			</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td style="text-align:left">
				<input type="text" name="title" size="50" value="${pdsdto.title}" >
			</td>
		</tr>
		
		<tr>
			<th>업로드한 파일</th>
			<td style="text-align:left">
				<input type="text" name="filename" value="${pdsdto.filename}" readonly="readonly">
				<input type="hidden" name="newfilename" value="${pdsdto.newfilename}">
			</td>
		</tr>
		
 		<tr>
			<th>변경할 파일업로드</th>
			<td style="text-align:left">
				<input type="file" name="fileload" style="width: 400px">
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td style="text-align:left">
				<textarea rows="10" cols="50" name="content" style="resize: none;">${pdsdto.content}</textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align:center; height: 50px;">
				 <span class="button blue large">
                 	<input type="button" id="_btnPds" value="수정완료">
				 </span>
			</td>
		</tr>
	
	</table>
	
</form>


<script type="text/javascript">
$("#_btnPds").click (function name() {
	$("#_frmForm").submit();
});

</script>










