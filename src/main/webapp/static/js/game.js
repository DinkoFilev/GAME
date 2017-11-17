'use strict'
 var stompGameClient = null;
             
function disableButtons(turn) {
	if (turn) {
		$('.js-game-button').removeClass('disabled');
		return;
	}
	
	$('.js-game-button').addClass('disabled');
	
	
	
}

function showGameMenu(){
	gameConnect();
	var nickname = document.getElementById('from').value;
	document.getElementById('nickname').value = nickname;
	$('.js-game-menu').toggleClass('hidden');
	$('.js-game-menu input').on('click',function(){
		var hero = $(this).val();
		$('.js-game-menu').toggleClass('hidden');
		$('.js-hp-bars').toggleClass('hidden');
		$('.js-chosenhero').val(hero);
		sendCommand('JOIN',hero);
		initializeEvents();
		
		});

}
 
function gameConnect() {
	
    var socket = new SockJS('/game/play');
    stompGameClient = Stomp.over(socket);  
    stompGameClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompGameClient.subscribe('/topic/game', function(messageOutput) {
            showGameOutput(JSON.parse(messageOutput.body));
        });
    });
}
 
function disconnect() {
    if(stompGameClient != null) {
        stompGameClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
 
function sendCommand(command, hero) {
	var heroCache = hero || $('.js-chosenhero').val();
	var nickname = document.getElementById('nickname').value;
    stompGameClient.send("/app/play", {}, 
    	JSON.stringify({'nickname':nickname, 'command':command, 'hero':heroCache}));
}
 
function showGameOutput(messageOutput) {
	updateHP(messageOutput);
    var response = document.getElementById('js-game-content');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.msg));
    if (messageOutput.deadMSG){
    	document.createElement('p').appendChild(document.createTextNode(messageOutput.deadMSG));
    	response.appendChild(p);
    	disconnect();
    	return;
    }
   
    response.appendChild(p);
    disableButtons(true);
}

function updateHP(messageOutput) {
	
	var attacker;
	var oponent;
	if (messageOutput.nickname == $('#nickname').val()){
		attacker =  $('.js-attacker-progress');
		oponent = $('.js-oponent-progress');
	}else{
		oponent =  $('.js-attacker-progress');
		attacker = $('.js-oponent-progress');
	}
	
	updateNames(messageOutput , attacker , oponent);
	if (messageOutput.command == "JOIN"){
		
		attacker.attr('aria-valuemax: '+messageOutput.attackerHP+'');
		oponent.attr('aria-valuemax: '+messageOutput.oponentHP+'');
		attacker.attr('style','width: 100%');
		oponent.attr('style','width: 100%');
	}
	var atkHPWidth = 100.0/attacker.attr('aria-valuemax');
	var opoHPWidth = 100.0/oponent.attr('aria-valuemax');
	
	attacker.attr('style','width: '+messageOutput.attackerHP*atkHPWidth+'%');
	oponent.attr('style','width: '+messageOutput.oponentHP*opoHPWidth+'%');
	attacker.html(messageOutput.attackerHP);
	oponent.html(messageOutput.oponentHP);
	if (attacker.html() == 0) {
		attacker.html('DEAD')
	}else if (oponent.html() == 0){
		oponent.html('DEAD')
	}
}

function updateNames(messageOutput, attacker , oponent){
	attacker.closest('.js-hp-bars').find('p').html(messageOutput.attacker);
	oponent.closest('.js-hp-bars').find('p').html(messageOutput.oponent);
	
}

function initializeEvents(){
	$('.js-game-button').on('click',function(){
		var command = $(this).val();
		sendCommand(command);
	});
	
}

