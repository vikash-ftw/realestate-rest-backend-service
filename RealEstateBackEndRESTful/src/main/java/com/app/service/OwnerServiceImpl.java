package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.IOwnerDao;
import com.app.pojos.Owner;

@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService{
	
	@Autowired
	private IOwnerDao ownerDao;
	
	public OwnerServiceImpl() {
		System.out.println("in OwnerService cld");
	}

	@Override
	public List<Owner> getAllOwners() {
		return ownerDao.findAll();
	}

	@Override
	public Owner saveOwner(Owner o) {
		return ownerDao.save(o);
	}

	@Override
	public Owner getOwner(String email, String password) {	
		System.out.println("in owner login service");
		return ownerDao.findByOwnerEmailAndOwnerPassword(email, password);
	}

	@Override
	public Owner getByOwnerId(int ownerId) {
		return ownerDao.findById(ownerId).orElseThrow(() -> new MyCustomException("ownerId "+ ownerId +" doesn't exist"));
	}

	@Override
	public Owner deleteByOwnerId(int ownerId) {
		Owner o= ownerDao.findById(ownerId).orElseThrow(() -> new MyCustomException("Owner Id "+ownerId+"not exits"));
		ownerDao.delete(o);
		return o;
		
	}

	@Override
	public Owner updateOwner(Owner o , int ownerId) {
		Owner owner = ownerDao.findById(ownerId).orElseThrow(() -> new MyCustomException("Owner Id "+ownerId+"not exits"));
		return ownerDao.save(o);
		
	}
	
	
	
	
	
}
