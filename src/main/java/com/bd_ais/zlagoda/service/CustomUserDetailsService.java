package com.bd_ais.zlagoda.service;

import com.bd_ais.zlagoda.config.AppUserDetails;
import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService  implements UserDetailsService {
    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomUserDetailsService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customerOpt = customerService.getCustomerByEmail(email);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            return new AppUserDetails(customer.getEmail(), customer.getPassword(), "CUSTOMER");
        }

        throw new UsernameNotFoundException("User not found");
    }
}
