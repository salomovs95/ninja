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
    return new Ninja(
      null,
      name,
      village,
      clan,
      rankNinja,
      chakraNature,
      ninjaStatus,
      null
    );
  }

}
