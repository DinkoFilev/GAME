package com.game.www.game.heroes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.game.www.game.weapons.Weapon;

public abstract class Hero {
	public static final int MIN_HEALTH = 0;
	public static final int MAX_HEALTH = 1000;
	private byte level;
	private double experience;
	private int minDMG;
	private int maxDMG;
	private int armor;
	private double criticalRate;
	private boolean isAlive;
	private String name;
	private String heroType;
	private int health;
	private Weapon currentWep;
	private List<Weapon> weapons;
	// Map with special abilities psyhical skills magic skills
	// HashMap

	public Hero(String name, int health, int minDMG, int armor, double criticalRate, String heroType) {
		super();
		this.level = 1;
		this.experience = 0;
		this.name = name;
		this.health = health;
		this.minDMG = minDMG;
		this.maxDMG = minDMG;
		this.armor = armor;
		this.criticalRate = criticalRate;
		this.isAlive = true;
		this.weapons = new ArrayList<Weapon>();
		this.heroType = heroType;
	}
	
	public String getHeroType() {
		return heroType;
	}
	
	public int getMinDMG() {
		return minDMG;
	}

	public void setMinDMG(int minDMG) {
		this.minDMG = minDMG;
	}

	public int getMaxDMG() {
		return maxDMG;
	}

	public void setMaxDMG(int maxDMG) {
		this.maxDMG = maxDMG;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public double getCriticalRate() {
		return criticalRate;
	}

	public void setCriticalRate(double criticalRate) {
		this.criticalRate = criticalRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		// if health is below or equal to 0 hero should be dead
		if (this.health <= 0) {
			this.health = 0;
			isAlive = false;
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public Weapon getCurrentWep() {
		return currentWep;
	}

	public void setCurrentWep(Weapon currentWep) {
		this.currentWep = currentWep;
	}

	public List<Weapon> getWeapons() {
		return Collections.unmodifiableList(weapons);
	}

	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
	}

	public Weapon getWeapon(Weapon weapon) {

		// TODO
		return weapon;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Hero [level=" + level + ", experience=" + experience + ", minDMG=" + minDMG + ", maxDMG=" + maxDMG
				+ ", armor=" + armor + ", criticalRate=" + criticalRate + ", isAlive=" + isAlive + ", name=" + name
				+ ", health=" + health + ", currentWep=" + currentWep + ", weapons=" + weapons + "]";
	}
	
	

}
