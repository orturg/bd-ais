package com.bd_ais.zlagoda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends User{
    @Column(name = "percent", nullable = false)
    private Integer percent;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, Integer percent) {
        super(id, name, surname, patronymic, phone_number, city, street, zip_code);
        this.percent = percent;
    }

    public Customer(Long id, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code) {
        super(id, name, surname, patronymic, phone_number, city, street, zip_code);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return Objects.equals(percent, customer.percent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent);
    }
}
