package com.friends.jsp.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		ChildDetails childdetails = (ChildDetails) arg0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		if (childdetails.getDate() != "" || childdetails.getDate() != null) {
			try {
				Date date = sdf.parse(childdetails.getDate());
				Date today = new Date();
				if (date.compareTo(today) > 0) {
					errors.rejectValue("date", "date.error");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "child_name",
				"required.child_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "father_name",
				"required.father_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mother_name",
				"required.mother_name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "house_no",
				"required.house_no");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date",
				"required.date_of_birth");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "caste",
				"required.caste");
		if (childdetails.getCasteid() == -1) {
			errors.rejectValue("casteid", "required.disability");
		}
		if (childdetails.getIsdisable() == 0) {
			if (childdetails.getDisabilityid() == 0) {
				errors.rejectValue("disabilityid", "required.disabilityid");
			}
		}
	}

}
