package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.Clusters;

public class Clustersvalidator implements Validator {

	private Clusters clusttersInValidator;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Clusters getClusttersInValidator() {
		return clusttersInValidator;
	}

	public void setClusttersInValidator(Clusters clusttersInValidator) {
		this.clusttersInValidator = clusttersInValidator;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cluster_name",
				"required.clusters_name", "Field name is required.");
		
		Clusters cust = (Clusters)arg0;
		if(cust.getBlock_id()==-1)
		{
			//errors.r
			errors.rejectValue("block_id", "required.block");
		}
		/*if("NONE".equals(cust.getBlock_name()))
		{
			//errors.r
			errors.rejectValue("block_name", "required.block");
		}*/
		if(this.getClusttersInValidator()!=null)
		{
			errors.rejectValue("clusters_name", "unique.clustersname");
		}
	}

}
