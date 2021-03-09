package com.app.pojos;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	private String ownerPinCode;
	
	@OneToMany(mappedBy = "", cascade = CascadeType.ALL , orphanRemoval = true)
	private List<LandProperty> landProperties = new ArrayList<>();
	
	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(String ownerName, String ownerEmail, String ownerPassword, String ownerPhoneNo, String ownerIdProof,
			String ownerCity, String ownerPinCode, List<LandProperty> landProperties) {
		super();
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerPassword = ownerPassword;
		this.ownerPhoneNo = ownerPhoneNo;
		this.ownerIdProof = ownerIdProof;
		this.ownerCity = ownerCity;
		this.ownerPinCode = ownerPinCode;
		this.landProperties = landProperties;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerEmail=" + ownerEmail
				+ ", ownerPassword=" + ownerPassword + ", ownerPhoneNo=" + ownerPhoneNo + ", ownerIdProof="
				+ ownerIdProof + ", ownerCity=" + ownerCity + ", ownerPinCode=" + ownerPinCode + "]";
	}
	
	
	
	
	
	
	
	

}
