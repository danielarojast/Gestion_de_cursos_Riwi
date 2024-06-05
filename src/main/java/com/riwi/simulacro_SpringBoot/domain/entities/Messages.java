package com.riwi.simulacro_SpringBoot.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="messages")
@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id; 
    @Lob
    @Column(nullable = false)
    private String message_content;

    @Column(nullable = false)
    @Builder.Default
    private LocalDate sent_date= LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sender_id",referencedColumnName = "id")
    private Users usersSender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_id", referencedColumnName = "id")
    private Users usersReceiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", referencedColumnName = "id")
    private Courses courses;
}
