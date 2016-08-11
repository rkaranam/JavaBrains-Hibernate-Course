package org.javabrains.koushik.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Credentials implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "LOGIN_ID")
	private String loginId;
	
	@Column(name = "LOGIN_PASSWORD")
	private String loginPassword;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Override
	public String toString() {
		return "Credentials [loginId=" + loginId + ", loginPassword="
				+ loginPassword + "]";
	}

}
