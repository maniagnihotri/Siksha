package com.friends.help;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.html")
	public String home(HttpSession session, ModelMap model) {
		model.addAttribute("user",session.getAttribute("user"));
		
		return "home";
	}
	
	@RequestMapping(value = "/userHome.html")
	public String userhome(HttpSession session, ModelMap model) {
		model.addAttribute("user",session.getAttribute("user"));
		
		return "userHome";
	}
	
}
