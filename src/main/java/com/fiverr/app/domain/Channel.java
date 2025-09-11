package com.fiverr.app.domain;

import lombok.*;

import java.util.List;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    private Long id;
    private String channelName;
    private String title;
    private String description;
    private String url;
    private String requirements;
    private Category category;
    private List<String> tags;
    private List<PricingPackage> pricingPackages;
    private List<Portfolio> portfolio;

}
