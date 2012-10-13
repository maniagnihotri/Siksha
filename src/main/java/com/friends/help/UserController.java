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

import com.friends.help.dao.Userdao;
import com.friends.help.forms.User;
import com.friends.jsp.validate.UserValidator;

@Controller
public class UserController {

	@Autowired	
	public Userdao userdao;
	@Autowired
	UserValidator userValidator;
		
		public Userdao getUserdao() {
		return userdao;
	}
	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}
		@RequestMapping(value="/addUserNew.html", method= RequestMethod.POST)
		public ModelAndView add(@ModelAttribute("user") User user, BindingResult result, ModelMap model ,Locale locale){

			userValidator.validate(user, result);
			if (result.hasErrors()) 
				return new ModelAndView("addUser","command",model);
			userdao.saveUser(user);
			
			model.addAttribute("message","User has been added");
			return new ModelAndView("home",model);
		}
		
		
		@RequestMapping(value="/addUserDetailsInput.html", method= RequestMethod.GET)
		public ModelAndView render(ModelMap model){
				
				return new ModelAndView("addUser","command",new User());
		}

}
