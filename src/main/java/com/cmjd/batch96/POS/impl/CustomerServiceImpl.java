package com.cmjd.batch96.POS.impl;

import com.cmjd.batch96.POS.dto.CustomerDto;
import com.cmjd.batch96.POS.entity.Customer;
import com.cmjd.batch96.POS.repo.CustomerRepo;
import com.cmjd.batch96.POS.service.CustomerService;
import com.cmjd.batch96.POS.util.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    //@Autowired

    private final CustomerRepo repo;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo repo, CustomerMapper customerMapper) {
        this.repo = repo;
        this.customerMapper = customerMapper;
    }


    @Override
    public String saveCustomer(CustomerDto dto) {
        return
                repo.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()))
                        .getName();
    }

    @Override
    public String updateCustomer(CustomerDto dto) {
        Optional<Customer> tempCustomer = repo.findById(dto.getId());
        if (tempCustomer.isPresent()){
            tempCustomer.get().setName(dto.getName());
            tempCustomer.get().setAddress(dto.getAddress());
            tempCustomer.get().setSalary(dto.getSalary());
            return repo.save(tempCustomer.get()).getName();
        }
        return "Customer Not Found";
    }

    @Override
    public String deleteCustomer(String id) {
        Optional<Customer> tempCustomer = repo.findById(id);
        if (tempCustomer.isPresent()){
            repo.delete(tempCustomer.get());
            return id+" Deleted!";
        }
        return "Can't find ";
    }

    @Override
    public CustomerDto getCustomer(String id) {

        Optional<Customer> customerData = repo.findById(id);
        return customerData.map(customer -> new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        )).orElse(null);

        /*if (customerData.isPresent()){
            return new CustomerDto(
                    customerData.get().getId(),
                    customerData.get().getName(),
                    customerData.get().getAddress(),
                    customerData.get().getSalary()
            );
        }else {
            return null;
        }*/
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers(int size, int page, String searchText) {
        List<Customer> all = repo.findAll();
        ArrayList<CustomerDto> dtos=new ArrayList<>();
        for (Customer c:all) {
            dtos.add(new CustomerDto(c.getId(),c.getName(),c.getAddress(),c.getSalary()));

        }
        return dtos;
    }
}
