package com.app.pojos;

import java.time.LocalDate;

public class LandProperty {
	private Integer propertyId;
	private int propertyArea;
	private int dimensionLength;
	private int dimensionBreadth;
	private double propertyPrice;
	private PropertyType propertyType;
	private OwnershipType ownershipType;
	private String latitude;
	private String longitude;
	private String propertyCity;
	private String propertyPincode;
	private LocalDate propertyRegistDate;
	
	public LandProperty() {
		System.out.println("in landProperty ctor");
	}

	public LandProperty(int propertyArea, int dimensionLength, int dimensionBreadth, double propertyPrice,
			PropertyType propertyType, OwnershipType ownershipType, String latitude, String longitude,
			String propertyCity, String propertyPincode) {
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
	}

	@Override
	public String toString() {
		return "LandProperty [propertyId=" + propertyId + ", propertyArea=" + propertyArea + ", dimensionLength="
				+ dimensionLength + ", dimensionBreadth=" + dimensionBreadth + ", propertyPrice=" + propertyPrice
				+ ", propertyType=" + propertyType + ", ownershipType=" + ownershipType + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", propertyCity=" + propertyCity + ", propertyPincode=" + propertyPincode
				+ "]";
	}
	
	
}
