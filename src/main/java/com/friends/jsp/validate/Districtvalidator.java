package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.District;

public class Districtvalidator implements Validator {

	private District distInValidator;
	private String actionString;
	
	public String getActionString() {
		return actionString;
	}

	public void setActionString(String actionString) {
		this.actionString = actionString;
	}

	public District getDistInValidator() {
		return distInValidator;
	}

	public void setDistInValidator(District distInValidator) {
		this.distInValidator = distInValidator;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "district_name","required.district_name", "Field name is required.");
		//District dist = (District)arg0;
		//DistrictEditOrAdder deoa = new DistrictEditOrAdder();
		if(this.getDistInValidator()!=null)
		{
			//errors.r
			errors.rejectValue("district_name", "unique.district");
		}
	}

}
