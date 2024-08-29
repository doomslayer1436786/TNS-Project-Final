package com.project.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IAdminService {

	@Autowired
	private IMallAdminRepository repo;
	
//	//Retrieve
	public List<MallAdmin> listAll(){
		return repo.findAll();
	}
	
	// Add a new MallAdmin
    public MallAdmin addMallAdmin(MallAdmin mallAdmin) {
        return repo.save(mallAdmin);
    }
    
    // Update an existing MallAdmin
    public MallAdmin updateMallAdmin(MallAdmin mallAdmin) {
        Optional<MallAdmin> existingMallAdmin = repo.findById(mallAdmin.getAd_id());
        if (existingMallAdmin.isPresent()) {
            return repo.save(mallAdmin);
        }
        return null;
    }

    // Search for a MallAdmin by ID
    public MallAdmin searchMallAdmin(int id) {
        return repo.findById(id).orElse(null);
    }

    // Delete a MallAdmin by ID
    public void deleteMallAdmin(int id) {
        repo.deleteById(id);
    }
	
}

