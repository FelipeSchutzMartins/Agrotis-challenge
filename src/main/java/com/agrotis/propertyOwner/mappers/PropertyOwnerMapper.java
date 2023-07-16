package com.agrotis.propertyOwner.mappers;

import com.agrotis.laboratory.entity.Laboratory;
import com.agrotis.laboratory.mappers.LaboratoryMapper;
import com.agrotis.property.entity.Property;
import com.agrotis.property.mappers.PropertyMapper;
import com.agrotis.propertyOwner.dtos.request.CreatePropertyOwnerRequest;
import com.agrotis.propertyOwner.dtos.response.PropertyOwnerResponse;
import com.agrotis.propertyOwner.entity.PropertyOwner;

public class PropertyOwnerMapper {
    public static PropertyOwnerResponse buildResponse(PropertyOwner propertyOwner) {
        return PropertyOwnerResponse.builder()
                .id(propertyOwner.getId())
                .name(propertyOwner.getName())
                .observations(propertyOwner.getObservations())
                .startDate(propertyOwner.getStartDate())
                .endDate(propertyOwner.getEndDate())
                .property(PropertyMapper.buildResponse(propertyOwner.getProperty()))
                .laboratory(LaboratoryMapper.buildResponse(propertyOwner.getLaboratory()))
                .build();
    }

    public static PropertyOwner buildPropertyOwner(
            CreatePropertyOwnerRequest request,
            Property property,
            Laboratory laboratory) {
        return PropertyOwner.builder()
                .name(request.getName())
                .observations(request.getObservations())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .property(property)
                .laboratory(laboratory)
                .build();
    }
}
