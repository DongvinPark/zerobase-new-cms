package com.zerobase.application;

import com.zerobase.domain.SignInForm;
import com.zerobase.domain.model.CustomerEntity;
import com.zerobase.exception.CustomException;
import com.zerobase.exception.ErrorCode;
import com.zerobase.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {
    private final CustomerService customerService;

    public String customerLoginToken(SignInForm form){
        //1. 로그인 가능 여부
        CustomerEntity customerEntity = customerService.findValidCustomer(form.getEmail(), form.getPassword())
            .orElseThrow( () -> new CustomException(ErrorCode.LOGIN_CHECK_FAIL));

        //2. 토큰 발행


        //3. 토큰 리스펀스한다.

        return "";
    }
}
