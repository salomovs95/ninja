package com.salomovs.ninjacouncil;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.salomovs.ninjacouncil.controller.MissionController;
import com.salomovs.ninjacouncil.enums.MissionRank;
import com.salomovs.ninjacouncil.enums.MissionStatus;
import com.salomovs.ninjacouncil.model.Mission;
import com.salomovs.ninjacouncil.repository.MissionRepository;
import com.salomovs.ninjacouncil.service.MissionService;

@WebMvcTest({MissionController.class, MissionService.class})
@AutoConfigureMockMvc
public class MissionRegisteringTests {

  @Autowired
  MockMvc mvc;

  @MockitoBean
  MissionRepository missionRepository;

  @Test
  void registerMission() {
    Mission mission = new Mission(999l, "title", "description", "village", MissionRank.A, MissionStatus.OPEN, null);
    String payload = "{\"title\":\"title\",\"description\":\"description\",\"village\":\"village\",\"rank\":\"A\"}";

    when(missionRepository.save(Mockito.any(Mission.class)))
      .thenReturn(mission);

    assertDoesNotThrow(()->{
      mvc.perform(post("/missions").contentType(MediaType.APPLICATION_JSON).content(payload))
         .andExpect(status().isCreated());
    });
  }

}
