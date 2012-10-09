package com.friends.help.dao;

import java.util.Set;

import com.friends.help.forms.VillageType;
import com.friends.help.forms.VillageTypeNames;

public interface VillageTypeNamesdao {

	public void addVillageTypeNames(VillageTypeNames C);
	public void updateVillageTypeNames(VillageTypeNames C);
	public void deletVillageTypeNames(VillageTypeNames C);
	
	public Set<VillageTypeNames>getVillageTypeNamesList(int clusterid,int villagetypeid);
	public VillageTypeNames getVillageTypeNamesObjectbyID(int villagetypenamesid);
	public VillageTypeNames getVillageTypeNamesObject(String name,int clusterid);
	
	public Set<VillageType> getVillageType();
	public VillageType getVillageTypeById(int id);
}
