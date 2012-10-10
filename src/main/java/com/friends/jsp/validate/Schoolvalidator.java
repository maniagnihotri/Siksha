package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.School;

public class Schoolvalidator implements Validator {

	private School school;
	private int requesttype;
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(int requesttype) {
		this.requesttype = requesttype;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		School cust = (School)arg0;
		if(this.getRequesttype()==0 || this.getRequesttype()==2){
			
			
			if(cust.getVillagetypenames_id()==-1){
				errors.rejectValue("villagetypenames_id", "required.villagetypenames");
			}
			
			if(this.getSchool()!=null){
				errors.rejectValue("name", "unique.school");
			}
			
			if(cust.getVillage_id()==-1){
				errors.rejectValue("village_id", "required.village");
			}
			if(cust.getCategory_id()==-1){
				errors.rejectValue("village_id", "required.category");
			}
		}
		
		if(this.getRequesttype()==0){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"required.school_name", "Field name is required.");
		}
		
			
			
			if(cust.getDistrict_id()==-1){
				//errors.r
				errors.rejectValue("district_id", "required.district");
			}
			if(cust.getBlock_id()==-1){
				//errors.r
				errors.rejectValue("block_id", "required.block");
			}
			if(cust.getCluster_id()==-1){
				//errors.r
				errors.rejectValue("cluster_id", "required.clusters");
			}
			
			if(cust.getType_id()==-1){
				errors.rejectValue("type_id", "required.type");
			}
			
			
			
			
	}

}
