package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.Block;

public class Blockvalidator implements Validator {

	private Block blockInValidator;
	public Block getBlockInValidator() {
		return blockInValidator;
	}

	public void setBlockInValidator(Block blockInValidator) {
		this.blockInValidator = blockInValidator;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		//return Block.class.isAssignableFrom(arg0);
		return false;
		
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "block_name",
				"required.block_name", "Field name is required.");
		//int a = 0;
		Block cust = (Block)arg0;
		if(cust.getDistrict_id()==-1)
		{
			//errors.r
			errors.rejectValue("district_id", "required.district");
		}
		if(this.getBlockInValidator()!=null)
		{
			errors.rejectValue("block_name", "unique.blockname");
		}
	}

}
