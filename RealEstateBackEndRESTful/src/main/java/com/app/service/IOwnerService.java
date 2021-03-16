package com.app.service;

import java.util.List;

import com.app.pojos.Owner;

public interface IOwnerService {
	
	List<Owner> getAllOwners();
	
	Owner saveOwner(Owner o);
	
	Owner getOwner(String email , String password);
	
	Owner getByOwnerId(int ownerId);
	
	Owner deleteByOwnerId(int ownerId);
	
	Owner updateOwner(Owner o , int ownerId);

}
