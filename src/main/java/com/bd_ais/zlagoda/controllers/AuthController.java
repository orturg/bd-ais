package com.bd_ais.zlagoda.controllers;

import com.bd_ais.zlagoda.Jwt.JwtUtil;
import com.bd_ais.zlagoda.dto.CustomerDTO;
import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.service.impl.CustomerServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final CustomerServiceImpl customerService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(CustomerServiceImpl customerService, JwtUtil jwtUtil) {
        this.customerService = customerService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public String getAuthPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "auth/authWindow";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute CustomerDTO request, HttpServletResponse response) {
        System.out.println("Login request: " + request.getEmail() + ", " + request.getPassword());
        Optional<Customer> customerOpt = customerService.getCustomerByEmail(request.getEmail());
        System.out.println("Customer found: " + customerOpt.isPresent());
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            if (Objects.equals(request.getPassword(), customer.getPassword())) {
                String token = jwtUtil.generateToken(customer.getEmail(), "CUSTOMER", customer.getId());

                Cookie cookie = new Cookie("token", token);
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);

                return "redirect:/home";
            }
        }

        return "redirect:/auth";
    }
}
