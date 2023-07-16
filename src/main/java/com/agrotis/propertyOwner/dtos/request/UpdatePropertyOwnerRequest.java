package com.agrotis.propertyOwner.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePropertyOwnerRequest {

    @NotNull(message = "Id inválido")
    private Long id;

    @NotNull(message = "Nome inválido")
    @NotBlank(message = "Nome não pode estar vazio")
    private String name;

    @NotNull(message = "Data inicial inválida")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Data final inválida")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

    private String observations;

    @NotNull(message = "Propriedade inválida")
    private Long propertyId;

    @NotNull(message = "Laboratorio inválido")
    private Long laboratoryId;
}
