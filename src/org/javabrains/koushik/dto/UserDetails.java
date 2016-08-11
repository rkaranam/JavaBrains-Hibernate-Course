package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.javabrains.koushik.valueobjects.Address;
import org.javabrains.koushik.valueobjects.Credentials;
import org.javabrains.koushik.valueobjects.Phone;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	
	@EmbeddedId
	private Credentials credentials;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "JOINED_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Column(name = "JOINED_TIME")
	@Temporal(TemporalType.TIME)
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
	@JoinTable(
		name = "USER_PHONE_NUMBERS",
		joinColumns = {
				@JoinColumn(name = "USER_LOGIN_ID"),
				@JoinColumn(name = "USER_LOGIN_PASSWORD")
		})
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type = "long"))
	private Collection<Phone> phoneNumbers = new ArrayList<Phone>();
	
	/*public UserDetails() {
		System.out.println("UserDetails: Default Constructor called!");
	}*/
	
	public Credentials getCredentials() {
		return credentials;
	}

	public Collection<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Collection<Phone> phoneNumbers) {
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

	@Override
	public String toString() {
		return "UserDetails [credentials=" + credentials + ", userName="
				+ userName + ", joinedDate=" + joinedDate + ", joinedTime="
				+ joinedTime + ", userType=" + userType + ", description="
				+ description + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + ", phoneNumbers="
				+ phoneNumbers + "]";
	}

}
