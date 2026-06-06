package com.salomovs.ninjacouncil.model;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.salomovs.ninjacouncil.enums.MissionRank;
import com.salomovs.ninjacouncil.enums.MissionStatus;

@Entity
@Getter
@Setter
@Table(name="missions_registry")
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String village;

  @Enumerated(EnumType.STRING)
  private MissionRank missionRank;

  @Enumerated(EnumType.STRING)
  private MissionStatus missionStatus;

  @OneToMany(mappedBy="mission")
  @JsonIgnore
  private List<NinjaMission> missions;
}
