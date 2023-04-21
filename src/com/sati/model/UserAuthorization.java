package com.sati.model;
// Generated 19 avr. 2023, 22:52:43 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserAuthorization generated by hbm2java
 */
@Entity
@Table(name = "user_authorization", catalog = "ismistock_bd")
public class UserAuthorization implements java.io.Serializable {

	private Integer userRoleId;
	private UserAuthentication userAuthentication;
	private String role;

	public UserAuthorization() {
	}

	public UserAuthorization(UserAuthentication userAuthentication, String role) {
		this.userAuthentication = userAuthentication;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USER_ROLE_ID", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public UserAuthentication getUserAuthentication() {
		return this.userAuthentication;
	}

	public void setUserAuthentication(UserAuthentication userAuthentication) {
		this.userAuthentication = userAuthentication;
	}

	@Column(name = "ROLE", length = 20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
