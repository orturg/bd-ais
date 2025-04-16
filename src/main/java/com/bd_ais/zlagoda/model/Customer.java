package com.bd_ais.zlagoda.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Customer extends User{
    private Integer percent;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, String patronymic, String phone_number, String city, String street, String zip_code, String email, String password, Integer percent) {
        super(id, name, surname, patronymic, phone_number, city, street, zip_code, email, password);
        this.percent = percent;
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
