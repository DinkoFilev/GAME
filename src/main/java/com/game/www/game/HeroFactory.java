package com.game.www.game;

import com.game.www.game.heroes.Hero;
import com.game.www.game.heroes.races.Hawkeye;
import com.game.www.game.heroes.races.Paladin;

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
		case "1":
			return new Paladin(name, 100, 2, 4, 1.47);
		case "2":
			return new Hawkeye(name, 50, 10, 2, 2.05);
		default:
			return null;
		}

	}

}
