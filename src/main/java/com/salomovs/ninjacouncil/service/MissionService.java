package com.salomovs.ninjacouncil.service;

import org.springframework.stereotype.Service;

import com.salomovs.ninjacouncil.dto.MissionRequest;
import com.salomovs.ninjacouncil.dto.NinjaMissionRequest;
import com.salomovs.ninjacouncil.model.Mission;
import com.salomovs.ninjacouncil.model.Ninja;
import com.salomovs.ninjacouncil.repository.MissionRepository;
import com.salomovs.ninjacouncil.repository.NinjaMissionRepository;
import com.salomovs.ninjacouncil.repository.NinjaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionService {

  private final NinjaMissionRepository nmRepository;
  private final MissionRepository missionRepository;
  private final NinjaRepository ninjaRepository;

  public void createMission(MissionRequest req) {
    Mission mission = req.toEntity();
    missionRepository.save(mission);
  }

  public void assignNinjaMission(Long missionId, NinjaMissionRequest req) {
    Ninja ninja = ninjaRepository.findById(req.ninjaId()).orElseThrow(()->new RuntimeException("NINJA NOT FOUND"));
    Mission mission = missionRepository.findById(missionId).orElseThrow(()->new RuntimeException("MISSION NOT FOUND"));
    nmRepository.save(req.toEntity(ninja, mission));
  }

}
