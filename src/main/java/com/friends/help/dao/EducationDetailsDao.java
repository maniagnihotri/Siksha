package com.friends.help.dao;

import com.friends.help.forms.ChildClass;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.EducationalDetails;
import com.friends.help.forms.Irregularity;

public interface EducationDetailsDao {

	public void saveEducation(EducationalDetails cd);
	public void updateEducation(EducationalDetails cd);
	public void deleteEducation(EducationalDetails cd);
	
	public Irregularity getRegularityObject(int irregularityid);
	public ChildClass getClassObject(int classid);
	//public List<Disability> getDisabilityList(); 
	public  int getNumberOfRows();
	
}
