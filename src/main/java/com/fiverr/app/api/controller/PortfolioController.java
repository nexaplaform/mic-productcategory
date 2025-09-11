package com.fiverr.app.api.controller;

import com.fiverr.app.api.service.PortfolioApi;
import com.fiverr.app.api.service.dto.in.PortfolioDtoIn;
import com.fiverr.app.api.service.dto.out.PortfolioDtoOut;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/portfolios")
@Tag(name = "Portfolio", description = "Portfolio Administration.")
public class PortfolioController implements PortfolioApi {

    @Override
    public ResponseEntity<PortfolioDtoOut> create(PortfolioDtoIn dto) {
        return PortfolioApi.super.create(dto);
    }

    @Override
    public ResponseEntity<PortfolioDtoOut> findById(Long id) {
        return PortfolioApi.super.findById(id);
    }

    @Override
    public ResponseEntity<PortfolioDtoOut> update(PortfolioDtoIn dto, Long id) {
        return PortfolioApi.super.update(dto, id);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return PortfolioApi.super.deleteById(id);
    }

    @Override
    public ResponseEntity<List<PortfolioDtoOut>> findAll() {
        return PortfolioApi.super.findAll();
    }
}
