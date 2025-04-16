package com.bd_ais.zlagoda.controllers;

import com.bd_ais.zlagoda.dto.EmployeeDTO;
import com.bd_ais.zlagoda.model.Customer;
import com.bd_ais.zlagoda.model.Employee;
import com.bd_ais.zlagoda.model.Role;
import com.bd_ais.zlagoda.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showListEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/employees";
    }

    @GetMapping("/add")
    public String addEmployee() {
        return "employee/addEmployee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@Valid @ModelAttribute EmployeeDTO employeedto,
                              BindingResult result) {
        System.out.println(employeedto);
        Employee employee = new Employee(
                1L,
                employeedto.getName(),
                employeedto.getSurname(),
                employeedto.getPatronymic(),
                employeedto.getPhone_number(),
                employeedto.getCity(),
                employeedto.getStreet(),
                employeedto.getZip_code(),
                employeedto.getEmail(),
                employeedto.getPassword(),
                Role.valueOf(employeedto.getEmpl_role()),
                BigDecimal.valueOf(employeedto.getSalary()),
                employeedto.getDate_of_birth(),
                employeedto.getDate_of_start()
        );
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/delete")
    public String addCustomer(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String addCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", employeeService.getEmployeeById(id));
        return "customer/editCustomer";
    }

    @PostMapping("/{id}/edit")
    public String editCustomer(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employee";
    }
}
