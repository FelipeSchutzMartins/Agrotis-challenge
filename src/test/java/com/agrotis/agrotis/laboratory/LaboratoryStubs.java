package com.agrotis.agrotis.laboratory;

import com.agrotis.laboratory.entity.Laboratory;

public class LaboratoryStubs {

    public static Laboratory createLaboratoryStub() {
        return Laboratory.builder()
                .name("Agro Skynet")
                .build();
    }
}
