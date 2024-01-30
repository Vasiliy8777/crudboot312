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
    @Size(min=2, max=50,message = "Name is too long")
    private String name;
    @Column
    @NotBlank(message = "Surname should not be empty")
    @Size(min=2, max=50,message = "Surname is too long")
    private String surname;
    @Column
    @NotBlank(message = "Age should not be empty")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @Column
    @Email(message = "Email should not be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

//    public User() {
//    }
//
//    public User(String name, String surname, int age, String email) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }

}
