package com.salomovs.ninjacouncil.service;

import org.springframework.stereotype.Service;

import com.salomovs.ninjacouncil.dto.MissionRequest;
import com.salomovs.ninjacouncil.model.Mission;
import com.salomovs.ninjacouncil.repository.MissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissionService {

  private final MissionRepository missionRepository;

  public void createMission(MissionRequest req) {
    Mission mission = req.toEntity();
    missionRepository.save(mission);
  }

}
