package com.SpringBoot.JPA_H2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$" , message = "number should be exactly 10 digits")
    private String number;
}
