package com.agrotis.agrotis.laboratory;

import com.agrotis.laboratory.repository.LaboratoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LaboratoryRepositoryTest {

    @Autowired
    private LaboratoryRepository repository;

    @Test
    void shouldSaveLaboratory() {
        this.repository.save(LaboratoryStubs.createLaboratoryStub());

        assertEquals(1, this.repository.findAll().size());
    }

}
