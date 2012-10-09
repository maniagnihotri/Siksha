package com.friends.help.forms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Block")
public class Block {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Block_Id")
	private int block_id;
	
	@Column(name="Block_Name", nullable = false)
	private String block_name;
	
	@Column(name="District_Id", nullable = false, insertable=false, updatable=false)
	private int district_id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "District_Id", nullable = false)
	private District district;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "block")
	private Set<Clusters> clustersdetails = new HashSet<Clusters>(0);
	
	public Set<Clusters> getClustersdetails() {
		return clustersdetails;
	}

	public void setClustersdetails(Set<Clusters> clustersdetails) {
		this.clustersdetails = clustersdetails;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}


}
