package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.IBuyerDao;
import com.app.pojos.Buyer;

@Service
@Transactional
public class BuyerServiceImpl implements IBuyerService {

	//D.I
	@Autowired
	private IBuyerDao buyerDao;
	
	public BuyerServiceImpl() {
		System.out.println("in buyerService cld");
	}
	
	@Override
	public List<Buyer> getAllBuyers() {
		return buyerDao.findAll();
	}

	@Override
	public Buyer registerBuyer(Buyer b) {
		return buyerDao.save(b);
	}

	@Override
	public Buyer getBuyerById(int buyerId) {	
		return buyerDao.findById(buyerId).orElseThrow(() -> new MyCustomException("BuyerId "+buyerId+" doesn't exist"));
	}

	@Override
	public Buyer deleteByBuyerId(int buyerId) {
		Buyer buyer = buyerDao.findById(buyerId)
				.orElseThrow(() -> new MyCustomException("id " + buyerId + " not exist"));
		buyerDao.delete(buyer);
		return buyer;
	}

	@Override
	public Buyer validateBuyerLogin(String email, String password) {
		return buyerDao.validateBuyerLogin(email, password);
	}
	
}
