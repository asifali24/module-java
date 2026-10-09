package com.module1.firstModule.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "patient"
)
public class PatientEntity extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    private  String reason;

    private int age;


    @OneToMany(mappedBy = "patientEntity")
    private List<Appointment> appointment;
}
