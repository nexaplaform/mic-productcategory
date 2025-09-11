package com.fiverr.app.api.service.dto.out;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos de un canal")
public class ChannelDtoOut {

    @Schema(description = "Nombre del canal", example = "nombre de mi canal")
    private String channelName;

    @Schema(description = "Título del canal", example = "Viajera, Modelo, Arquitecta de profesion (descripcion corta del canal)")
    private String title;

    @Schema(description = "Descripción del canal", example = "Descripcion del canal")
    private String description;

    @Schema(description = "URL del canal", example = "https://dsfdsfdsfdf.com")
    private String url;

    @Schema(description = "Categoría del canal")
    private CategoryPostDtoOut category;

    @Schema(description = "Etiquetas relacionadas al canal")
    private List<String> tags;

    @Schema(description = "Paquetes de precios")
    private List<PricingPackageDtoOut> pricingPackages;

    @Schema(description = "Requerimientos del canal", example = "Necesito el nombre de la empresa, el eslogan (opcional) y cualquier preferencia de color o estilo.")
    private String requirements;

    @Schema(description = "Portafolio del canal")
    private List<PortfolioDtoOut> portfolio;
}
