package tech.kernel.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import tech.kernel.customerservice.config.GlobalConfig;
import tech.kernel.customerservice.entities.Customer;
import tech.kernel.customerservice.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList= List.of(

					Customer.builder()
							.email("Xu5Jh@example.com")
							.firstName("John")
							.lastName("Doe")
							.build(),
					Customer.builder()
							.email("Xu5Jh@example.com")
							.firstName("Jane")
							.lastName("Doe")
							.build(),
					Customer.builder()
							.email("Xu5Jh@example.com")
							.firstName("Light")
							.lastName("Yagami")
							.build()
			) ;
			customerRepository.saveAll(customerList);
		};
	}
}
