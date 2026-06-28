package com.salomovs.ninjacouncil.dto;

import java.time.LocalDate;

import com.salomovs.ninjacouncil.enums.MissionNinjaAssignment;
import com.salomovs.ninjacouncil.model.Mission;
import com.salomovs.ninjacouncil.model.Ninja;
import com.salomovs.ninjacouncil.model.NinjaMission;

public record NinjaMissionRequest (
  Long ninjaId,
  MissionNinjaAssignment assignment
) {
  public NinjaMission toEntity(Ninja ninja, Mission mission) {
    NinjaMission ninjaMission = new NinjaMission();
    ninjaMission.setNinja(ninja);
    ninjaMission.setMission(mission);
    fillUp(ninjaMission);
    return ninjaMission;
  }

  public NinjaMission fillUp(NinjaMission nm) {
    if (assignment != null)
      nm.setAssignment(assignment);
    nm.setAssignmentDate(LocalDate.now());
    return nm;
  }
}
