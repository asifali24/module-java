package com.module1.firstModule.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dr {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "dr" , cascade = CascadeType.ALL)
    private Set<Appointment> appointmentList = new HashSet<>();
}
