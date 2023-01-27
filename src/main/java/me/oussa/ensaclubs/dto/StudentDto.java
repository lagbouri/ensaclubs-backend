package me.oussa.ensaclubs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import me.oussa.ensaclubs.model.Club;

import java.util.Date;
import java.util.Set;

@Data
public class StudentDto {
    private Integer id;
    private Integer apogee;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    private String phone;
    @Email(message = "Email should be valid")
    private String email;
    private String password;
    @NotBlank(message = "Filiere is mandatory")
    private String filiere;
    private String image;
    private Set<Club> clubs;
    private Date updatedAt;
    private Date createdAt;
}