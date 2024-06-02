package tech.kernel.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kernel.customerservice.entities.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
