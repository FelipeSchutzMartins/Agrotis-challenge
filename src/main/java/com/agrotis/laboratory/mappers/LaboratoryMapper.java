package com.agrotis.laboratory.mappers;

import com.agrotis.laboratory.dtos.request.CreateLaboratoryRequest;
import com.agrotis.laboratory.dtos.response.LaboratoryResponse;
import com.agrotis.laboratory.entity.Laboratory;

public class LaboratoryMapper {

    public static LaboratoryResponse buildResponse(Laboratory laboratory) {
        return LaboratoryResponse.builder()
                .id(laboratory.getId())
                .nome(laboratory.getName())
                .build();
    }

    public static Laboratory buildLaboratory(CreateLaboratoryRequest request) {
        return Laboratory.builder()
                .name(request.getName())
                .build();
    }
}
