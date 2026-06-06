package com.salomovs.ninjacouncil.model;

import java.time.LocalDate;

import com.salomovs.ninjacouncil.enums.MissionNinjaAssignment;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ninja_mission_registry")
@AllArgsConstructor
@NoArgsConstructor
public class NinjaMission {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="mission_id")
  private Mission mission;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ninja_id")
  private Ninja ninja;

  @Enumerated(EnumType.STRING)
  private MissionNinjaAssignment assignment;

  private LocalDate assignmentDate;
}
