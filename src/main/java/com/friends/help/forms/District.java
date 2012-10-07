package com.friends.help.forms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="district")
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int ID;
	
	@Column(name="District_Name",unique = true, nullable = false)
	private String district_name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "district")
	private Set<Block> blockDetails = new HashSet<Block>(0);

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	
	public Set<Block> getBlockDetails() {
		return blockDetails;
	}

	public void setBlockDetails(Set<Block> blockDetails) {
		this.blockDetails = blockDetails;
	}
	
	
	
}
