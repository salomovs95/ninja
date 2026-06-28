package com.salomovs.ninjacouncil.docs;

import com.salomovs.ninjacouncil.dto.MissionRequest;
import com.salomovs.ninjacouncil.dto.NinjaMissionRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Missions and Ninja Assignment")
public interface IMissionController {

  @Operation(summary="Performs a mission regisgration")
  void registerNewMission(
    @RequestBody
    MissionRequest req
  );

  @Operation(summary="Assignes a ninja to a mission")
  void assignNinjaMission(
    @Parameter
    Long missionId,

    @RequestBody
    NinjaMissionRequest req
  );

}
