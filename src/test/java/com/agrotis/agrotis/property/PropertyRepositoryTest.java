package com.agrotis.agrotis.property;

import com.agrotis.property.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PropertyRepositoryTest {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void shouldSaveProperty() {
        propertyRepository.save(PropertyStubs.createPropertyStub());

        assertEquals(1, propertyRepository.findAll().size());
    }

}
