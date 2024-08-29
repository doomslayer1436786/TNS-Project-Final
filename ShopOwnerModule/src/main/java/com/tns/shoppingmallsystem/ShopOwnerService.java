package com.tns.shoppingmallsystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShopOwnerService {
	@Autowired
	ShopOwnerRepo repo;
	
	public void addShopOwner(ShopOwner so) {
		repo.save(so);
	}
	
	public void updateShopOwner(ShopOwner so, Integer id) {
		if (repo.existsById(id)) {
            so.setId(id);
            repo.save(so);
        } else {
            throw new RuntimeException("Shop Owner not found");
        }
	}
	
	public List<ShopOwner> searchShopOwner() {
		return repo.findAll();
	}
	public ShopOwner searchShopOwnerById(Integer id) {
		Optional<ShopOwner> optionalCustomer = repo.findById(id);
        return optionalCustomer.orElseThrow(() -> new RuntimeException("Shop Owner not found"));
	}
	
	public void deleteShopOwner(Integer id) {
		repo.deleteById(id);;
	}
	 
	
}
