package com.game.www.game.mobs;

import com.game.www.game.GameConstants;
import com.game.www.game.weapons.Weapon;

public class OrcChief extends Mob{

	public OrcChief(int minDMG, int maxDMG, int armor, int health, Weapon currentWep) {
		super(GameConstants.ORC_CHIEF, minDMG, maxDMG, armor, health, currentWep);
		
	}

}
