package com.friends.help.forms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
	
	@Column(name="username")
	private String j_username;

	@Column(name="email")
	private String email;
	
	@Column(name="telephone")
    private String telephone;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId",insertable=false )
    private String userId;
    
	@Column(name="userId", nullable = false, insertable=false, updatable=false)
	private String role;
	
	@Column(name="password")
	private String j_password;
	
	@Column(name="enabled")
    private boolean enabled;
   
	/*@OneToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List <Roles> roles;*/
    
    @Column(name="rememberMe")
    private boolean _spring_security_remember_me;
	
	/**
	 * @return the _spring_security_remember_me
	 */
	public boolean is_spring_security_remember_me() {
		return _spring_security_remember_me;
	}

	/**
	 * @param _spring_security_remember_me the _spring_security_remember_me to set
	 */
	public void set_spring_security_remember_me(boolean _spring_security_remember_me) {
		this._spring_security_remember_me = _spring_security_remember_me;
	}

	/**
	 * @return the j_username
	 */
	public String getJ_username() {
		return j_username;
	}

	
	/**
	 * @param j_username the j_username to set
	 */
	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

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
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the j_password
	 */
	public String getJ_password() {
		return j_password;
	}

	/**
	 * @param j_password the j_password to set
	 */
	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	/**
	 * @return the enabled
	 */
	public boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


}
