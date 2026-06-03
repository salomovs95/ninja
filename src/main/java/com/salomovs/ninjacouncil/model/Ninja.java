package com.salomovs.ninjacouncil.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  private String rankNinja;
  private String chakraNature;
  private String ninjaStatus;

  @OneToMany(mappedBy="ninja")
  @JsonIgnore
  private List<NinjaMission> missions;
}
