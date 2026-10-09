package com.module1.firstModule.services;

import com.module1.firstModule.entities.PatientEntity;
import com.module1.firstModule.repository.PatientEntityRepository;
import org.springframework.stereotype.Service;


@Service
public class PatientServ {

    private final PatientEntityRepository  patientEntityRepository;

    public PatientServ(PatientEntityRepository patientEntityRepository) {
        this.patientEntityRepository = patientEntityRepository;
    }

    public PatientEntity createPatient(String name, int age, String reason){
        PatientEntity newPatient = PatientEntity.builder()
                .name(name)
                .age(age)
                .reason(reason)
                .build();

        return patientEntityRepository.save(newPatient);
    }
}
