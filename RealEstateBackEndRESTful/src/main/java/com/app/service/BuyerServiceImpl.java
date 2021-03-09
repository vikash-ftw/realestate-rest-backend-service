package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBuyerDao;
import com.app.pojos.Buyer;

@Service
@Transactional
public class BuyerServiceImpl implements IBuyerService {

	//D.I
	@Autowired
	private IBuyerDao buyerDao;
	
	public BuyerServiceImpl() {
		System.out.println("in buyer service mtd cld");
	}
	
	@Override
	public List<Buyer> getAllBuyers() {
		return buyerDao.findAll();
	}

	@Override
	public Buyer registerBuyer(Buyer b) {
		return buyerDao.save(b);
	}
	
}
