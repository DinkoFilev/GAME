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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/game.css">
</head>
<body>
	<h1>----------------------------------------WELCOME
		TEXT-------------------------------------</h1>
	<div class="js-container-left">
	<p>Your Char </p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active"
				role="progressbar" aria-valuenow="40" aria-valuemin="0"
				aria-valuemax="100" style="width: 40%">40%</div>
		</div>
	</div>
	<div class="js-container-right">
	<p>Opponent</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active"
				role="progressbar" aria-valuenow="40" aria-valuemin="0"
				aria-valuemax="100" style="width: 40%">40%</div>
		</div>
	</div>
	<div class="js-game-window">
		<p class="test">asdasfas</p>
	</div>
	<div class="js-game-buttons">

		<input class="button" type="button" value="ATTACK"> <input
			class="button" type="button" value="USE SKILL"> <input
			class="button" type="button" value=""> <input class="button"
			type="button" value="BUTTON"> <input class="button"
			type="button" value="CHOOSE WEAPON"> <input class="button"
			type="button" value="OPTIONS">

	</div>

</body>
</html>
