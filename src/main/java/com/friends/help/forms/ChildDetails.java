package com.friends.help.forms;

import java.util.Date;

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
@Table(name="childdetails")
public class ChildDetails {
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="Name")
	private String child_name;
	
	@Column(name="Father_Name")
	private String father_name;
	@Column(name="Mother_Name")
	private String mother_name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Village_Id", nullable = false)
	private Village village;
	
	@Column(name="House_No")
	private int house_no;
	
	@Column(name="Date_Of_Birth")
	private Date date_of_birth;
	
	@Column(name="Gender")
	private char gender;
	
	@Column(name="Cast")
	private String caste;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Cast_Category_Type", nullable = false)
	private CasteType caste_type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Disability", nullable = false)
	private Disability disability;
	
	@Column(name="Cast_Category_Type", nullable = false, insertable=false, updatable=false)
	private int casteid;
	
	@Column(name="Disability", nullable = false, insertable=false, updatable=false)
	private int disabilityid;
	
	@Column(name="Disability", nullable = false, insertable=false, updatable=false)
	private int isdisable;
	
	@Column(name="Date_of_Birth", nullable = false, insertable=false, updatable=false)
	private String date;

	@Column(name="Village_Id", nullable = false, insertable=false, updatable=false)
	private int villageid;
	
	public int getVillageid() {
		return villageid;
	}

	public void setVillageid(int villageid) {
		this.villageid = villageid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public int getHouse_no() {
		return house_no;
	}

	public void setHouse_no(int house_no) {
		this.house_no = house_no;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public CasteType getCaste_type() {
		return caste_type;
	}

	public void setCaste_type(CasteType caste_type) {
		this.caste_type = caste_type;
	}

	public Disability getDisability() {
		return disability;
	}

	public void setDisability(Disability disability) {
		this.disability = disability;
	}
	public int getCasteid() {
		return casteid;
	}

	public void setCasteid(int casteid) {
		this.casteid = casteid;
	}

	public int getDisabilityid() {
		return disabilityid;
	}

	public void setDisabilityid(int disabilityid) {
		this.disabilityid = disabilityid;
	}

	public int getIsdisable() {
		return isdisable;
	}

	public void setIsdisable(int isdisable) {
		this.isdisable = isdisable;
	}


}
