package com.eazybytes.accounts.service.clients;


import com.eazybytes.accounts.dto.CustomerDetailsDto;
import org.springframework.web.bind.annotation.RequestParam;

public interface ICustomersServie {
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
