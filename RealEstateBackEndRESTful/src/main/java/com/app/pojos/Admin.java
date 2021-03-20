package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "admins")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	@Column(length = 50)
	private String adminName;
	@Column(length = 50, unique = true, nullable = false)
	private String adminEmail;
	@Column(length = 20, nullable = false)
	private String adminPassword;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate adminRegistDate;
	
	public Admin() {
		System.out.println("in admin ctor");
	}

	public Admin(String adminName, String adminEmail, String adminPassword, LocalDate adminRegistDate) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminRegistDate = adminRegistDate;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public LocalDate getAdminRegistDate() {
		return adminRegistDate;
	}

	public void setAdminRegistDate(LocalDate adminRegistDate) {
		this.adminRegistDate = adminRegistDate;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + ", adminRegistDate=" + adminRegistDate + "]";
	}

	
}
