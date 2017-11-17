package com.game.www.game.heroes.races;

import com.game.www.game.heroes.Hero;
import com.game.www.game.heroes.ITank;

public class Paladin extends Hero implements ITank{

	public Paladin(String name, int health, int baseDMG, int armor, double criticalRate,String heroType) {
		super(name, health, baseDMG, armor, criticalRate,heroType);
		
	}

}
