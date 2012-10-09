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

import com.friends.help.forms.Clusters;

@Entity
@Table(name="villagetypenames")
public class VillageTypeNames {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Type", nullable = false)
	private VillageType type;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Cluster_ID", nullable = false)
	private Clusters clusters; 
	
/*	@OneToMany(fetch = FetchType.EAGER, mappedBy = "villagetypenames")
	private Set<Village> village = new HashSet<Village>(0);
*/	
	@Column(name="Cluster_ID", nullable = false, insertable=false, updatable=false)
	private int district_id;
	@Column(name="Cluster_ID", nullable = false, insertable=false, updatable=false)
	private int block_id;
	@Column(name="Cluster_ID", nullable = false, insertable=false, updatable=false)
	private int cluster_id;
	@Column(name="Type", nullable = false, insertable=false, updatable=false)
	private int type_id;
	
	
	public int getType_id() {
		return type_id;
	}

/*	public Set<Village> getVillage() {
		return village;
	}

	public void setVillage(Set<Village> village) {
		this.village = village;
	}*/

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

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

	public VillageType getType() {
		return type;
	}

	public void setType(VillageType type) {
		this.type = type;
	}

	public Clusters getClusters() {
		return clusters;
	}

	public void setClusters(Clusters clusters) {
		this.clusters = clusters;
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
}
