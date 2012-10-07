package com.friends.help.dao;

import java.util.List;

import com.friends.help.forms.District;

public interface Districtdao {

	public void addDistrict(District D);
	public void updateDistrict(District D);
	public District getDistrict(String DistrictName);
	public List<String> getDistrictnames();
	public List<District> getAllDistricts();
	public void deleteDistrict(District D);
	public District getDistrictbyID(int districtid);
}
