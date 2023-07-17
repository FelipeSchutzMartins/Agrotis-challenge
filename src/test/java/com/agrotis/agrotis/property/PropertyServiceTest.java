package com.agrotis.agrotis.property;

import com.agrotis.exceptions.AgrotisException;
import com.agrotis.property.repository.PropertyRepository;
import com.agrotis.property.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@DataJpaTest
public class PropertyServiceTest {

    @MockBean
    private PropertyRepository propertyRepository;

    @MockBean
    private PropertyService propertyService;

    @Test
    void shouldCreateProperty() throws AgrotisException {
        this.propertyService.create(Stubs.mockCreateRequest());

        assertEquals(1, this.propertyService.findAll().size());
    }

}
