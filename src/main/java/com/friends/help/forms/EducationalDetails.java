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
@Table(name="educationaldetails")
public class EducationalDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Child_Id", nullable = false)
	private ChildDetails child_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Class_Id", nullable = false)
	private ChildClass class_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Age_Child_Id", nullable = false)
	private ChildClass age_class_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Child_Id", nullable = false)
	private School school_id;
	
	@Column(name="Regularity_Type")
	private String regularityType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Irregularity", nullable = false)
	private Irregularity irregularity;
	
	@Column(name="Roll_No")
	private int roll_no;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Left_School_At", nullable = false)
	private ChildClass left_school_at;
	
	
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ChildDetails getChild_id() {
		return child_id;
	}
	public void setChild_id(ChildDetails child_id) {
		this.child_id = child_id;
	}
	public ChildClass getClass_id() {
		return class_id;
	}
	public void setClass_id(ChildClass class_id) {
		this.class_id = class_id;
	}
	public ChildClass getAge_class_id() {
		return age_class_id;
	}
	public void setAge_class_id(ChildClass age_class_id) {
		this.age_class_id = age_class_id;
	}
	public School getSchool_id() {
		return school_id;
	}
	public void setSchool_id(School school_id) {
		this.school_id = school_id;
	}
	public String getRegularityType() {
		return regularityType;
	}
	public void setRegularityType(String regularityType) {
		this.regularityType = regularityType;
	}
	public Irregularity getIrregularity() {
		return irregularity;
	}
	public void setIrregularity(Irregularity irregularity) {
		this.irregularity = irregularity;
	}
	
}
