package com.salomovs.ninjacouncil;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.salomovs.ninjacouncil.controller.MissionController;
import com.salomovs.ninjacouncil.model.Mission;
import com.salomovs.ninjacouncil.model.Ninja;
import com.salomovs.ninjacouncil.repository.MissionRepository;
import com.salomovs.ninjacouncil.repository.NinjaMissionRepository;
import com.salomovs.ninjacouncil.repository.NinjaRepository;
import com.salomovs.ninjacouncil.service.MissionService;

@WebMvcTest({MissionService.class, MissionController.class})
@AutoConfigureMockMvc
public class NinjaMissionAssignmentTests {

  @Autowired
  private MockMvc mvc;

  @MockitoBean
  NinjaRepository ninjaRepo;

  @MockitoBean
  MissionRepository missionRepo;

  @MockitoBean
  NinjaMissionRepository nmRepo;

  @Test
  void assignNinjaToAMission() {
    String payload = "{\"ninjaId\":999,\"assignment\":\"SENSORIAL\"}";

    when(ninjaRepo.findById(Mockito.anyLong()))
      .thenReturn(Optional.of(new Ninja(999l, "name", "village", "clan", null, null, null, null)));

    when(missionRepo.findById(Mockito.anyLong()))
      .thenReturn(Optional.of(new Mission(999l, "title", "description", "village", null, null, null)));
  
    assertDoesNotThrow(()->mvc.perform(post("/missions/9").contentType(MediaType.APPLICATION_JSON).content(payload))
      .andExpect(status().isCreated()));
  }

}
