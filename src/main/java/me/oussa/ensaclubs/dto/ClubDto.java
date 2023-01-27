package me.oussa.ensaclubs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import me.oussa.ensaclubs.model.Event;
import me.oussa.ensaclubs.model.Student;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "students")
@ToString(exclude = "students")
public class ClubDto {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Category is mandatory")
    private String category;
    private String image;
    @NotNull(message = "Creator id is mandatory")
    private Integer creatorId;
    private boolean isActivated;
    private Date updatedAt;
    private Date createdAt;
    private Set<Student> students;
    private List<Event> events;
}