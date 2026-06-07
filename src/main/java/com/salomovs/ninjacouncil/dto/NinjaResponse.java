package com.salomovs.ninjacouncil.dto;

import com.salomovs.ninjacouncil.enums.ChakraNature;
import com.salomovs.ninjacouncil.enums.NinjaStatus;
import com.salomovs.ninjacouncil.enums.RankNinja;
import com.salomovs.ninjacouncil.model.Ninja;

public record NinjaResponse (
  Long id,
  String name,
  String village,
  String clan,
  RankNinja rankNinja,
  ChakraNature chakraNature,
  NinjaStatus ninjaStatus
) {

  public static NinjaResponse fromEntity(Ninja ninja) {
    return new NinjaResponse(
      ninja.getId(),
      ninja.getName(),
      ninja.getVillage(),
      ninja.getClan(),
      ninja.getRankNinja(),
      ninja.getChakraNature(),
      ninja.getNinjaStatus()
    );
  }

}
