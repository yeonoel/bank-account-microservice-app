package tech.kernel.customerservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.kernel.customerservice.entities.Customer;
import tech.kernel.customerservice.repository.CustomerRepository;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable String id) {
        return customerRepository.findById(Long.parseLong(id)).get();
    }




}
