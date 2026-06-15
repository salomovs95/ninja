package com.salomovs.ninjacouncil.dto;

import com.salomovs.ninjacouncil.enums.MissionRank;
import com.salomovs.ninjacouncil.model.Mission;

public record MissionRequest (
  String title,
  String description,
  String village,
  MissionRank rank
) {

  public Mission toEntity() {
    Mission mission = new Mission();
    return fillUp(mission);
  }

  public Mission fillUp(Mission mission) {
    if (title != null)
      mission.setTitle(title);
    if (description != null)
      mission.setDescription(description);
    if (village != null)
      mission.setVillage(village);
    if (rank != null)
      mission.setMissionRank(rank);
    return mission;
  }

}
