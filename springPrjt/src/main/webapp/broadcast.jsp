<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing websockets</title>
</head>
<body>
	<fieldset>
		<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
		<br /> <input id="inputMessage" type="text" /> <input type="submit"
			value="send" onclick="send()" />
	</fieldset>
</body>
<script type="text/javascript">
 var textarea = document.getElementById("messageWindow");
 var webSocket = new WebSocket('ws://192.168.0.82/web/broadcasting');
 var inputMessage = document.getElementById('inputMessage');
 webSocket.onerror = function(event) {
 	onError(event)
 };
 webSocket.onopen = function(event) {
	 onOpen(event)
 };
 webSocket.onmessage = function(event) {
	 onMessage(event)
 };
 
 function onMessage(event) {
	 textarea.value += " : 상대 " + event.data + "\n";
	 chatAreaScroll();
 }

function onOpen(event) {
 	textarea.value += " \n" + "연결 성공 ";
}

 function onError(event) {
	 console.log(event);
	 alert(event.data);
}

 function send() {
	 textarea.value += " : 유미 "  + inputMessage.value + "\n";
	 webSocket.send(inputMessage.value);
	 inputMessage.value = "";
}
 
function chatAreaScroll() {
	//using jquery
	var textArea = $('#messageWindow');
	textArea.scrollTop( textArea[0].scrollHeight - textArea.height() );
	textArea.scrollTop( textArea[0].scrollHeight);
	//using javascript
	var textarea = document.getElementById('messageWindow');
	textarea.scrollTop = textarea.scrollHeight;
}
</script>
</html>