package com.tns.shoppingmallsystem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShopOwnerController {
	@Autowired
	ShopOwnerService service;
	
	@GetMapping("/shopowner")
	public List<ShopOwner> searchShopOwner() {
		return service.searchShopOwner();
	}
	@GetMapping("/shopowner/{id}")
	public ResponseEntity<ShopOwner> searchShopOwnerById(@PathVariable Integer id) {
		try {
			ShopOwner so = service.searchShopOwnerById(id);
            return new ResponseEntity<>(so, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	@PostMapping("/shopowner")
    public void addCustomer(@RequestBody ShopOwner so) {
        service.addShopOwner(so);
    }

    @PutMapping("/shopowner/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody ShopOwner so, @PathVariable Integer id) {
        try {
            service.updateShopOwner(so, id);
            return new ResponseEntity<>(so, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/shopowner/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteShopOwner(id);
    }
}
