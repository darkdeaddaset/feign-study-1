package ru.savin.feign.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String city;
    private String state;
}
