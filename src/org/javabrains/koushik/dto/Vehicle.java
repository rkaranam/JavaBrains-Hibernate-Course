package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLES")
public class Vehicle {

	@Id @GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToMany(mappedBy = "vehicles") // Avoids Hibernate creating two mapping tables
	private Collection<UserDetails> usersList = new ArrayList<UserDetails>();
	
	public Collection<UserDetails> getUsersList() {
		return usersList;
	}
	public void setUsersList(Collection<UserDetails> usersList) {
		this.usersList = usersList;
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
		final int maxLen = 10;
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName="
				+ vehicleName + ", usersList="
				+ (usersList != null ? toString(usersList, maxLen) : null)
				+ "]";
	}
	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
}
