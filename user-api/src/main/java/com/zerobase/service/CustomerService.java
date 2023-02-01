package com.zerobase.service;

import com.zerobase.domain.model.CustomerEntity;
import com.zerobase.domain.repository.CustomerRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Optional<CustomerEntity> findValidCustomer(
        String email, String password
    ){
        return customerRepository.findByEmail(email).stream().filter(
            customerEntity -> customerEntity.isVerify() && customerEntity.getPassword().equals(password)
        ).findFirst();
    }

}
