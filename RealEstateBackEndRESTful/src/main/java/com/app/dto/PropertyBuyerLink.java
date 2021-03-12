package com.app.dto;

public class PropertyBuyerLink {
	private int propertyId;
	private int buyerId;
	
	public PropertyBuyerLink() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	@Override
	public String toString() {
		return "PropertyBuyerLink [propertyId=" + propertyId + ", buyerId=" + buyerId + "]";
	}
	
	
}
