package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.friends.help.util.PlaceHelper;

public class SelectPlaceValidator implements Validator {

	private int requesttype;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(int requesttype) {
		this.requesttype = requesttype;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		PlaceHelper cust = (PlaceHelper)arg0;
			
			
			
			
			
			if(this.getRequesttype()==0)
			{
				if(cust.getVillage_id()==-1){
					errors.rejectValue("village_id", "required.village");
				}
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
			
			
	}

}
