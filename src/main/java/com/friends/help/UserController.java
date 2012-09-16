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

@Controller
public class UserController {

	@Autowired	
	public Userdao userdao;
		
		public Userdao getUserdao() {
		return userdao;
	}
	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}
		@RequestMapping(value="/userAdder.html", method= RequestMethod.POST)
		public ModelAndView add(@ModelAttribute("user") User user, BindingResult result, ModelMap model ,Locale locale){
			System.out.println("User: "+user+" : "+user.getFirstname());
			//if("admin".equals(user.getUserId())&& "admin".equals(user.getPassword())){
				//model.put("user", user.getUserId());
				userdao.saveUser(user);
				return new ModelAndView("home_redirect",model);
			//}
			//else return new ModelAndView(new RedirectView("login.html"));
		}
		public void setUserDAO(Userdao userDAO) {
			this.userdao = userDAO;
			}
}
