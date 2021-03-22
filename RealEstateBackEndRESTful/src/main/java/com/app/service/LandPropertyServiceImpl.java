package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.ILandPropertyDao;
import com.app.dao.IOwnerDao;
import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;
import com.app.pojos.Owner;
import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;

@Service
@Transactional
public class LandPropertyServiceImpl implements ILandPropertyService {

	//D.I
	@Autowired
	private ILandPropertyDao propertyDao;
	
	@Autowired
	private IOwnerDao ownerDao;
	
	public LandPropertyServiceImpl() {
		System.out.println("in land service cld");
	}
	
	@Override
	public LandProperty saveNewProperty(LandProperty l) {
		return propertyDao.save(l);
	}

	@Override
	public List<LandProperty> fetchPropertyByOId(int ownerId) {
		return propertyDao.findByPropertyOwner(ownerId);
	}


	@Override
	public List<LandProperty> fetchPropertyByCity(String city) {
//		return propertyDao.findByPropertyCity(city);
//		return propertyDao.findByPropertyCityLike(city);
		return propertyDao.findByPropertyCityContaining(city);
	}


	@Override
	public LandProperty deletePropertyById(int ownerId, int propId) {
		System.out.println("service method cld to del prop");
		Owner validOwner = ownerDao.findByOwnerId(ownerId)
				.orElseThrow(() -> new MyCustomException("ownerId "+ownerId+" doesn't exist"));
		LandProperty validProp = propertyDao.findById(propId)
				.orElseThrow(() -> new MyCustomException("propertyId "+propId+" doesn't exist"));
		
		validOwner.removeProperty(validProp);
		propertyDao.deleteById(propId);
		return validProp;
	}
		

	@Override
	public LandProperty fetchById(int propId) {
		return propertyDao.findById(propId).orElseThrow(() -> new MyCustomException("PropertyId "+ propId +" doesn't exist"));
	}

	@Override
	public LandProperty updateProperty(int propId, LandProperty l) {
		LandProperty pl=propertyDao.findById(propId)
				.orElseThrow(() -> new MyCustomException("propId "+ propId+" not exists."));
		propertyDao.save(l);
		return pl;
	}
	
	@Override
	public List<Buyer> fetchAllFavBuyers(int propId) {
		LandProperty prop = fetchById(propId);
		List<Buyer> favBuyers  = new ArrayList<>();
		for(Buyer b : prop.getPropertyBuyers()) {
			favBuyers.add(b);
		}
		return favBuyers;
	}


	@Override
	public List<LandProperty> fetchPropByType(PropertyType propType) {
		
		return propertyDao.findByPropertyType(propType);
	}

	@Override
	public List<LandProperty> fetchPropByOwnerType(OwnershipType ownerType) {
		return propertyDao.findByOwnershipType(ownerType);
	}

	@Override
	public List<LandProperty> fetchPropertyByPriceBetween(double minPrice, double maxPrice) {
		return propertyDao.findByPropertyPriceBetween(minPrice, maxPrice);
	}
	
	@Override
	public List<LandProperty> fetchPropertyByPriceGreater(double minPrice) {
		return propertyDao.findByPropertyPriceGreaterThan(minPrice);
	}
	
	@Override
	public List<LandProperty> fetchPropertyByDimension(double length, double breadth) {
		return propertyDao.findByDimensionRange(length, breadth);
	}

}
