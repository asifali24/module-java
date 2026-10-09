package com.module1.firstModule.repository;

import com.module1.firstModule.entities.Dr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrRepository extends JpaRepository<Dr, Long> {
}