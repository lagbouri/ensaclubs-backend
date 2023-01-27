package me.oussa.ensaclubs.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String object;
    @Column(columnDefinition = "TEXT")
    private String details;
    @Column(columnDefinition = "TEXT")
    private String image;
    @Column(columnDefinition = "boolean default false")
    private boolean isAccepted;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Student creator;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}
