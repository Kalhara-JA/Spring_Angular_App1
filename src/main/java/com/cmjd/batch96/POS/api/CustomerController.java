package com.cmjd.batch96.POS.api;

import com.cmjd.batch96.POS.dto.CustomerDto;
import com.cmjd.batch96.POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    //POST ==>(body)
    @PostMapping
    public String saveCustomer(@RequestBody CustomerDto dto){

        return customerService.saveCustomer(dto)+"Saved";
    }

    //PUT ==>(body)
    @PutMapping
    public String updateCustomer(@RequestBody CustomerDto dto){

        return customerService.updateCustomer(dto)+"Updated";
    }

    //DELETE ==>(body)
    @DeleteMapping
    public String deleteCustomer(@RequestParam String id){

        return customerService.deleteCustomer(id)+" Deleted";
    }

    //GET ==? (headers)
    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    //GET ==>(Headers)
    @GetMapping("/list")
    public ArrayList<CustomerDto> getAllCustomers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText){
        return customerService.getAllCustomers(page,size,searchText);
    }

}
