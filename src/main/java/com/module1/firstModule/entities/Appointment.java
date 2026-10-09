package com.module1.firstModule.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime;

    private String reason;

    @ManyToOne
    @JoinColumn(name ="patientId" )
    private PatientEntity patientEntity;

    @ManyToOne
    @JoinColumn(name = "drId")
    private Dr dr;
}
