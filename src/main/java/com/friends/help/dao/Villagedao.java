package com.friends.help.dao;

import java.util.Set;

import com.friends.help.forms.Village;

public interface Villagedao {
	
	public void addVillage(Village C);
	public void updateVillage(Village C);
	public void deletVillage(Village C);
	
	public Village getVillageObject(String villagename,int Villagetypenamesid);
	public Set<Village> getVillageList(int villagetypenamesid);
	public Village getVillageObjectbyID(int villageid);

}
