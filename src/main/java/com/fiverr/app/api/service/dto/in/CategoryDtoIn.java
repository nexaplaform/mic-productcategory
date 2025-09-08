package com.fiverr.app.api.service.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDtoIn {

    @NotBlank
    @Schema(example = "Restaurant")
    private String name;

    @NotBlank
    @Schema(example = "Fast food chain")
    private String description;

    @Schema(example = "/home")
    private String route;

    @NonNull
    @Schema(example = "True")
    private Boolean enabled;
}
