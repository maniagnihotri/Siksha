package com.friends.help.dao;

import java.util.Set;

import com.friends.help.forms.School;
import com.friends.help.forms.SchoolCategory;

public interface Schooldao {

	public void addSchool(School C);
	public void updateSchool(School C);
	public void deletSchool(School C);

	public Set<School> getSchoolList(int villageid,int type);
	public School getSchoolObject(String name,int villageid);
	public School getSchoolObjectbyID(int schoolid);
	
	public SchoolCategory getSchoolCategoryById(int categoryid);
	//public Set<School> getSchoolList(int villageid);
}
