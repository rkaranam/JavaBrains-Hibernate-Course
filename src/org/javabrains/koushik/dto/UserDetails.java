package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "user")
	/*@JoinTable(name = "USER_VEHICLES",
				joinColumns = {
						@JoinColumn(name = "USER_ID"),
						@JoinColumn(name = "USER_PASSWORD")
				},
				inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
			)*/
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	/*public UserDetails() {
		System.out.println("UserDetails: Default Constructor called!");
	}*/
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
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

	public void assignVehicle(Vehicle vehicle) {
		this.getVehicles().add(vehicle);
		vehicle.setUser(this);
	}
}
