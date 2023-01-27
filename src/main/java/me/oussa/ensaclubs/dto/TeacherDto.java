package me.oussa.ensaclubs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeacherDto {
    private Integer id;
    private String cin;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    private String phone;
    @Email(message = "Email should be valid")
    private String email;
    private String password;
    @NotBlank(message = "Department is mandatory")
    private String department;
}