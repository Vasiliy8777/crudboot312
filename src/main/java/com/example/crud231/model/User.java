package com.example.crud231.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "Name should not be empty")
    @Size(max = 50, message = "Name is too long")
    @Size(min = 2, message = "Name is too short")
    private String name;
    @Column
    @NotBlank(message = "Surname should not be empty")
    @Size(max = 50, message = "Surname is too long")
    @Size(min = 2, message = "Surname is too short")
    private String surname;
    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @Column
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    private String email;
}
