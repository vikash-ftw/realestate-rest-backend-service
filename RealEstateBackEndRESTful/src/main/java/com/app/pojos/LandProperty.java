package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LandProperty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyId;

	private double propertyArea;

	private double dimensionLength;

	private double dimensionBreadth;

	private double propertyPrice;

	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;

	@Enumerated(EnumType.STRING)
	private OwnershipType ownershipType;

	private String latitude;

	private String longitude;

	@Column(length = 20)
	private String propertyCity;

	@Column(length = 6)
	private String propertyPincode;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate propertyRegistDate;

	@ManyToMany
	@JoinTable(name = "favProperty_buyers", joinColumns = @JoinColumn(name = "property_id"), inverseJoinColumns = @JoinColumn(name = "buyer_id"))
	private Set<Buyer> propertyBuyers = new HashSet<Buyer>();

	@ManyToOne
	@JoinColumn(name = "o_id", nullable = false)
	private Owner propertyOwner;

	public LandProperty() {
		System.out.println("in landProperty ctor");
	}

	public LandProperty(int propertyArea, int dimensionLength, int dimensionBreadth, double propertyPrice,
			PropertyType propertyType, OwnershipType ownershipType, String latitude, String longitude,
			String propertyCity, String propertyPincode, LocalDate propertyRegistDate, Set<Buyer> propertyBuyers,
			Owner propertyOwner) {
		super();
		this.propertyArea = propertyArea;
		this.dimensionLength = dimensionLength;
		this.dimensionBreadth = dimensionBreadth;
		this.propertyPrice = propertyPrice;
		this.propertyType = propertyType;
		this.ownershipType = ownershipType;
		this.latitude = latitude;
		this.longitude = longitude;
		this.propertyCity = propertyCity;
		this.propertyPincode = propertyPincode;
		this.propertyRegistDate = propertyRegistDate;
		this.propertyBuyers = propertyBuyers;
		this.propertyOwner = propertyOwner;
	}

	@Override
	public String toString() {
		return "LandProperty [propertyId=" + propertyId + ", propertyArea=" + propertyArea + ", dimensionLength="
				+ dimensionLength + ", dimensionBreadth=" + dimensionBreadth + ", propertyPrice=" + propertyPrice
				+ ", propertyType=" + propertyType + ", ownershipType=" + ownershipType + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", propertyCity=" + propertyCity + ", propertyPincode=" + propertyPincode
				+ ", propertyRegistDate=" + propertyRegistDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propertyId == null) ? 0 : propertyId.hashCode());
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
		LandProperty other = (LandProperty) obj;
		if (propertyId == null) {
			if (other.propertyId != null)
				return false;
		} else if (!propertyId.equals(other.propertyId))
			return false;
		return true;
	}

}
