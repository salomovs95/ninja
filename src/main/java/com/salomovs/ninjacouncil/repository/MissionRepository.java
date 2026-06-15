package com.salomovs.ninjacouncil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.ninjacouncil.model.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {}
