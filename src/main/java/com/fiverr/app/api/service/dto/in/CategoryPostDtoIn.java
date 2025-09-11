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
@Schema(description = "Categoría del canal")
public class CategoryPostDtoIn {

    @Schema(description = "ID de la categoría", example = "101")
    private Integer id;
}
