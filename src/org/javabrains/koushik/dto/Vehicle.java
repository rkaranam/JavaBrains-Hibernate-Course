package org.javabrains.koushik.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "LOGIN_ID"),
			@JoinColumn(name = "LOGIN_PASSWORD")
	})
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName="
				+ vehicleName + "]";
	}

}
