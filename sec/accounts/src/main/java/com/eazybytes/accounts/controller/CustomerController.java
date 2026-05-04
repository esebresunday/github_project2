package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.CustomerDetailsDto;
import com.eazybytes.accounts.service.clients.ICustomersServie;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
@Validated
public class CustomerController {
    private final ICustomersServie iCustomersServie;
    public CustomerController(ICustomersServie iCustomersServie) {
        this.iCustomersServie = iCustomersServie;
    }
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber){
       CustomerDetailsDto customerDetailsDto = iCustomersServie.fetchCustomerDetails(mobileNumber);
       return ResponseEntity.ok(customerDetailsDto);
    }
}
