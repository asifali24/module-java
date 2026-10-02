package com.module1.firstModule.repository;

import com.module1.firstModule.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
