package com.fiverr.app.api.service.dto.out;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@With
@Data
@Builder
@AllArgsConstructor
public class SubCategoryDtoOut {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "Restaurante")
    private String name;

    @Schema(example = "Comida rapida")
    private String description;

    @Schema(example = "/home")
    private String route;

    @Schema(example = "true")
    private Boolean enabled;
}
