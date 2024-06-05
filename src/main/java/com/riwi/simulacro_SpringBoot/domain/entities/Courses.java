package com.riwi.simulacro_SpringBoot.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="courses")
@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id; 
    @Column(length = 100, nullable = false)
    private String course_name;
    @Lob 
    private String description; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="instructor_id" , referencedColumnName = "id")
    private Users instructor;

    @OneToMany(mappedBy = "courses", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Enrollments> enrollments;

    @OneToMany(mappedBy = "courses", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Messages> messages;

    @OneToMany(mappedBy = "courses", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Lessons> lessons; 

}
