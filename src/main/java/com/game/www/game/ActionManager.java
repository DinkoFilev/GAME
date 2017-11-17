package com.game.www.game;

import com.game.www.GameObject;
import com.game.www.game.heroes.Hero;

public class ActionManager {
	

	public static String prepareMsg(GameObject go, Hero attacker, Hero oponent) {
		String msg = "";
		switch(go.getCommand()) {
			case "JOIN":
				go.setMsg(msg = go.getNickname() + " has joined the game. And choose " + go.getHero() +" as hero");

				break;
			
			case "ATTACK":
				go.setMsg(attacker.getName() + " attempt to attack " + oponent.getName() +" , "
				+ oponent.getName()+ " lose " + String.valueOf(go.getLostHP())+" Points. ");
				break;
			default :
				
		}
		return msg;
	}
}
