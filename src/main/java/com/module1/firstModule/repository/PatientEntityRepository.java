package com.module1.firstModule.repository;

import com.module1.firstModule.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {
}