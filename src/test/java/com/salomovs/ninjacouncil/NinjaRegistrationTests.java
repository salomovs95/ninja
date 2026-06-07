package com.salomovs.ninjacouncil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.salomovs.ninjacouncil.controller.NinjaController;
import com.salomovs.ninjacouncil.enums.ChakraNature;
import com.salomovs.ninjacouncil.enums.NinjaStatus;
import com.salomovs.ninjacouncil.enums.RankNinja;
import com.salomovs.ninjacouncil.model.Ninja;
import com.salomovs.ninjacouncil.repository.NinjaRepository;
import com.salomovs.ninjacouncil.service.NinjaService;

@WebMvcTest({NinjaController.class, NinjaService.class})
@AutoConfigureMockMvc
public class NinjaRegistrationTests {

  @Autowired
  MockMvc mvc;

  @MockitoBean
  NinjaRepository ninjaRepository;

  @Test
  void registerNinjaSuccess() {
    Ninja mockedResult = new Ninja(0l, "name", "village", "clan", RankNinja.GENIN, ChakraNature.WIND, NinjaStatus.DECEASED, new ArrayList<>());
    String payload = "{\"name\":\"name\", \"village\":\"village\", \"clan\":\"clan\", \"rankNinja\":\"GENIN\", \"chakraNature\":\"WIND\", \"ninjaStatus\":\"DECEASED\"}";
    when(ninjaRepository.save(any(Ninja.class))).thenReturn(mockedResult);
    assertDoesNotThrow(()->mvc.perform(post("/ninjas").contentType(MediaType.APPLICATION_JSON).content(payload)));
  }

  @Test
  void registerNinjaFails() {
    String payload = "{\"name\":\"name\", \"village\":\"village\", \"clan\":\"clan\", \"rankNinja\":\"GENIN\", \"chakraNature\":\"WIND\", \"ninjaStatus\":\"DECEASED\"}";
    assertThrows(Exception.class, ()->mvc.perform(post("/ninjas").contentType(MediaType.APPLICATION_JSON).content(payload)));
  }

}
