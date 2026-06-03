package com.salomovs.ninjacouncil.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
  private Long id;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="mission_id")
  private Mission mission;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="ninja_id")
  private Ninja ninja;

  private String assignment;
  private LocalDate assignmentDate;
}
