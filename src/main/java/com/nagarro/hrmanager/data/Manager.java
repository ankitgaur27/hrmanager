package com.nagarro.hrmanager.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>This is model Class for Manager.</p>
 * @author ankitgaur
 *
 */
@Entity
public class Manager {
	
	
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private String email;
	
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
	
	private int otp;

	/**
	 * @return the otp
	 */
	public int getOtp() {
		return otp;
	}

	/**
	 * @param otp the otp to set
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
 

	public Manager(int otp,int id,String email ,String username, String password) {
		super();
		this.id = id;
		this.otp = otp;
		this.username = username;
		this.password = password; 
		this.email = email;
	}

	public Manager() {
		super();
	}
}
