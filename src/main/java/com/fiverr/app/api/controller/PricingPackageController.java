package com.fiverr.app.api.controller;

import com.fiverr.app.api.service.PricingPackageApi;
import com.fiverr.app.api.service.dto.in.PricingPackageDtoIn;
import com.fiverr.app.api.service.dto.out.PricingPackageDtoOut;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pricingPackages")
@Tag(name = "PricingPackage", description = "PricingPackage Administration.")
public class PricingPackageController implements PricingPackageApi {

    @Override
    public ResponseEntity<PricingPackageDtoOut> create(PricingPackageDtoIn dto) {
        return PricingPackageApi.super.create(dto);
    }

    @Override
    public ResponseEntity<PricingPackageDtoOut> findById(Long id) {
        return PricingPackageApi.super.findById(id);
    }

    @Override
    public ResponseEntity<PricingPackageDtoOut> update(PricingPackageDtoIn dto, Long id) {
        return PricingPackageApi.super.update(dto, id);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return PricingPackageApi.super.deleteById(id);
    }

    @Override
    public ResponseEntity<List<PricingPackageDtoOut>> findAll() {
        return PricingPackageApi.super.findAll();
    }
}
