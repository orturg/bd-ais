package com.bd_ais.zlagoda.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String phone_number;
    private String city;
    private String street;
    private String zip_code;
    private Integer percent;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, Integer percent) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.city = city;
        this.street = street;
        this.zip_code = zip_code;
        this.percent = percent;
    }
}
