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
public class CategorytDtoOut {

    @Schema(example = "1")
    private Long id;
    @Schema(example = "Restaurant")
    private String name;
    @Schema(example = "Fast food chain")
    private String description;
    @Schema(example = "True")
    private Boolean enabled;
}
