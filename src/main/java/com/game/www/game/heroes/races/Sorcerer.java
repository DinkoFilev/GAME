package com.game.www.game.heroes.races;

import com.game.www.game.heroes.Hero;
import com.game.www.game.heroes.IArcher;

public class Sorcerer extends Hero implements IArcher{

	public Sorcerer(String name, int health, int baseDMG, int armor, double criticalRate, String heroType) {
		super(name, health, baseDMG, armor, criticalRate, heroType);
		
	}
	
	

}
