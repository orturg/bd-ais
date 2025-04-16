package com.bd_ais.zlagoda.dto;

import com.bd_ais.zlagoda.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private String surname;
    private String patronymic;
    private String phone_number;
    private String city;
    private String street;
    private String zip_code;
    private String email;
    private String password;
    private String empl_role;
    private Double salary;
    private Date date_of_birth;
    private Date date_of_start;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, String email, String password, String empl_role, Double salary, Date date_of_birth, Date date_of_start) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
        this.email = email;
        this.password = password;
        this.empl_role = empl_role;
        this.salary = salary;
        this.date_of_birth = date_of_birth;
        this.date_of_start = date_of_start;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", empl_role='" + empl_role + '\'' +
                ", salary=" + salary +
                ", date_of_birth=" + date_of_birth +
                ", date_of_start=" + date_of_start +
                '}';
    }
}
