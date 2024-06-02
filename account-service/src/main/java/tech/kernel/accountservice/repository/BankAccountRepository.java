package tech.kernel.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.kernel.accountservice.entities.BankAccount;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
