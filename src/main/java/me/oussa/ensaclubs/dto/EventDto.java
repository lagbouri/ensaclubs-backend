package me.oussa.ensaclubs.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import me.oussa.ensaclubs.model.Club;

import java.util.Date;

@Data
public class EventDto {
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Detail are mandatory")
    private String details;
    private String image;
    @NotNull(message = "Club id is mandatory")
    private Integer clubId;
    private Date date;
}
