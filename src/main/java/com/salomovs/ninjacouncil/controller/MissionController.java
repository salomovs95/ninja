package com.salomovs.ninjacouncil.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.salomovs.ninjacouncil.dto.MissionRequest;
import com.salomovs.ninjacouncil.service.MissionService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

  private final MissionService missionService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void registerNewMission(@RequestBody @Valid MissionRequest req) {
    missionService.createMission(req);
  }

}
