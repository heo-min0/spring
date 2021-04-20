<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 검색부분 -->
<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

	<form action="" id="frmFormSearch" method="get">
	
		<table style="margin:3px auto;">
			<tr>
				<td>검색</td>
				<td style="padding-left: 5px">
					<select id="_choice" name="choice">
						<option value="" selected="selected">선택</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="writer">작성자</option>
					</select>
				</td>
				<td style="padding-left: 5px">
					<input type="text" id="_searchWord" name="searchWord">
				</td>
				<td style="padding-left: 5px">
					<span class="button blue">
						<button type="button" id="btnSearch">검색</button>
					</span>
				</td>
			</tr>
		</table>
		
	</form>
	
</div>


<table class="list_table" style="width: 85%" id="_list_table">
  <colgroup>
  	<col style="width:70px">
  	<col style="width:auto">
  	<col style="width:70px">
  	<col style="width:100px">
  </colgroup>
  
  <tr>
    <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
  </tr>
</table>

<br><br>

<div class="container">
	<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination" style="justify-content: center;"></ul>
	</nav>
</div>

<br><br>

<script type="text/javascript">
//getBbsListData(0);
getBbsListCount();

//검색?
$("#btnSearch").click(function(){
	//getBbsListData(0);
	getBbsListCount();
});

//bbslist를 가져오는 부분 페이지 누를때 마다 가져오는
function getBbsListData(pNumber) {
	$.ajax({
		url:"./bbslistData.do",
		type:"get",
		data:{
			page:pNumber,
			choice:$("#_choice").val(),
			search:$("#_searchWord").val()
		},
		success:function(list){//alert(list);
			$(".list_col").remove();
			$.each(list,function (i,val){
				let app = ""
				if(val.del == 1){
					app = "<tr class='list_col'>"
						+ "<td>" + (i+1) + "</td>"
						+ "<td colspan='4' style='text-align:left; color:red'>* 이 글은 작성자에 의해서 삭제되었습니다. *</td>"
						+ "</tr>";
				}else{
					app = "<tr class='list_col'>"
						+ "<td>" + (i+1) + "</td>"
						+ "<td style='text-align:left'>"
			          	+ arrow(val.depth) //댓글이미지 자바스크립트로 만듦
						+ "<a href='bbsdetail.do?seq="+val.seq+"'>"+val.title+"</a>"
						+ "</td>"
						+ "<td>"+val.readcount+"</td>"
						+ "<td>"+val.id+"</td>"
						+ "</tr>";
				}
				$("#_list_table").append(app);
			});
		},
		error:function(){alert('error');}
	});
}
//글의 총 수를 구하는 함수 필요
function getBbsListCount() {
	$.ajax({
		url:"./bbslistCount.do",
		type:"get",
		data:{
			choice:$("#_choice").val(),
			search:$("#_searchWord").val()
		},
		success:function(count){ loadPage(count); },
		error:function(){ alert('error'); }
	});
}
//페이지 처리를 하는 함수 필요
function loadPage(totalCount) {
	let pageSize = 10;
	let nowPage = 1;
	
	let _totalPages = totalCount / pageSize;
	console.log("페이지수:"+_totalPages);
	
	if(totalCount % pageSize > 0){
		//_totalPages = Math.ceil(_totalPages);
		_totalPages++;
	}
	
	$("#pagination").twbsPagination("destroy"); //초기화
	
	$("#pagination").twbsPagination({
	//	startPage: 1,
		totalPages: _totalPages,
		visiblePages:5, //페이지번호를 몇개까지 보일건가
		first:'<span sria-hidden="true">«</span>',
		prev:"이전",
		next:"다음",
		last:'<span sria-hidden="true">»</span>',
		//initiateStartPageClick:false, //온 페이지 클릭이 자동실행여부 결정
		onPageClick:function(event,page){
			nowPage = page;
			//alert('nowPage : '+page);
			getBbsListData(page-1);
		}
	});
	
	//$("#pagination").twbsPagination("changeTotalPages",_totalPages,nowPage);
}
//댓글 화살표 넣는 함수
function arrow(depth) {
	let rs = "<img src='./image/arrow.png' width='10px' height='10px'/>&nbsp;";
	let nbsp = "&nbsp;&nbsp;"; //여백
	let ts = "";
		
	for(var i=0;i<depth;i++){ts+=nbsp;}
	return depth==0?"":ts+rs;
}
</script>















<%--   <c:if test="${empty bbslist}">
  	<tr><td colspan="3">작성된 글이 없습니다.</td> </tr>
  </c:if>
  
  <c:forEach items="${bbslist}" var="bbs" varStatus="vs">
  	<tr>
  		<td>${vs.count}</td>
  		<td style="text-align: left;">
  			<a href="bbsdetail.do?seq${bbs.seq}">${bbs.title}</a>
  		</td>
  		<td>${bbs.id}</td>
  	</tr>
  </c:forEach> --%>