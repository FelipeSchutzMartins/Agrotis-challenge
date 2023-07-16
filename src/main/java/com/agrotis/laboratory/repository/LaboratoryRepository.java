package com.agrotis.laboratory.repository;

import com.agrotis.laboratory.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {}
