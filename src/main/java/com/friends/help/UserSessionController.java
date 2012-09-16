package com.friends.help;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.friends.help.dao.Userdao;
import com.friends.help.forms.User;


@Controller
public class UserSessionController {

	@Autowired
	public Userdao userdao;
	@RequestMapping(value="/tryLogin.html", method= RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult result, ModelMap model ,Locale locale){
		
		System.out.println("UserEntered: "+user+" : "+user.getFirstname());
		
		User fromdb = userdao.getUser(user.getFirstname());
				
		if( fromdb.getPassword().equals(user.getPassword())){
			model.put("user", user.getFirstname());
			
			return new ModelAndView("test", "command", new User());
		}
		else return new ModelAndView(new RedirectView("login.html"));
		
	}
	
	@RequestMapping("/login")
    public ModelAndView login() {
         
        return new ModelAndView("login", "command", new User());
    }
}
