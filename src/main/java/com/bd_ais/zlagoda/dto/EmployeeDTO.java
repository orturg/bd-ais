package com.bd_ais.zlagoda.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {
    private Long id_employee;
    private String name;
    private String surname;
    private String patronymic;
    private String phone_number;
    private String city;
    private String street;
    private String zip_code;
    private String empl_role;
    private BigDecimal salary;
    private Date date_of_birth;
    private Date date_of_start;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id_employee, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, String empl_role, BigDecimal salary, Date date_of_birth, Date date_of_start) {
        this.id_employee = id_employee;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
        this.empl_role = empl_role;
        this.salary = salary;
        this.date_of_birth = date_of_birth;
        this.date_of_start = date_of_start;
    }
}
