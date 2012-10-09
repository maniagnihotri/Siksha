package com.friends.help.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schoolcategory")
public class SchoolCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="School_Category_ID")
	private int school_category_id;
	
	@Column(name="School_Category")
	private String school_category;

	public int getSchool_category_id() {
		return school_category_id;
	}

	public void setSchool_category_id(int school_category_id) {
		this.school_category_id = school_category_id;
	}

	public String getSchool_category() {
		return school_category;
	}

	public void setSchool_category(String school_category) {
		this.school_category = school_category;
	}
}
