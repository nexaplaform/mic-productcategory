package com.fiverr.app.api.service.dto.in;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoIn {

    @NotBlank
    @Schema(example = "Restaurante", description = "Nombre de la categoría")
    private String name;

    @NotBlank
    @Schema(example = "Comida rápida", description = "Descripción detallada de la categoría")
    private String description;

    @Schema(example = "/home", description = "Ruta web asociada a la categoría")
    private String route;

    @NonNull
    @Schema(example = "True", description = "Estado de la categoría")
    private Boolean enabled;

    @ArraySchema(schema = @Schema(implementation = Integer.class, description = "Listado de ids de sub-categorias"))
    private List<Long> subCategoryIds;
}
