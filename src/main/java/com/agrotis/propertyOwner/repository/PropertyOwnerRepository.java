package com.agrotis.propertyOwner.repository;

import com.agrotis.propertyOwner.entity.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {}
