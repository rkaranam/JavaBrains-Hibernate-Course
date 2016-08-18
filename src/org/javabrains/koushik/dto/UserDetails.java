package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue
	@Column(name = "USER_ID")
	private int userId;

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

	@OneToMany(mappedBy = "user")
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	/*public UserDetails() {
		System.out.println("UserDetails: Default Constructor called!");
	}*/
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
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
		return "UserDetails [userId=" + userId + ", userName="
				+ userName + ", joinedDate=" + joinedDate + ", joinedTime="
				+ joinedTime + ", userType=" + userType + ", description="
				+ description + "]";
	}

	public void assignVehicle(Vehicle vehicle) {
		this.getVehicles().add(vehicle);
		vehicle.setUser(this);
	}
}
