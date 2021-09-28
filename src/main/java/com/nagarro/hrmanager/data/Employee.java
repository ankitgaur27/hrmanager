package com.nagarro.hrmanager.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Employee {
	 
	private int employeeId;
	private String employeeName; 
	private String location;
	private String employeeEmail;
	private String dateOfBirth; 
	
	
	public Employee() {
		super();
	}
	/**
	 * @param employeeId
	 * @param employeeName
	 * @param location
	 * @param employeeEmail
	 * @param dateOfBirth
	 */
	public Employee(int employeeId, String employeeName, String location, String employeeEmail, String dateOfBirth) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.location = location;
		this.employeeEmail = employeeEmail;
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the employeeEmail
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	/**
	 * @param employeeEmail the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	/**
	 * This is to print the all attributes of class
	 */
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", location=" + location
				+ ", employeeEmail=" + employeeEmail + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
}
