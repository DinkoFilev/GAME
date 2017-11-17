package com.game.www;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.game.www.game.ActionManager;
import com.game.www.game.Game;
import com.game.www.game.GameUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GameController {
	Game game = Game.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	
	@MessageMapping("/play")
	@SendTo("/topic/game")
	public GameObject send(GameObject go) throws Exception {
		game.play(go);
	    return go;
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
