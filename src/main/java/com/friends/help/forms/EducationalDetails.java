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
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Child_Id", nullable = false)
	private ChildDetails child_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Class_Id", nullable = false)
	private ChildClass class_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Age_Class_Id", nullable = false)
	private ChildClass age_class_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "School_Id", nullable = false)
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
	
	@Column(name="Class_Id", nullable = false, insertable=false, updatable=false)
	private int help_class_id;
	@Column(name="Age_Class_Id", nullable = false, insertable=false, updatable=false)
	private int help_age_class_id;
	@Column(name="Left_School_At", nullable = false, insertable=false, updatable=false)
	private int help_left_school_at;
	@Column(name="Child_Id", nullable = false, insertable=false, updatable=false)
	private String help_child_id;
	@Column(name="School_Id", nullable = false, insertable=false, updatable=false)
	private int help_school_id;
	@Column(name="Irregularity", nullable = false, insertable=false, updatable=false)
	private int help_irregularity_id;
	
	
	public ChildClass getLeft_school_at() {
		return left_school_at;
	}
	public void setLeft_school_at(ChildClass left_school_at) {
		this.left_school_at = left_school_at;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getHelp_class_id() {
		return help_class_id;
	}
	public void setHelp_class_id(int help_class_id) {
		this.help_class_id = help_class_id;
	}
	public int getHelp_age_class_id() {
		return help_age_class_id;
	}
	public void setHelp_age_class_id(int help_age_class_id) {
		this.help_age_class_id = help_age_class_id;
	}
	public int getHelp_left_school_at() {
		return help_left_school_at;
	}
	public void setHelp_left_school_at(int help_left_school_at) {
		this.help_left_school_at = help_left_school_at;
	}
	public String getHelp_child_id() {
		return help_child_id;
	}
	public void setHelp_child_id(String help_child_id) {
		this.help_child_id = help_child_id;
	}
	public int getHelp_school_id() {
		return help_school_id;
	}
	public void setHelp_school_id(int help_school_id) {
		this.help_school_id = help_school_id;
	}
	public int getHelp_irregularity_id() {
		return help_irregularity_id;
	}
	public void setHelp_irregularity_id(int help_irregularity_id) {
		this.help_irregularity_id = help_irregularity_id;
	}
	
}
