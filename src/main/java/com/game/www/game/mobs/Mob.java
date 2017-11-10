package com.game.www.game.mobs;

import com.game.www.game.weapons.Weapon;

public abstract class Mob {

	public static final int MIN_HEALTH = 0;
	public static final int MAX_HEALTH = 1000;
	private String name;
	private int minDMG;
	private int maxDMG;
	private int armor;
	private boolean isAlive;
	private int health;
	private Weapon currentWep;

	public Mob(String name, int minDMG, int maxDMG, int armor, int health, Weapon currentWep) {
		super();
		this.name = name;
		this.minDMG = minDMG;
		this.maxDMG = maxDMG;
		this.armor = armor;
		this.health = health;
		this.currentWep = currentWep;
		this.isAlive = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		// if health is below or equal to 0 hero should be dead
		if (this.health <= 0) {
			isAlive = false;
		}
	}

	public Weapon getCurrentWep() {
		return currentWep;
	}

	public void setCurrentWep(Weapon currentWep) {
		this.currentWep = currentWep;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public String toString() {
		return "Mob [name=" + name + ", minDMG=" + minDMG + ", maxDMG=" + maxDMG + ", armor=" + armor + ", isAlive="
				+ isAlive + ", health=" + health + ", currentWep=" + currentWep + "]";
	}
	
}
