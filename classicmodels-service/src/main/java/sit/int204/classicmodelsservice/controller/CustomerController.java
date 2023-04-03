package sit.int204.classicmodelsservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.ListMapper;
import sit.int204.classicmodelsservice.PageDTO;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDto;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;
    @GetMapping("/pages")
    public PageDTO<SimpleCustomerDto> getCustomerPage(@RequestParam(defaultValue = "0")int page,
                                                      @RequestParam(defaultValue = "3")int size){
        Page<Customer> customerPage = service.getCustomerPage(page,size);
        return  listMapper.toPageDTO(customerPage,SimpleCustomerDto.class,modelMapper);
    }
    @GetMapping("/{customerId}")
    public SimpleCustomerDto getSimpleCustomerById(@PathVariable Integer customerId) {
        return modelMapper.map(service.getCustomerById(customerId), SimpleCustomerDto.class);
    }

    @GetMapping
    public List<SimpleCustomerDto> getSimpleCustomers() {
        List<Customer> customerList = service.getCustomers();
        return listMapper.mapList(customerList, SimpleCustomerDto.class, modelMapper);
//        List<SimpleCustomerDto> simpleCustomerDtoList = new ArrayList<>(customerList.size());
//        for (Customer c:customerList){
//            simpleCustomerDtoList.add(modelMapper.map(c,SimpleCustomerDto.class));
//        }
//        return simpleCustomerDtoList;
//        }
//        return customerList.stream().map(c -> modelMapper.map(c, SimpleCustomerDto.class)).collect(Collectors.toList());
//    }
    }
}