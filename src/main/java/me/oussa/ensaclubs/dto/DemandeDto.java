package me.oussa.ensaclubs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class DemandeDto {
    private Long id;
    @NotBlank(message = "Object is mandatory")
    private String object;
    @NotBlank(message = "Details are mandatory")
    private String details;
    private String image;
    private boolean isAccepted;
    @NotNull(message = "Creator id is mandatory")
    private Integer creatorId;
    @NotNull(message = "Club id is mandatory")
    private Integer clubId;
    private Date updatedAt;
    private Date createdAt;
}
