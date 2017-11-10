package com.game.www.game.weapons;

public  class Weapon {

	private String name;
	private int dmg;
	private int bonusHP;
	private double bonusArmor;
	private double bonusCriticalRate;
	
	
	public Weapon(String name, int dmg, int bonusHP, double bonusArmor, double bonusCriticalRate) {
		super();
		this.name = name;
		this.dmg = dmg;
		this.bonusHP = bonusHP;
		this.bonusArmor = bonusArmor;
		this.bonusCriticalRate = bonusCriticalRate;
	}
	
	public String getName() {
		return name;
	}
	public int getDmg() {
		return dmg;
	}
	public int getBonusHP() {
		return bonusHP;
	}
	public double getBonusArmor() {
		return bonusArmor;
	}
	public double getBonusCriticalRate() {
		return bonusCriticalRate;
	}
	
}
