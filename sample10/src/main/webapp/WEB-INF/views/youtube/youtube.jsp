<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String str = (String)request.getAttribute("yulist");
   if(str == null || str.equals("")){str = "";}	%>

<p id="demo"></p>

<script type="text/javascript">
$(function() {
	let str ='<%=str%>';
	//alert(str);
	
	json = JSON.parse(str);
	//alert(json);
	$("#demo").val(json);
	
	let obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents[1].shelfRenderer.content.verticalListRenderer.items;
	$.each(obj, function (i,item) {
		//console.log(item.videoRenderer.videoId);
		//console.log(item.videoRenderer.title.runs[0].text);
		
		let s = "<tr>"
		+ "<td>" + (i+1) + "</td>"
		+ "<td style='text-align:left'><div class='c_vname' vname='"+item.videoRenderer.videoId+"'>"
		+ item.videoRenderer.title.runs[0].text + "</div></td>"
		+ "<td>" + item.videoRenderer.videoId + "</td>"
		+ "<td>"
		+ "<img src='image/save.png' class='ck_seq' id=\""+ item.videoRenderer.videoId +"\" loginIn='${login.id}' title=\""+ item.videoRenderer.title.runs[0].text +"\" >"
		+ "</td>"
		+ "</tr>";
		
		$("#tbody").append(s);
	});
	
	obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents;
    $.each(obj, function (i, item) {
      if(item.videoRenderer != undefined){
         let s = "<tr>"
         + "<td>" + (i + 1) + "</td>"
         + "<td style='text-align: left;'><div class='c_vname' vname='" + item.videoRenderer.videoId + "'>" + item.videoRenderer.title.runs[0].text + "</div></td>"
         + "<td>" + item.videoRenderer.videoId + "</td>"
         + "<td><img src='image/save.png' class='ck_seq' id='" + item.videoRenderer.videoId + "'   loginIn='${login.id}' title='" + item.videoRenderer.title.runs[0].text + "'></td>"
         + "</tr>";
      
         $("#tbody").append(s);
      }
    });
	
	obj = json.contents.twoColumnSearchResultsRenderer.primaryContents.sectionListRenderer.contents[0].itemSectionRenderer.contents;
	$.each(obj, function (i,item) {
		//console.log(item.videoRenderer.videoId);
		//console.log(item.videoRenderer.title.runs[0].text);
		
	});
		
	
});
</script>




<div class="box_order" style="margin: 5px 0 10px 0">
<form id="frmForm" method="post">

	<table style="margin: 3px auto">
		<tr>
			<td>검색:</td>
			<td style="padding-left: 5px">
				<input type="text" id="_s_keyword" name="s_keyword" value="${empty s_keyword?'':s_keyword}">
			</td>
			<td style="padding-left: 5px">
				<span class="button blue">
					<button type="button" id="_btnSearch">검색</button>
				</span>
			</td>
		</tr>
	
	</table>

</form>
</div>



<div id="_youtube_">
	<iframe id="_youtube" width="640" height="360" src="http://www.youtube.com/embed/"
		frameborder="0" allowfullscreen>
	</iframe>
</div>

<table class="list_table" style="width: 85%">
	<colgroup>
		<col width="70px"><col width="auto">
		<col width="100px"><col width="50px">
	</colgroup>
	
	<thead>
		<tr>
	   		<th>번호</th><th>제목</th><th>유튜브 고유번호</th><th>저장</th>
	  	</tr>
	</thead>
	
	<tbody id="tbody"></tbody>
	
</table>




<!-- //responseContext -->
<script type="text/javascript">
$("#_btnSearch").click(function () {
	//alert("123");
	$("#frmForm").attr("action","youtube.do").submit();
});

$(document).on("click", ".c_vname", function () {
	$("#_youtube").attr("src","http://www.youtube.com/embed/"+ $(this).attr("vname"));
});


$(document).on("click", ".ck_seq", function () {
	let id = $(this).attr("loginIn");
	let title = $(this).attr("title");
	let url = $(this).attr("id");
	
	$.ajax({
		url:"./youtubesave.do",
		type:"post",
		async:true,
		data:{
			"id":id,
			"title":title,
			"url":url
		},
		success:function(msg){//alert(msg);
		
		},
		error:function(){ alert('error'); }
	});
	
});



</script>






