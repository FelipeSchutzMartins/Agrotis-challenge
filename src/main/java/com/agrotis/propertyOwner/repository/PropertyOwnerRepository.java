package com.agrotis.propertyOwner.repository;

import com.agrotis.propertyOwner.entity.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {}
