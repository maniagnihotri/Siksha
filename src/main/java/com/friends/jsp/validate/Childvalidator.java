package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.ChildDetails;

public class Childvalidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ChildDetails childdetails = new ChildDetails();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "child_name",
				"required.child_name", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "father_name",
				"required.father_name", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mother_name",
				"required.mother_name", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "house_no",
				"required.house_no", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date_of_birth",
				"required.date_of_birth", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "caste",
				"required.caste", "Field name is required.");
		if(childdetails.getCasteid()==-1){
			errors.rejectValue("district_id", "required.district");
		}
		if(childdetails.getIsdisable()==0)
		{
			if(childdetails.getDisabilityid()==-1){
				errors.rejectValue("district_id", "required.district");
			}
		}
	}

}
