<%@page import="bit.com.a.dto.MyClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h3>hello.jsp</h3>

<!-- 1 controller > *.jsp -->
<% MyClass cls = (MyClass)request.getAttribute("mycls"); %>
번호:<%= cls.getNumber() %><br>
이름:<%= cls.getName() %><br>
<br>

number:${mycls.number}<br>
name:${mycls.name}<br>
<br><br>


<!-- 2 -->
<form action="move.do" method="post">
번호:<input type="text" name="number" size="20"><br>
이름:<input type="text" name="name" size="20"><br>
<input type="submit" value="이동"><br>
</form>
<br><br>


<!-- 3 -->
아이디:<input type="text" id="checkid"><br>
<br>
<button type="button" onclick="idcheck()">아이디 체크</button>

<script type="text/javascript">
function idcheck() {
	
	$.ajax({
		url:"idcheck.do",
		type:"get",
		//data:"id="+$("#checkid").val(),
		data:{id:$("#checkid").val()},
		success:function(data){
			//alert('success');
			alert(data);
		},
		error:function(){
			alert('error');
		}
		
	});
	
}
</script>
<br><br>


<!-- 4 -->
	<!-- json(web) > Object(controller)
	map(controller) > json(web) -->
이름:<input type="text" id="name" value="홍길동"><br>
전화:<input type="text" id="phone" value="123-4567"><br>
이메일:<input type="text" id="email" value="hgd@naver.com"><br>
생년월일:<input type="text" id="birth" value="2001/11/22"><br>
<button type="button" id="account">회원가입</button>

<script type="text/javascript">
$("#account").click(function() {
	//alert('click');
	
	let human = {
			name:$("#name").val(),
			phone:$("#phone").val(),
			email:$("#email").val(),
			birth:$("#birth").val()
	};
	
	$.ajax({
		url:"./account.do",
		type:"post",
		dataType :"json",
		data:human,
		async:true,
		success:function(data){
			//alert('success');
			//alert(JSON.stringify(data)); json > string 반대는 JSON.parse()
			alert(data.message);
			alert(data.name);
		},
		error:function(){
			alert('error');
		}
		
	});
	
});
</script>
<br><br>


<!-- 리스트 확인 -->



<div id="datas"></div>

<button type="button" onclick="read()">data read</button>

<script type="text/javascript">
function read() {
	
	$.ajax({
		url:"read.do",
		type:"get",
		success:function(data){
			//alert('success');
			//alert(JSON.stringify(data));
			let str = '';
			$.each(data,function(i,item){
				str += i + " ";
				str += item.number + " ";
				str += item.name + "<br>";
			})
			$("#datas").html(str);
			
			/* for(i in data){
				$("#datas").append(data[i].number + ":");
				$("#datas").append(data[i].name + ", ");
			} */
		},
		error:function(){alert('error');}
	});
	
}
</script>


</body>
</html>










