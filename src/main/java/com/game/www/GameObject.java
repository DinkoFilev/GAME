package com.game.www;

public class GameObject {
	private String nickname;
	private String command;
	private String attacker;
	private String oponent;
	private String attackerHP;
	private String oponentHP;
	private String hero;
	private String msg;
	private String deadMSG;
	public String getDeadMSG() {
		return deadMSG;
	}
	public void setDeadMSG(String deadMSG) {
		this.deadMSG = deadMSG;
	}
	private int lostHP;
	public int getLostHP() {
		return lostHP;
	}
	public void setLostHP(int lostHP) {
		this.lostHP = lostHP;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getAttacker() {
		return attacker;
	}
	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}
	public String getOponent() {
		return oponent;
	}
	public void setOponent(String oponent) {
		this.oponent = oponent;
	}
	public String getAttackerHP() {
		return attackerHP;
	}
	public void setAttackerHP(String attackerHP) {
		this.attackerHP = attackerHP;
	}
	public String getOponentHP() {
		return oponentHP;
	}
	public void setOponentHP(String oponentHP) {
		this.oponentHP = oponentHP;
	}
	
	

}
