package com.friends.jsp.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.friends.help.dao.Userdao;
import com.friends.help.forms.User;

public class UserValidator implements Validator {

	private User userInValidator;
	
	@Autowired
	Userdao userdao;

	/**
	 * @return the userInValidator
	 */
	public User getUserInValidator() {
		return userInValidator;
	}

	/**
	 * @param userInValidator the userInValidator to set
	 */
	public void setUserInValidator(User userInValidator) {
		this.userInValidator = userInValidator;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		//return Block.class.isAssignableFrom(arg0);
		return false;
		
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		User user = (User)arg0;
		
		if("".equals(user.getJ_username())||null==user.getJ_username())
			errors.rejectValue("j_username", "required.username");
		if("".equals(user.getJ_password())||null==user.getJ_password())
			errors.rejectValue("j_password", "required.password");
		if(null!=userdao.getUser(user.getJ_username()))
			errors.rejectValue("j_username", "unique.username");
	}

}
