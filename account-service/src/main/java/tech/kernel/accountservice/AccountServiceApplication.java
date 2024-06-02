package tech.kernel.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tech.kernel.accountservice.clients.CustomerRestClient;
import tech.kernel.accountservice.entities.BankAccount;
import tech.kernel.accountservice.enums.AccountType;
import tech.kernel.accountservice.repository.BankAccountRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
		return args -> {

			customerRestClient.allCustomers().forEach(c -> {

				BankAccount bankAccount = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(Math.random() * 8000)
						.createAt(LocalDateTime.now())
						.currency("USD")
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();

				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(Math.random() * 8097)
						.createAt(LocalDateTime.now())
						.currency("USD")
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(Long.valueOf(1))
						.build();
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.balance(Math.random() * 8034)
						.createAt(LocalDateTime.now())
						.currency("USD")
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(Long.valueOf(2))
						.build();
				bankAccountRepository.save(bankAccount);
				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
			});

		};


	}
}
