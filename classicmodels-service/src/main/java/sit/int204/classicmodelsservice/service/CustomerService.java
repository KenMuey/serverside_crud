package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer getCustomerById(Integer customerId) {
        return repository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer id " + customerId + "Does Not Exist !!!"));
    }
    public List<Customer> getCustomers(){
        return repository.findAll();
    }
    public Page<Customer> getCustomerPage(int page, int size){
        return repository.findAll(PageRequest.of(page,size));
    }
}