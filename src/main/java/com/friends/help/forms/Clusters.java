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
@Table(name="clusters")
public class Clusters {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Cluster_Id")
	private int cluster_id;
	
	@Column(name="Cluster_name",nullable=false)
	private String cluster_name;
	
	@Column(name="Block_Id", nullable = false, insertable=false, updatable=false)
	private int block_id;
	
	@Column(name="Block_Id", nullable = false, insertable=false, updatable=false)
	private int district_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Block_Id", nullable = false)
	private Block block;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clusters")
	private Set<VillageTypeNames> villagetypenamesdetails = new HashSet<VillageTypeNames>(0);
	
	public Set<VillageTypeNames> getVillagetypenamesdetails() {
		return villagetypenamesdetails;
	}
	public void setVillagetypenamesdetails(
			Set<VillageTypeNames> villagetypenamesdetails) {
		this.villagetypenamesdetails = villagetypenamesdetails;
	}
	public int getCluster_id() {
		return cluster_id;
	}
	public void setCluster_id(int cluster_id) {
		this.cluster_id = cluster_id;
	}
	public String getCluster_name() {
		return cluster_name;
	}
	public void setCluster_name(String cluster_name) {
		this.cluster_name = cluster_name;
	}
	public int getBlock_id() {
		return block_id;
	}
	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
}
