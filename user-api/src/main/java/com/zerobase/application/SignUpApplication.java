package com.zerobase.application;

import com.zerobase.client.SendMailForm;
import com.zerobase.domain.SignUpForm;
import com.zerobase.domain.model.CustomerEntity;
import com.zerobase.exception.CustomException;
import com.zerobase.exception.ErrorCode;
import com.zerobase.service.EmailSendService;
import com.zerobase.service.SignUpCustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpApplication {
    private final SignUpCustomerService signUpCustomerService;
    private final EmailSendService emailSendService;


    public void customerVerify(String email, String code){
        signUpCustomerService.verifyEmail(email, code);
    }



    public String customerSignUp(SignUpForm form){
        if(signUpCustomerService.isEmailExist(form.getEmail())){
            throw new CustomException(ErrorCode.ALREADY_REGISTER_USER);
        } else {
            CustomerEntity customerEntity = signUpCustomerService.signUp(form);

            String code = getRandomCode();

            SendMailForm sendMailForm = SendMailForm.builder()
                .from("mailgun@dongvin.com")
                .to(form.getEmail())
                .subject("Verify Your Email Address : ")
                .text(getVerificationEmailBody(
                    customerEntity.getEmail(), customerEntity.getName(), code
                ))
                .build();

            emailSendService.sendEmail(sendMailForm);

            signUpCustomerService.changeCustomerValidateEmail(
                customerEntity.getId(), code
            );
            return "회원가입에 성공하였습니다.";
        }
    }



    private String getRandomCode(){
        return RandomStringUtils.random(10,true,true);
    }



    private String getVerificationEmailBody(String email, String name, String code){
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello ").append(name).append("! Please Click Link for verification.\n\n")
            .append("http://localhost:8081/signup/verify/customer?email=")
            .append(email)
            .append("&code=")
            .append(code).toString();
    }
}
