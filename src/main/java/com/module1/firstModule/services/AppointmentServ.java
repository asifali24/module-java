package com.module1.firstModule.services;


import com.module1.firstModule.entities.Appointment;
import com.module1.firstModule.entities.Dr;
import com.module1.firstModule.entities.PatientEntity;
import com.module1.firstModule.repository.AppointmentRepository;
import com.module1.firstModule.repository.DrRepository;
import com.module1.firstModule.repository.PatientEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentServ {

    private final DrRepository drRepository;
    private final PatientEntityRepository patientEntityRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServ(DrRepository drRepository, PatientEntityRepository patientEntityRepository, AppointmentRepository appointmentRepository) {
        this.drRepository = drRepository;
        this.patientEntityRepository = patientEntityRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Appointment createAppoint(LocalDateTime when , String reason , Long drId, Long patientId ){
        Dr dr = drRepository.findById(drId).orElseThrow();
        PatientEntity patientEntity=  patientEntityRepository.findById(patientId).orElseThrow();

        Appointment newApp = Appointment.builder()
                .appointmentTime(when)
                .reason(reason)
                .dr(dr)
                .patientEntity(patientEntity)
                .build();

        return appointmentRepository.save(newApp);
    }
}
