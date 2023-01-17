package com.cmjd.batch96.POS.service;

import com.cmjd.batch96.POS.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerService {
    String saveCustomer(CustomerDto dto);
    String updateCustomer(CustomerDto dto);
    String deleteCustomer(String id);
    CustomerDto getCustomer(String id);
    ArrayList<CustomerDto> getAllCustomers(
            int size,int page, String searchText);
}
