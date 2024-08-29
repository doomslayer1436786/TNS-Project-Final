package com.project.admin;

import java.util.List;
import java.util.NoSuchElementException;

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
public class MallAdminController {

	@Autowired
	private IAdminService service;
	
//	//Retrieve
	@GetMapping
	public List<MallAdmin> list(){
		return service.listAll();
	}
		
	// Add a new MallAdmin
    @PostMapping("/MallAdmin")
    public ResponseEntity<MallAdmin> addMallAdmin(@RequestBody MallAdmin mallAdmin) {
        try {
			MallAdmin savedAdmin = service.addMallAdmin(mallAdmin);
			return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

    // Get a MallAdmin by ID
    @GetMapping("/MallAdmin/{id}")
    public ResponseEntity<MallAdmin> getMallAdmin(@PathVariable int id) {
        try {
			MallAdmin mallAdmin = service.searchMallAdmin(id);
			return new ResponseEntity<>(mallAdmin, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    
    // Update an existing MallAdmin
    @PutMapping("/MallAdmin/{id}")
    public ResponseEntity<MallAdmin> updateMallAdmin(@RequestBody MallAdmin mallAdmin, @PathVariable int id) {
        mallAdmin.setAd_id((int) id);
        try {
			MallAdmin updatedAdmin = service.updateMallAdmin(mallAdmin);
			return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    
    // Delete a MallAdmin by ID
    @DeleteMapping("/MallAdmin/{id}")
    public ResponseEntity<Void> deleteMallAdmin(@PathVariable int id) {
        try {
			service.deleteMallAdmin(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
    }
    
    
}
