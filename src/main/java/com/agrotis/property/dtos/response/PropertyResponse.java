package com.agrotis.property.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyResponse {
    private Long id;
    private String name;
    private String cnpj;
}
