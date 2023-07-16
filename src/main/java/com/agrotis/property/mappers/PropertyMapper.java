package com.agrotis.property.mappers;

import com.agrotis.property.dtos.request.CreatePropertyRequest;
import com.agrotis.property.dtos.response.PropertyResponse;
import com.agrotis.property.entity.Property;

public class PropertyMapper {


    public static PropertyResponse buildResponse(Property property) {
        return PropertyResponse.builder()
                .id(property.getId())
                .name(property.getName())
                .cnpj(property.getCnpj())
                .build();
    }

    public static Property buildProperty(CreatePropertyRequest request) {
        return Property.builder()
                .cnpj(request.getCnpj())
                .name(request.getName())
                .build();
    }
}
