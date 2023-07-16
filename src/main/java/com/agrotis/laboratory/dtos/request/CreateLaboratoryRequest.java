package com.agrotis.laboratory.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLaboratoryRequest {

    @NotNull(message = "Nome inválido")
    @NotBlank(message = "Nome inválido")
    private String name;

}
