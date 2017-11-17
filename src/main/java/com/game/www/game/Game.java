package com.game.www.game;

import java.util.HashMap;
import java.util.Random;

import com.game.www.GameObject;
import com.game.www.game.heroes.Hero;
import com.game.www.game.mobs.Mob;

public class Game {
	HeroFactory heroFactory = HeroFactory.getInstance();
	Hero attacker;
	Hero oponent;
	Mob mob;
	MobFactory mobFactory = MobFactory.getInstance();
	HashMap<String,Hero> room = new HashMap<String,Hero>(); // NAME -> HERO

	private static Game instance;

	

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}
	
	public GameObject play(GameObject go) {
		
		if (!room.containsKey(go.getNickname()) && room.size() < 2 && go.getHero() != null) {
			Hero hero = heroFactory.getHero(go.getHero(), go.getNickname());
		 room.put(go.getNickname(),  hero);
		}
		HashMap<String,Hero> roomCache = new HashMap<String,Hero>(room); // NAME -> HERO
		if (roomCache.size() == 2) {
			this.attacker = roomCache.get(go.getNickname());
			roomCache.remove(go.getNickname());
			for (Hero value : roomCache.values()) {
			   this.oponent = value;
			}
			setEnemiesHP(go, attacker, oponent);
			ActionManager.prepareMsg(go , attacker, oponent);
			if (go.getCommand().equals("ATTACK")) {
				attack(go, attacker, oponent);
				
				if (!oponent.isAlive()) {
					go.setDeadMSG(" "+attacker.getName() + " WIN THE MATCH " + oponent.getName() + " IS DEAD ");
				}
				setEnemiesHP(go, attacker, oponent);
				go.setAttacker(attacker.getName());
				go.setOponent(oponent.getName());
				return go;
			}
						
		}
		ActionManager.prepareMsg(go , attacker, oponent);
		return go;
	}
	
	public GameObject attack(GameObject go, Hero attacker, Hero oponent) {
		int dmgDiff = attacker.getMaxDMG() - attacker.getMinDMG();
		int attackerDMG = dmgDiff == 0 ? attacker.getMinDMG() : attacker.getMinDMG() + new Random().nextInt(dmgDiff);
		int hpToDecrease = attackerDMG - oponent.getArmor();
		if (hpToDecrease > 0 ) {
			oponent.setHealth(oponent.getHealth() - hpToDecrease);
			go.setLostHP(hpToDecrease);
		} else {
			go.setMsg("You doesn't have enough strength to harm "+ oponent.getName());
			return go;
		}
		
		ActionManager.prepareMsg(go , attacker, oponent);
		return go;
	}
	
	private void setEnemiesHP (GameObject go, Hero attacker, Hero oponent) {
		if (attacker != null && oponent != null) {
			go.setAttackerHP(String.valueOf(attacker.getHealth()));
			go.setOponentHP(String.valueOf(oponent.getHealth()));
		}

	}
	
}
