package tech.kernel.accountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
