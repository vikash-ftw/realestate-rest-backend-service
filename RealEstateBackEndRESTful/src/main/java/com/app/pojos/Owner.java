package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ownerId;
	
	@Column(length = 20)
	private String ownerName;
	
	@Column(length = 30 , unique = true)
	private String ownerEmail;
	
	@Column(length = 15)
	private String ownerPassword;
	
	@Column(length = 10 , unique = true)
	private String ownerPhoneNo;
	
	@Column(length = 16 , unique = true)
	private String ownerIdProof;
	
	@Column(length = 10)
	private String ownerCity;
	
	@Column(length = 6)
	private String ownerPincode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ownerRegistDate;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL , orphanRemoval = true)
	private List<LandProperty> landProperties = new ArrayList<>();
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String ownerName, String ownerEmail, String ownerPassword, String ownerPhoneNo, String ownerIdProof,
			String ownerCity, String ownerPincode, LocalDate ownerRegistDate, List<LandProperty> landProperties) {
		super();
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
		this.ownerPhoneNo = ownerPhoneNo;
		this.ownerIdProof = ownerIdProof;
		this.ownerCity = ownerCity;
		this.ownerPincode = ownerPincode;
		this.ownerRegistDate = ownerRegistDate;
		this.landProperties = landProperties;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public String getOwnerPhoneNo() {
		return ownerPhoneNo;
	}

	public void setOwnerPhoneNo(String ownerPhoneNo) {
		this.ownerPhoneNo = ownerPhoneNo;
	}

	public String getOwnerIdProof() {
		return ownerIdProof;
	}

	public void setOwnerIdProof(String ownerIdProof) {
		this.ownerIdProof = ownerIdProof;
	}

	public String getOwnerCity() {
		return ownerCity;
	}

	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}

	public String getOwnerPincode() {
		return ownerPincode;
	}

	public void setOwnerPincode(String ownerPincode) {
		this.ownerPincode = ownerPincode;
	}

	public LocalDate getOwnerRegistDate() {
		return ownerRegistDate;
	}

	public void setOwnerRegistDate(LocalDate ownerRegistDate) {
		this.ownerRegistDate = ownerRegistDate;
	}

	public List<LandProperty> getLandProperties() {
		return landProperties;
	}

	public void setLandProperties(List<LandProperty> landProperties) {
		this.landProperties = landProperties;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail
				+ ", ownerPassword=" + ownerPassword + ", ownerPhoneNo=" + ownerPhoneNo + ", ownerIdProof="
				+ ownerIdProof + ", ownerCity=" + ownerCity + ", ownerPincode=" + ownerPincode + ", ownerRegistDate="
				+ ownerRegistDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		return true;
	}
	

}
