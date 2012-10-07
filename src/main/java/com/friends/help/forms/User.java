package com.friends.help.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER")
public class User {
	
	@Column(name="UserName")
	private String firstname;
    //private String lastname;
	@Column(name="email")
	private String email;
	
	@Column(name="telephone")
    private String telephone;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Userid")
    private String userId;
    
	@Column(name="Password")
	private String password;
	
	@Column(name="status")
    private String status;
    
    @Column(name="usertype")
    private String userType;
	/**
	 * @return the firstname
	 */
    
	public String getFirstname() {
		
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
/*	*//**
	 * @return the lastname
	 *//*
	public String getLastname() {
		return lastname;
	}
	*//**
	 * @param lastname the lastname to set
	 *//*
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}*/
	/**
	 * @return the email
	 */
	
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the userId
	 * 
	 */
	//static int i;
	public String getUserId() {
		//return ""+i++;
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the status
	 */
	 
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the userType
	 */
	 
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
    
    

}
