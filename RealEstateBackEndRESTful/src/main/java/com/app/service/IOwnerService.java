package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Owner;

public interface IOwnerService {
	
	List<Owner> getAllOwners();
	
	Owner saveOwner(Owner o);

}
