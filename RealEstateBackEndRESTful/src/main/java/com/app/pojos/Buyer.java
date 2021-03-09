package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buyers")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer buyerId;
	@Column(length = 20)
	private String buyerName;
	@Column(length = 30, unique = true)
	private String buyerEmail;
	@Column(length = 20)
	private String buyerPassword;
	@Column(length = 10, unique = true)
	private String buyerPhoneNo;
	@Column(length = 20)
	private String buyerCity;
	@Column(length = 6)
	private String buyerPincode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate buyerRegistDate;

	@ManyToMany(mappedBy = "propertyBuyers")
	@Fetch(FetchMode.JOIN)
	private Set<LandProperty> landProperties = new HashSet<LandProperty>();

	public Buyer() {
		System.out.println("in buyer ctor");
	}

	public Buyer(String buyerName, String buyerEmail, String buyerPassword, String buyerPhoneNo, String buyerCity,
			String buyerPincode, LocalDate buyerRegistDate, Set<LandProperty> landProperties) {
		super();
		this.buyerName = buyerName;
		this.buyerEmail = buyerEmail;
		this.buyerPassword = buyerPassword;
		this.buyerPhoneNo = buyerPhoneNo;
		this.buyerCity = buyerCity;
		this.buyerPincode = buyerPincode;
		this.buyerRegistDate = buyerRegistDate;
		this.landProperties = landProperties;
	}
	
	

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerPassword() {
		return buyerPassword;
	}

	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public String getBuyerPhoneNo() {
		return buyerPhoneNo;
	}

	public void setBuyerPhoneNo(String buyerPhoneNo) {
		this.buyerPhoneNo = buyerPhoneNo;
	}

	public String getBuyerCity() {
		return buyerCity;
	}

	public void setBuyerCity(String buyerCity) {
		this.buyerCity = buyerCity;
	}

	public String getBuyerPincode() {
		return buyerPincode;
	}

	public void setBuyerPincode(String buyerPincode) {
		this.buyerPincode = buyerPincode;
	}

	public LocalDate getBuyerRegistDate() {
		return buyerRegistDate;
	}

	public void setBuyerRegistDate(LocalDate buyerRegistDate) {
		this.buyerRegistDate = buyerRegistDate;
	}

	public Set<LandProperty> getLandProperties() {
		return landProperties;
	}

	public void setLandProperties(Set<LandProperty> landProperties) {
		this.landProperties = landProperties;
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", buyerEmail=" + buyerEmail
				+ ", buyerPassword=" + buyerPassword + ", buyerPhoneNo=" + buyerPhoneNo + ", buyerCity=" + buyerCity
				+ ", buyerPincode=" + buyerPincode + ", buyerRegistDate=" + buyerRegistDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyerEmail == null) ? 0 : buyerEmail.hashCode());
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
		Buyer other = (Buyer) obj;
		if (buyerEmail == null) {
			if (other.buyerEmail != null)
				return false;
		} else if (!buyerEmail.equals(other.buyerEmail))
			return false;
		return true;
	}

}
