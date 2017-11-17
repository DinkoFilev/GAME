<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%
	response.addHeader("Cache-Control",
			"no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0");
	response.addHeader("Pragma", "no-cache");
	response.addDateHeader("Expires", 0);
%>
<html>
<head>
<title>GAME</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Chat WebSocket</title>
        <script src="static/js/sockjs-0.3.4.js"></script>
        <script src="static/js/stomp.js"></script>
        <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="static/css/game.css">
        <script type="text/javascript">
     
        </script>
        <script src="static/js/chat.js"></script>
        <script src="static/js/game.js"></script>

</head>
<body onload="disconnect()">
	<div class="js-game-connect">
            <div>
                <input type="text" id="from" placeholder="Choose a nickname"/>
            </div>
            <br />
            <div>
                <button id="connect" onclick="connect(); showGameMenu();">Connect</button>
                <button id="disconnect" disabled="disabled" onclick="disconnect();">
                    Disconnect
                </button>
            </div>
            <br />
            
        </div>
	<div class="js-container-left js-hp-bars hidden ">
	<p class="js-attacker-hp-bar-name" >Your Char </p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active js-attacker-progress"
				role="progressbar" aria-valuenow="40" aria-valuemin="0"
				aria-valuemax="100" style="width: 40%">40%</div>
		</div>
	</div>
	<div class="js-container-right js-hp-bars hidden">
	<p class="js-oponent-hp-bar-name">Opponent</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active js-oponent-progress"
				role="progressbar" aria-valuenow="40" aria-valuemin="0"
				aria-valuemax="100" style="width: 40%">40%</div>
		</div>
	</div>
	<div id="game-window" class="js-game-window">
		<jsp:include page="gamemenu.jsp" />
		<div id="js-game-content" class="js-game-content">
		
		</div>
	</div>
	<div class="js-game-buttons">
		<input type="hidden" id="nickname"/>
		<input class="btn btn-primary js-game-button" type="button" value="ATTACK"> 
		<input class="btn btn-primary js-game-button" type="button" value="USE SKILL">
		<input class="btn btn-primary js-game-button" type="button" value="BUTTON">
	    <input class="btn btn-primary js-game-button" type="button" value="BUTTON">
		<input class="btn btn-primary js-game-button" type="button" value="CHOOSE WEAPON">
		<input class="btn btn-primary js-game-button" type="button" value="OPTIONS">
			

	</div>
     <div id="conversationDiv">
             <input type="text" id="text" placeholder="Write a message..."/>
             <button id="sendMessage" onclick="sendMessage();">Send</button>
             <p id="response"></p>
     </div>
     
</body>
</html>
