package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.ILandProperty;
import com.app.pojos.LandProperty;

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
	public List<LandProperty> fetchPropertyByCity(String city) {
		return propertyDao.findByPropertyCity(city);
	}

	@Override
	public LandProperty deletePropertyById(int propId) {
		LandProperty prop = propertyDao.findById(propId)
				.orElseThrow(() -> new MyCustomException("propertyId : "+ propId+" doesn't exist"));
		propertyDao.delete(prop);
		return prop;
	}

	@Override
	public LandProperty fetchById(int propId) {
		return propertyDao.findById(propId).get();
	}

	
}
