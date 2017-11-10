package com.game.www.game;

import java.util.Scanner;

import com.game.www.game.heroes.Hero;

public class Engine {
	private static Engine instance;
	HeroFactory heroFactory = HeroFactory.getInstance();
	Game game = Game.getInstance();

	private Engine() {
		prepareGame();
	}

	public static Engine getInstance() {
		if (instance == null) {
			instance = new Engine();
		}
		return instance;
	}

	private void start(Hero hero) {
		game.start(hero);

	}

	private void prepareGame() {
		Scanner sc = new Scanner(System.in);
		Hero hero;
		// Choose name of the hero;
		printSlowlyMsg("*** WELCOME TO MY GAME ***");
		String heroName;
		int heroNumber = 0;
		do {

			printSlowlyMsg("Please enter Hero name :");
			heroName = sc.nextLine();
		} while (heroName == null);
		System.out.println("Welecome " + heroName);
		do {

			System.out.println("Please choose one of the below heroes :");
			System.out.println("1 "+ GameConstants.PALADIN);
			System.out.println("2 "+ GameConstants.HAWKEYE);
			heroNumber = sc.nextInt();
			System.out.println(GameUtil.heroType.size());
		} while (!GameUtil.heroType.containsKey(heroNumber));
		//create hero
		hero = heroFactory.getHero(String.valueOf(heroNumber), heroName);
		start(hero);
	}

	private void printSlowlyMsg(String msg) {

		for (int i = 0; i < msg.length(); i++) {
			System.out.print(msg.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
