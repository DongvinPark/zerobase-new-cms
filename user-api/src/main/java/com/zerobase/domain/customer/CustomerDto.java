package com.zerobase.domain.customer;

import com.zerobase.domain.model.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    private String email;

    public static CustomerDto from(CustomerEntity customerEntity){
        return new CustomerDto(customerEntity.getId(), customerEntity.getEmail());
    }
}
