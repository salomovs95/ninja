package com.salomovs.ninjacouncil.service;

import org.springframework.stereotype.Service;

import com.salomovs.ninjacouncil.dto.NinjaRequest;
import com.salomovs.ninjacouncil.model.Ninja;
import com.salomovs.ninjacouncil.repository.NinjaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NinjaService {

  private final NinjaRepository ninjaRepository;

  public Ninja ninjaRegistry(NinjaRequest req) {
    return ninjaRepository.save(req.toEntity());
  }

  public void updateNinjaInfo(Long ninjaId, NinjaRequest req) {
    Ninja ninja = ninjaRepository.findById(ninjaId).orElseThrow(()->new RuntimeException("Ninja not found!"));
    ninjaRepository.save(req.fillEntity(ninja));
  }

}
