package org.javabrains.koushik.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.javabrains.koushik.valueobjects.Credentials;

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
	
	/*public UserDetails() {
		System.out.println("UserDetails: Default Constructor called!");
	}*/
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	public Date getJoinedTime() {
		return joinedTime;
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
				+ description + "]";
	}

}
