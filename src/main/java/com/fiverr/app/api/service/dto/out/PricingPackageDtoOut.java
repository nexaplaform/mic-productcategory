package com.fiverr.app.api.service.dto.out;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Paquete de precios del canal")
public class PricingPackageDtoOut {

    @Schema(description = "Nombre del paquete", example = "Básico")
    private String name;

    @Schema(description = "Descripción del paquete", example = "Un concepto de logo. Incluye un archivo PNG.")
    private String description;

    @Schema(description = "Precio del paquete", example = "25.00")
    private Double price;

    @Schema(description = "Tiempo de entrega en días", example = "1")
    private Integer deliveryTimeInDays;

    @Schema(description = "Número de revisiones incluidas", example = "1")
    private Integer revisions;
}
