package com.salomovs.ninjacouncil.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.salomovs.ninjacouncil.enums.ChakraNature;
import com.salomovs.ninjacouncil.enums.NinjaStatus;
import com.salomovs.ninjacouncil.enums.RankNinja;

@Entity
@Getter
@Setter
@Table(name="ninjas_registry")
@AllArgsConstructor
@NoArgsConstructor
public class Ninja {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String village;
  private String clan;

  @Enumerated(EnumType.STRING)
  private RankNinja rankNinja;

  @Enumerated(EnumType.STRING)
  private ChakraNature chakraNature;

  @Enumerated(EnumType.STRING)
  private NinjaStatus ninjaStatus;

  @OneToMany(mappedBy="ninja")
  @JsonIgnore
  private List<NinjaMission> missions;
}
