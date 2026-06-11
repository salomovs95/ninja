package com.salomovs.ninjacouncil.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.ninjacouncil.docs.INinjaController;
import com.salomovs.ninjacouncil.dto.NinjaRequest;
import com.salomovs.ninjacouncil.dto.NinjaResponse;
import com.salomovs.ninjacouncil.service.NinjaService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ninjas")
@RequiredArgsConstructor
public class NinjaController implements INinjaController {

  private final NinjaService ninjaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public NinjaResponse ninjaRegistry(@RequestBody @Valid NinjaRequest req) {
    var ninja = ninjaService.ninjaRegistry(req);
    return NinjaResponse.fromEntity(ninja);
  }

  @PatchMapping("/{ninja_id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateNinjaInfo(@PathVariable("ninja_id") Long ninjaId, @RequestBody NinjaRequest req) {
    ninjaService.updateNinjaInfo(ninjaId, req);
  }

}
