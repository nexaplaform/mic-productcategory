package com.fiverr.app.api.controller;


import com.fiverr.app.api.service.ChannelApi;
import com.fiverr.app.api.service.dto.in.ChannelDtoIn;
import com.fiverr.app.api.service.dto.out.ChannelDtoOut;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/chanels")
@Tag(name = "Chanel", description = "Chanel Administration.")
public class ChannelController implements ChannelApi {

    @Override
    public ResponseEntity<ChannelDtoOut> create(ChannelDtoIn dto) {
        return ChannelApi.super.create(dto);
    }

    @Override
    public ResponseEntity<ChannelDtoOut> findById(Long id) {
        return ChannelApi.super.findById(id);
    }

    @Override
    public ResponseEntity<ChannelDtoOut> update(ChannelDtoIn dto, Long id) {
        return ChannelApi.super.update(dto, id);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return ChannelApi.super.deleteById(id);
    }

    @Override
    public ResponseEntity<List<ChannelDtoOut>> findAll() {
        return ChannelApi.super.findAll();
    }
}
