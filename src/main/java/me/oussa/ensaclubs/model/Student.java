package me.oussa.ensaclubs.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "clubs")
@ToString(exclude = "clubs")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer apogee;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String filiere;
    @Column(columnDefinition = "TEXT")
    private String image;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "students_clubs",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private Set<Club> clubs;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}