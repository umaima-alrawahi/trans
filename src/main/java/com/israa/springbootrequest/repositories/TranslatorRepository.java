package com.israa.springbootrequest.repositories;

import com.israa.springbootrequest.entities.TranslatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslatorRepository extends JpaRepository<TranslatorEntity, Long> {
}
