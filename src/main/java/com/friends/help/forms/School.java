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
@Table(name="school")
public class School {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="School_Name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "School_Category", nullable = false)
	private SchoolCategory school_category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "T_OR_V_ID", nullable = false)
	private Village t_or_v_id;
	
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int district_id;
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int block_id;
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int cluster_id;
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int type_id;
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int villagetypenames_id;
	@Column(name="T_OR_V_ID", nullable = false, insertable=false, updatable=false)
	private int village_id;
	@Column(name="School_Category", nullable = false, insertable=false, updatable=false)
	private int category_id;

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

	public SchoolCategory getSchool_category() {
		return school_category;
	}

	public void setSchool_category(SchoolCategory school_category) {
		this.school_category = school_category;
	}

	public Village getT_or_v_id() {
		return t_or_v_id;
	}

	public void setT_or_v_id(Village t_or_v_id) {
		this.t_or_v_id = t_or_v_id;
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

	public int getVillage_id() {
		return village_id;
	}

	public void setVillage_id(int village_id) {
		this.village_id = village_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
}
