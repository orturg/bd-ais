package com.bd_ais.zlagoda.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDTO {
    private Long id;
    private String email;
    private String password;

    public CustomerDTO() {
    }

    public CustomerDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
