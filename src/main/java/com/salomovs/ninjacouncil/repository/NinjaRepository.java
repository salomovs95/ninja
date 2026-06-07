package com.salomovs.ninjacouncil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salomovs.ninjacouncil.model.Ninja;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {}
