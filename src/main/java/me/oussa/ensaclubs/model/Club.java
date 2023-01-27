package me.oussa.ensaclubs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "creator")
@ToString(exclude = "creator")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String image;
    private boolean isActivated;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    @JsonBackReference
    private Student creator;
    @ManyToMany(mappedBy = "clubs")
    @JsonBackReference
    private Set<Student> members;
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Event> events;
    @LastModifiedDate
    private Date updatedAt;
    @CreatedDate
    private Date createdAt;
}