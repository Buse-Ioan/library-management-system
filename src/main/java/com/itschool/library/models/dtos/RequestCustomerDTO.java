package com.itschool.library.models.dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RequestCustomerDTO {

    private String firstName;
    private String lastName;
    private String email;
}