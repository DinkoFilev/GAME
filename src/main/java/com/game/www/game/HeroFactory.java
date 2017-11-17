package com.game.www.game;

import com.game.www.game.heroes.Hero;
import com.game.www.game.heroes.races.Duelist;
import com.game.www.game.heroes.races.Hawkeye;
import com.game.www.game.heroes.races.Paladin;
import com.game.www.game.heroes.races.Sorcerer;
import com.game.www.game.heroes.races.ThreasureHunter;
import com.game.www.game.heroes.races.Warlord;

public class HeroFactory {

	private static HeroFactory instance;

	private HeroFactory() {

	}

	public static HeroFactory getInstance() {
		if (instance == null) {
			instance = new HeroFactory();
		}
		return instance;
	}

	public Hero getHero(String race, String name) {

		switch (race) {
		case GameConstants.PALADIN:
			return new Paladin(name, 150, 5, 5, 1.47,GameConstants.PALADIN);
		case GameConstants.HAWKEYE:
			return new Hawkeye(name, 60, 10, 2, 2.05,GameConstants.HAWKEYE);
		case GameConstants.WARLORD:
			return new Warlord(name, 100, 7, 3, 2.05,GameConstants.WARLORD);
		case GameConstants.DUELIST:
			return new Duelist(name, 110, 9, 3, 2.05,GameConstants.DUELIST);
		case GameConstants.THREASURE_HUNTER:
			return new ThreasureHunter(name, 60, 12, 2, 3.05,GameConstants.THREASURE_HUNTER);
		case GameConstants.SORCERER:
			return new Sorcerer(name, 40, 2, 2, 0,GameConstants.SORCERER);
		default:
			return null;
		}

	}

}
