package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.Village;

public class Villagevalidator implements Validator {

	private Village village;
	private int requesttype;
	
	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
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
		Village cust = (Village)arg0;
		if(this.getRequesttype()==0){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
					"required.village_name", "Field name is required.");
			
			if(cust.getVillagetypenames_id()==-1){
				errors.rejectValue("villagetypenames_id", "required.villagetypenames");
			}
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
			
			if(this.getVillage()!=null){
				errors.rejectValue("name", "unique.village");
			}
	}

}
