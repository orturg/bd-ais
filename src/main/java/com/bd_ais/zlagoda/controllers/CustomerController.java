package com.bd_ais.zlagoda.controllers;

import com.bd_ais.zlagoda.model.CustomerEntity;
import com.bd_ais.zlagoda.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String showListCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/customers";
    }

    @GetMapping("/{id}/delete")
    public String addCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String addCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer/editCustomer";
    }

    @PostMapping("/{id}/edit")
    public String editCustomer(@PathVariable Long id, @ModelAttribute CustomerEntity customer) {
        customer.setId(id); // Ensure the ID is set correctly
        customerService.updateCustomer(customer); // Update the customer
        return "redirect:/customers"; // Redirect to the customer list
    }

}
