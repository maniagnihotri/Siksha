package com.friends.help.dao;

import java.util.List;

import com.friends.help.forms.CasteType;
import com.friends.help.forms.ChildDetails;
import com.friends.help.forms.Disability;

public interface ChildDetailsdao {
	
	public void saveChild(ChildDetails cd);
	public void updateChild(ChildDetails cd);
	public void deleteChild(ChildDetails cd);
	
	public CasteType getCastteype(int castid);
	public Disability getDisability(int disabilityid);
	public List<Disability> getDisabilityList(); 
	public  int getNumberOfRows();

}
