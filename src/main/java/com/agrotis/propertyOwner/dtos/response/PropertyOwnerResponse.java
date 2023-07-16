package com.agrotis.propertyOwner.dtos.response;

import com.agrotis.laboratory.dtos.response.LaboratoryResponse;
import com.agrotis.property.dtos.response.PropertyResponse;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class PropertyOwnerResponse {
    private Long id;
    private String name;
    private String observations;
    private Date startDate;
    private Date endDate;
    private PropertyResponse property;
    private LaboratoryResponse laboratory;
}
