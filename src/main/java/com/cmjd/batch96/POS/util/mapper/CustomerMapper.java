package com.cmjd.batch96.POS.util.mapper;

import com.cmjd.batch96.POS.dto.CustomerDto;
import com.cmjd.batch96.POS.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDto dto);
    CustomerDto toCustomerDto(Customer customer);
}
