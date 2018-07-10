package com.codecool.present.microservice_present.repository;

import com.codecool.present.microservice_present.model.Present;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresentRepository extends JpaRepository<Present, Integer>{
}
