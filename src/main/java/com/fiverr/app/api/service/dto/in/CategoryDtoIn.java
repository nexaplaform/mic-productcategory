package com.fiverr.app.api.service.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoIn {

    @Schema(example = "Restaurant")
    private String name;
    @Schema(example = "Fast food chain")
    private String description;
    @Schema(example = "True")
    private Boolean enabled;
}
