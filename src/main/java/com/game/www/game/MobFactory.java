package com.game.www.game;

import java.util.HashMap;

import com.game.www.game.mobs.Mob;
import com.game.www.game.mobs.OrcChief;
import com.game.www.game.weapons.Weapon;

public class MobFactory {
	private HashMap<String, Weapon> mobWeapons = new HashMap();
	
	//initialize mob weapons
	

	private static MobFactory instance;

	private MobFactory() {
		mobWeapons.put("FIST",new Weapon("FIST", 7, 10, 10, 0.15));

	}

	public static MobFactory getInstance() {
		if (instance == null) {
			instance = new MobFactory();
		}
		return instance;
	}

	public Mob getMob(String type) {

		switch (type) {
		case GameConstants.ORC_CHIEF :
			return new OrcChief(2, 10, 2, 30, mobWeapons.get("FIST"));
		default:
			return null;
		}

	}
}
