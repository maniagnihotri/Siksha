package com.friends.help;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.friends.help.dao.Userdao;
import com.friends.help.forms.User;
import com.friends.help.util.PlaceHelper;


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
	
	@RequestMapping(value = "/UserController.html", method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model, Principal principal, HttpSession session) {
		String user = principal.getName();
		//String role = principal.g
		user = user.substring(0,1).toUpperCase()+user.substring(1).toLowerCase();
		session.setAttribute("user", user);
		//PlaceHelper placehelper = new PlaceHelper();
		//model.addAttribute("PlaceHelper", placehelper);
		//return new ModelAndView("selectPlace", "command", placehelper);
		return new ModelAndView("home");
	}
    
	
		
}
