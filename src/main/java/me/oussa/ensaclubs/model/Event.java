package me.oussa.ensaclubs.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Detail are mandatory")
    private String details;
    @Column(columnDefinition = "TEXT")
    private String image;
    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonManagedReference
    private Club club;
    private Date date;
}
