package com.fiverr.app.api.service.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Portafolio del canal")
public class PortfolioDtoIn {

    @Schema(description = "Fecha del proyecto", example = "2025-09-10")
    private String date;

    @Schema(description = "Cliente del proyecto", example = "Cliente Ejemplo")
    private String client;

    @Schema(description = "Descripción del proyecto", example = "Diseño de logo minimalista para una marca de ropa.")
    private String description;

    @Schema(description = "Costo del proyecto", example = "300.00")
    private Double cost;

    @Schema(description = "Duración del proyecto", example = "2 semanas")
    private String duration;
}
