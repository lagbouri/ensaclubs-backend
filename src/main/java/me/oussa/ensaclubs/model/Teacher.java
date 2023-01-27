package me.oussa.ensaclubs.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String cin;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String department;
}