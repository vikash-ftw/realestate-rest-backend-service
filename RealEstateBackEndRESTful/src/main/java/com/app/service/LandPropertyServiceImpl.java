package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.ILandProperty;
import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;
import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;

@Service
@Transactional
public class LandPropertyServiceImpl implements ILandPropertyService {

	//D.I
	@Autowired
	private ILandProperty propertyDao;
	
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
	public LandProperty deletePropertyByEntity(LandProperty l) {
		System.out.println("raeaching here to del prop");
		propertyDao.delete(l);
		System.out.println("delted prop");
		return l;
	}

	@Override
	public LandProperty fetchById(int propId) {
		return propertyDao.findById(propId).get();
	}

	@Override
	public LandProperty updateProperty(int propId, LandProperty l) {
		LandProperty pl=propertyDao.findById(propId).get();
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

	
	
}
