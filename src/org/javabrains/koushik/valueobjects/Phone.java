package org.javabrains.koushik.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "SERVICE_PROVIDER")
	private String provider;
	
	@Column(name = "COVERAGE_AREA")
	private String area;
	
	@Column(name = "PHONE_TYPE")
	private String phoneType;
	
	public Phone() {
		
	}
	
	public Phone(String phoneNumber, String provider, String area, String phoneType) {
		super();
		this.phoneNumber = phoneNumber;
		this.provider = provider;
		this.area = area;
		this.phoneType = phoneType;
	}
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + ", provider=" + provider
				+ ", area=" + area + ", phoneType=" + phoneType + "]";
	}

}
