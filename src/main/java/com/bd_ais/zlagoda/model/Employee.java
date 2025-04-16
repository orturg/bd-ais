package com.bd_ais.zlagoda.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Employee extends User{
    private Role empl_role;
    private BigDecimal salary;
    private Date date_of_birth;
    private Date date_of_start;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, String email, String password, Role empl_role, BigDecimal salary, Date date_of_birth, Date date_of_start) {
        super(id, name, surname, patronymic, phone_number, city, street, zip_code, email, password);
        this.empl_role = empl_role;
        this.salary = salary;
        this.date_of_birth = date_of_birth;
        this.date_of_start = date_of_start;
    }
}
