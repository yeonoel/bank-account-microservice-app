package tech.kernel.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import tech.kernel.accountservice.enums.AccountType;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor @Builder
@Entity
public class BankAccount {

    @Id
    private String accountId;
    private Double balance;
    private LocalDateTime createAt ;
    private String currency;
    @Transient
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
}
