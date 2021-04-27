<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<table class="list_table" style="width: 85%">
  <colgroup><col width="200px"><col width="500px"></colgroup>
  
  <tr>
    <th>대화명</th>
    <td style="text-align: left;">
    	<input type="text" id="name">
    	<input type="button" id="enterBtn" value="입장" onclick="connect()">
    	<input type="button" id="exitBtn" value="나가기" onclick="disconnect()">
    </td>
  </tr>
  
  <tr>
    <th>아이디</th>
    <td style="text-align: left;">
    	<input type="text" id="id" value="${login.id}">
    </td>
  </tr>
  
  <tr>
    <td colspan="2">
    	<textarea rows="10" cols="70" id="MessageArea"></textarea>
    </td>
  </tr>
  
  <tr>
    <td colspan="2">
    	<input type="text" id="message" size="50">
    	<input type="button" id="sendBtn" value="전송" onclick="send()">
    </td>
  </tr>
  
</table>

    
<script type="text/javascript">
let wsocket;

function connect() { //접속
	if(wsocket != undefined && wsocket.readyState != WebSocket.CLOSED){
		alert("이미 입장했습니다.");
		return;
	}
	
	// 웹 소켓 생성
	/* if( $("#name").val == "aaa" ) {
		wsocket = new WebSocket("ws://localhost:8090/sample10/echo.do");
	}
	else{
		wsocket = new WebSocket("ws://192.168.0.220:8090/sample10/echo.do");
	} */
	
	wsocket = new WebSocket("ws://192.168.0.220:8090/sample10/echo.do");
	
	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.close = onClose;
	
}
function disconnect() { //접속 중단
	wsocket.close();
	location.href = "chating.do";
}
function onOpen(evt) { //서버 연결될 때 자동호출
	appendMessage("연결되었습니다.")
}
function onMessage(evt) { //수신이 되었을 때 자동호출
	let data = evt.data;
	if(data.substring(0,4) == "msg:" ){
		appendMessage( data.substring(4) );
	}
}
function onClose(evt) { //접속이 끊겼을 때
	appendMessage( "연결이 끊겼습니다." );
}
function send() { //메시지송신
	let id = $("#name").val();
	let msg = $("#message").val();
	
	wsocket.send("msg:"+id+":"+msg);
	$("#message").val("");
}
function appendMessage(msg) { //추가 문자열 기입
	// 메시지 주고 개행
	$("#MessageArea").append(msg+"\n");
	
	//스크롤을 위로 이동 시킨다
	const top = $("#MessageArea").prop("scrollHeight");
	$("#MessageArea").scrollTop(top);
}
</script>









