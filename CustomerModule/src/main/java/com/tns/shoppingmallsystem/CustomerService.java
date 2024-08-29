package com.tns.shoppingmallsystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.shoppingmallsystem.model.Customer;
import com.tns.shoppingmallsystem.model.Item;
import com.tns.shoppingmallsystem.model.Mall;
import com.tns.shoppingmallsystem.repository.CustomerRepo;
import com.tns.shoppingmallsystem.repository.ItemRepo;
import com.tns.shoppingmallsystem.repository.MallRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepo repo;
    

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private MallRepo mallRepo;

    

    public List<Item> searchItem(String itemName) {
        return itemRepo.findByName(itemName);
    }

    public Item orderItem(Item item) {
        return itemRepo.save(item);
    }

    public Mall searchMall(long id) {
        Optional<Mall> optionalMall = mallRepo.findById(id);
        return optionalMall.orElseThrow(() -> new RuntimeException("Mall not found"));
    }

    public boolean cancelOrder(long orderId) {
        if (itemRepo.existsById(orderId)) {
            itemRepo.deleteById(orderId);;
            return true;
        } else {
            return false;
        }
    }

    public List<Customer> searchCustomer() {
        return repo.findAll();
    }

    public Customer searchCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = repo.findById(id);
        return optionalCustomer.orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void addCustomer(Customer customer) {
        repo.save(customer);
    }

    public void updateCustomer(Customer customer, Integer id) {
        if (repo.existsById(id)) {
            customer.setId(id);
            repo.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void deleteCustomer(Integer id) {
        repo.deleteById(id);
    }
}
