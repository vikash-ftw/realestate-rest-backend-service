package com.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Excep.MyCustomException;
import com.app.dao.IBuyerDao;
import com.app.dao.ILandPropertyDao;
import com.app.dto.PropertyBuyerLink;
import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;

@Service
@Transactional
public class BuyerServiceImpl implements IBuyerService {

	//D.I
	@Autowired
	private IBuyerDao buyerDao;
	
	@Autowired
	private ILandPropertyDao propertyDao;
	
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
		Set<LandProperty> landSet = buyer.getLandProperties();
		if(landSet.size() > 0) {
			landSet.forEach( l -> {
				buyer.removeFavProperty(l);
			});
		}
		buyerDao.delete(buyer);
		return buyer;
	}

	@Override
	public Buyer validateBuyerLogin(String email, String password) {
		return buyerDao.validateBuyerLogin(email, password);
	}	
	
	//update buyer
	@Override
	public Buyer updateBuyerById(Buyer b, int buyerId) {
		Buyer buyer = buyerDao.findById(buyerId)
				.orElseThrow(() -> new MyCustomException("No buyer exist with id "+ buyerId));
		return buyerDao.save(b);
	}
	
	//property buyer favourite link
	@Override
	public String markFav(PropertyBuyerLink pbl) {
		String msg = "linked failed";
		LandProperty prop = propertyDao.findById(pbl.getPropertyId())
				.orElseThrow(() -> new MyCustomException("invalid propId"));
		Buyer buyer = buyerDao.findById(pbl.getBuyerId())
				.orElseThrow(() -> new MyCustomException("invalid buyerId"));
		buyer.addFavProperty(prop);
		msg = "link established";
		return msg;
	}

	@Override
	public String unFav(PropertyBuyerLink pbl) {
		String msg = "unmarking fav failed";
		LandProperty prop = propertyDao.findById(pbl.getPropertyId())
				.orElseThrow(() -> new MyCustomException("invalid propId"));
		Buyer buyer = buyerDao.findById(pbl.getBuyerId())
				.orElseThrow(() -> new MyCustomException("invalid buyerId"));
		buyer.removeFavProperty(prop);
		msg = "unmarking fav successfull";
		return msg;
	}
	
	@Override
	public Set<LandProperty> grabAllfav(int buyerId) {
		Buyer buyer = buyerDao.findById(buyerId)
				.orElseThrow(() -> new MyCustomException("invalid buyerId"));
		return buyer.getLandProperties();
	}
}
