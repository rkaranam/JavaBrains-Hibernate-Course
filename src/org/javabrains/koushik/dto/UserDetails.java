package org.javabrains.koushik.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.javabrains.koushik.valueobjects.Address;
import org.javabrains.koushik.valueobjects.Credentials;
import org.javabrains.koushik.valueobjects.Phone;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	
	@EmbeddedId
	private Credentials credentials;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "JOINED_DATE")
	private Date joinedDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "JOINED_TIME")
	private Date joinedTime;
	
	@Transient
	private String userType;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE") )
	})
	private Address homeAddress;
	
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PIN_CODE"))			
	})
	private Address officeAddress;
	
	@ElementCollection
	@Embedded
	private Set<Phone> phoneNumbers = new HashSet<Phone>();
	
	/*public UserDetails() {
		System.out.println("UserDetails: Default Constructor called!");
	}*/
	
	public Credentials getCredentials() {
		return credentials;
	}
	
	public Set<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	public Date getJoinedTime() {
		return joinedTime;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public void setJoinedTime(Date joinedTime) {
		this.joinedTime = joinedTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	/*
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
