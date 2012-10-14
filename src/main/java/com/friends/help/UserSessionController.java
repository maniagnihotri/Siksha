package com.friends.help;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friends.help.dao.Userdao;
import com.friends.help.forms.User;


@Controller
public class UserSessionController {

	@Autowired
	public Userdao userdao;
/*	@RequestMapping(value="/tryLogin.html", method= RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult result, ModelMap model ,Locale locale){
			return new ModelAndView(new RedirectView("SelectPlace.html"));
		}
*/	
	@RequestMapping("/login.html")
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }
	
	@RequestMapping("/login.html?err=1")
    public ModelAndView errLogin(ModelMap model) {
		//model.addAttribute("error", attributeValue)
        return new ModelAndView("login", "command", new User());
    }
	
	@RequestMapping("/logoff.html")
    public ModelAndView logoff(HttpSession session) {
         session.invalidate();
		return new ModelAndView("login", "command", new User());
    }
	
    
	
		
}
