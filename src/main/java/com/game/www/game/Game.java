package com.game.www.game;

import java.util.Random;

import com.game.www.game.heroes.Hero;
import com.game.www.game.mobs.Mob;

public class Game {
	Hero hero;
	Mob mob;
	MobFactory mobFactory = MobFactory.getInstance();

	private static Game instance;

	private Game() {

	}

	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	public void start(Hero hero) {
		this.hero = hero;
		mob = createOponent();
		play(hero, mob);

	}

	private Mob createOponent() {
		System.out.println("--- create oponent ---");
		return mobFactory.getMob(GameConstants.ORC_CHIEF);
	}

	private void play(Hero hero, Mob mob) {
		System.out.println("Your Oponent is  : " + mob.getName());
		System.out.println("GAME STARTED");
		boolean isHeroAtkFirst = new Random().nextBoolean();
		System.out.println(hero.toString());
		while (hero.isAlive() && mob.isAlive()) {
			threadSleep(500);
			if (isHeroAtkFirst) {
				heroAttack(hero, mob);
				threadSleep(500);
				mobAttack(mob, hero);
				continue;
			}
			mobAttack(mob, hero);
			threadSleep(500);
			heroAttack(hero, mob);

		}
		System.out.println("_______________________________________________________");
		System.out.println("Dear , " + hero.getName());
		System.out.println(
				hero.isAlive() ? "YOU BEAT THAT " + mob.getName() : "YOU DIE LIKE A NOOB from " + mob.getName());

	}

	private void heroAttack(Hero hero, Mob targetMob) {
		int dmgDiff = hero.getMaxDMG() - hero.getMinDMG();
		int dmg = dmgDiff == 0 ? hero.getMinDMG() : hero.getMinDMG() + new Random().nextInt(dmgDiff);
		System.out.println(hero.getName() + " attempt to attack " + targetMob.getName() + " for " + dmg + " DMG");
		decreaseMobHP(targetMob, dmg);
		System.out.println(targetMob.getName() + " Health left : " + targetMob.getHealth());
	}

	private void mobAttack(Mob mob, Hero targetHero) {
		int dmgDiff = mob.getMaxDMG() - mob.getMinDMG();
		int dmg = dmgDiff == 0 ? mob.getMinDMG() : mob.getMinDMG() + new Random().nextInt(dmgDiff);
		System.out.println(mob.getName() + " attempt to attack " + targetHero.getName() + " for " + dmg + " DMG");
		decreaseHeroHP(targetHero, dmg);
		System.out.println(targetHero.getName() + " Health left : " + targetHero.getHealth());

	}

	private void decreaseHeroHP(Hero hero, int dmg) {
		int hpToDecrease = dmg - hero.getArmor();
		if (hpToDecrease > 0) {
			hero.setHealth(hero.getHealth() - hpToDecrease);
			System.out.println(hero.getName()+ " lose "+ hpToDecrease +" Health");
		} else {
			
			System.out.println("You doesn't have enough strength to harm "+hero.getName());
		}
	}

	private void decreaseMobHP(Mob mob, int dmg) {
		int hpToDecrease = dmg - mob.getArmor();
		if (hpToDecrease > 0) {
			mob.setHealth(mob.getHealth() - hpToDecrease);
			System.out.println(mob.getName()+ " lose "+ hpToDecrease +" Health");
		} else {
			
			System.out.println("You doesn't have enough strength to harm "+mob.getName());
		}

	}
	
	private void threadSleep(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("_______________________________________________________");
	}
}
