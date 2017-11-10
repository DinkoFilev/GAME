package com.game.www.game;

import java.util.HashMap;

public class GameUtil {
	
	public static HashMap<Integer,String> heroType = new HashMap();
	
	static {
		heroType.put(1, GameConstants.PALADIN);
		heroType.put(2, GameConstants.HAWKEYE);
	}
	
	

}
