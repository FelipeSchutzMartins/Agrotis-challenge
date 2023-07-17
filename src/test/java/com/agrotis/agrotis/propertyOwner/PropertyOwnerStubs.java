package com.agrotis.agrotis.propertyOwner;

import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.property.entity.Property;
import com.agrotis.propertyOwner.entity.PropertyOwner;

import java.time.LocalDate;

public class PropertyOwnerStubs {

    public static PropertyOwner createPropertyOwnerStub(Property property, Laboratory laboratory) {
        return PropertyOwner.builder()
                .name("Jon doe")
                .startDate(LocalDate.of(2022, 2, 2))
                .endDate(LocalDate.of(2022, 2, 2))
                .property(property)
                .laboratory(laboratory)
                .build();
    }
}
