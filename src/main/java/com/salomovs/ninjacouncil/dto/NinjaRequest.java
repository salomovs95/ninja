package com.salomovs.ninjacouncil.dto;

import com.salomovs.ninjacouncil.enums.ChakraNature;
import com.salomovs.ninjacouncil.enums.NinjaStatus;
import com.salomovs.ninjacouncil.enums.RankNinja;
import com.salomovs.ninjacouncil.model.Ninja;

public record NinjaRequest (

  String name,
  String village,
  String clan,
  RankNinja rankNinja,
  ChakraNature chakraNature,
  NinjaStatus ninjaStatus

) {

  public Ninja toEntity() {
    Ninja ninja = new Ninja();
    return fillEntity(ninja);
  }

  public Ninja fillEntity(Ninja ninja) {
    if (name != null)
      ninja.setName(name);

    if (clan != null)
      ninja.setClan(clan);

    if (village != null)
      ninja.setVillage(village);

    if (rankNinja != null)
      ninja.setRankNinja(rankNinja);

    if (chakraNature != null)
      ninja.setChakraNature(chakraNature);

    if (ninjaStatus != null)
      ninja.setNinjaStatus(ninjaStatus);

    return ninja;
  }

}
