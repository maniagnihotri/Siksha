package com.friends.help.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="village")
public class Village {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Villagetypenames_Id", nullable = false)
	private VillageTypeNames villageTypeNames;

	@Column(name="Villagetypenames_Id", nullable = false, insertable=false, updatable=false)
	private int district_id;
	@Column(name="Villagetypenames_Id", nullable = false, insertable=false, updatable=false)
	private int block_id;
	@Column(name="Villagetypenames_Id", nullable = false, insertable=false, updatable=false)
	private int cluster_id;
	@Column(name="Villagetypenames_Id", nullable = false, insertable=false, updatable=false)
	private int type_id;
	@Column(name="Villagetypenames_Id", nullable = false, insertable=false, updatable=false)
	private int villagetypenames_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VillageTypeNames getVillageTypeNames() {
		return villageTypeNames;
	}

	public void setVillageTypeNames(VillageTypeNames villageTypeNames) {
		this.villageTypeNames = villageTypeNames;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

	

	public int getCluster_id() {
		return cluster_id;
	}

	public void setCluster_id(int cluster_id) {
		this.cluster_id = cluster_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getVillagetypenames_id() {
		return villagetypenames_id;
	}

	public void setVillagetypenames_id(int villagetypenames_id) {
		this.villagetypenames_id = villagetypenames_id;
	}

	
}
