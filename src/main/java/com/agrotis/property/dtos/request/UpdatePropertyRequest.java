package com.agrotis.property.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePropertyRequest {

    @NotNull(message = "Id inválido")
    private Long id;

    @NotNull(message = "Nome inválido")
    @NotBlank(message = "Nome inválido")
    private String name;

    @NotNull(message = "CNPJ inválido")
    @NotBlank(message = "CNPJ inválido")
    @Size(max = 14, message = "CNPJ inválido")
    private String cnpj;
}
