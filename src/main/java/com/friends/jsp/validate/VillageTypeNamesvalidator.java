package com.friends.jsp.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.friends.help.forms.VillageTypeNames;

public class VillageTypeNamesvalidator implements Validator {

	private VillageTypeNames villagetypenames;
	private int requesttype = 0;
	
	public int getRequesttype() {
		return requesttype;
	}

	public void setRequesttype(int requesttype) {
		this.requesttype = requesttype;
	}

	public VillageTypeNames getVillagetypenames() {
		return villagetypenames;
	}

	public void setVillagetypenames(VillageTypeNames villagetypenames) {
		this.villagetypenames = villagetypenames;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		if(this.getRequesttype()==0){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.villagetypename_name", "Field name is required.");
		}
		
		VillageTypeNames cust = (VillageTypeNames)arg0;
		if(cust.getDistrict_id()==-1)
		{
			//errors.r
			errors.rejectValue("district_id", "required.district");
		}
		if(cust.getBlock_id()==-1)
		{
			//errors.r
			errors.rejectValue("block_id", "required.block");
		}
		if(cust.getCluster_id()==-1)
		{
			//errors.r
			errors.rejectValue("cluster_id", "required.clusters");
		}
		
		if(cust.getType_id()==-1)
		{
			errors.rejectValue("type_id", "required.type");
		}
		
		if(this.getVillagetypenames()!=null)
		{
			errors.rejectValue("name", "unique.villagetypename");
		}
	}

}
