package com.riwi.simulacro_SpringBoot.domain.entities;

import java.util.List;

import com.riwi.simulacro_SpringBoot.utils.enums.RoleUsers;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name= "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String userName;
    @Column(nullable = false) 
    private String password;
    @Column(length = 100, nullable = false) 
    private String email;
    @Column(length = 100, nullable = false) 
    private String full_name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING) 
    private RoleUsers role; 

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL,orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Courses> courses;

    @OneToMany(mappedBy = "users", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Enrollments> enrollments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usersReceiver", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Messages> messagesReceived;

    @OneToMany(mappedBy = "usersSender", cascade= CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Messages> messagesSent;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Submissions> submissions;
}
