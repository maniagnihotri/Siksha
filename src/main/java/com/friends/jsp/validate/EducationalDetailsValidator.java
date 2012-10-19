package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.EducationalDetails;

public class EducationalDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		EducationalDetails obj = (EducationalDetails)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roll_no",
				"required.roll_no");
		/*if(obj.getRoll_no()){
			errors.rejectValue("roll_no", "required.int_roll");
		}*/
		
		if (obj.getHelp_class_id() == -1) {
			errors.rejectValue("help_class_id", "required.class");
		}
		if (obj.getHelp_age_class_id() == -1) {
			errors.rejectValue("help_age_class_id", "required.age_class");
		}
		if (obj.getHelp_school_id() == -1) {
			errors.rejectValue("help_school_id", "required.school");
		}
		if (obj.getHelp_irregularity_id() == -1) {
			errors.rejectValue("help_irregularity_id", "required.irregularity");
		}
		if (obj.getHelp_left_school_at() == -1) {
			errors.rejectValue("help_left_school_at", "required.leftat");
		}
		
		
	}

}
