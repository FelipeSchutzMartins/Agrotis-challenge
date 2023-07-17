package com.agrotis.agrotis.property;

import com.agrotis.property.entity.Property;

public class PropertyStubs {

    public static Property createPropertyStub() {
        return Property.builder()
                .cnpj("08562685000171")
                .name("Agrotis 1")
                .build();
    }
}
