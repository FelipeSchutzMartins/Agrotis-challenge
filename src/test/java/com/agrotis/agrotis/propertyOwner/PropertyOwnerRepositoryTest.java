package com.agrotis.agrotis.propertyOwner;

import com.agrotis.agrotis.laboratory.LaboratoryStubs;
import com.agrotis.agrotis.property.PropertyStubs;
import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.laboratory.repository.LaboratoryRepository;
import com.agrotis.property.entity.Property;
import com.agrotis.property.repository.PropertyRepository;
import com.agrotis.propertyOwner.repository.PropertyOwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PropertyOwnerRepositoryTest {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Test
    void shouldSaveProperty() {
        Property property = propertyRepository.save(PropertyStubs.createPropertyStub());
        Laboratory laboratory = laboratoryRepository.save(LaboratoryStubs.createLaboratoryStub());
        propertyOwnerRepository.save(PropertyOwnerStubs.createPropertyOwnerStub(property, laboratory));

        assertEquals(1, propertyOwnerRepository.findAll().size());
    }

}
