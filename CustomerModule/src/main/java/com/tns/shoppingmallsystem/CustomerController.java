package com.tns.shoppingmallsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tns.shoppingmallsystem.model.Customer;
import com.tns.shoppingmallsystem.model.Item;
import com.tns.shoppingmallsystem.model.Mall;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;
    
    @GetMapping("/items/search")
    public List<Item> searchItem(@RequestParam String itemName) {
        return service.searchItem(itemName);
    }

    @PostMapping("/items/order")
    public ResponseEntity<Item> orderItem(@RequestBody Item item) {
        Item orderedItem = service.orderItem(item);
        return new ResponseEntity<>(orderedItem, HttpStatus.CREATED);
    }

    @GetMapping("/malls/{id}")
    public ResponseEntity<Mall> searchMall(@PathVariable long id) {
        try {
            Mall mall = service.searchMall(id);
            return new ResponseEntity<>(mall, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable long orderId) {
        boolean result = service.cancelOrder(orderId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customers")
    public List<Customer> searchCustomer() {
        return service.searchCustomer();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer id) {
        try {
            Customer customer = service.searchCustomerById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        service.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        try {
            service.updateCustomer(customer, id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }
}
