package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILandProperty;
import com.app.pojos.LandProperty;

@Service
@Transactional
public class LandPropertyServiceImpl implements ILandPropertyService {

	//D.I
	@Autowired
	private ILandProperty propertyDao;
	
	@Override
	public LandProperty saveNewProperty(LandProperty l) {
		return null;
	}

}
