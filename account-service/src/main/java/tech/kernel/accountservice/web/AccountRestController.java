package tech.kernel.accountservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kernel.accountservice.clients.CustomerRestClient;
import tech.kernel.accountservice.entities.BankAccount;
import tech.kernel.accountservice.entities.Customer;
import tech.kernel.accountservice.repository.BankAccountRepository;

import java.util.List;


@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountLIst() {

       List<BankAccount> bankAccounts = bankAccountRepository.findAll();
       bankAccounts.forEach(b -> {
           Customer customer = customerRestClient.findCustomerById(b.getCustomerId());
           b.setCustomer(customer);
       });

       return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount accountById(@PathVariable String id) {
         BankAccount bankAccount = bankAccountRepository.findById(id).get();
         Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
         return bankAccount;
    }




}
