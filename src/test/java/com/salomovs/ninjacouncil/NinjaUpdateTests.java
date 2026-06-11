package com.salomovs.ninjacouncil;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

@WebMvcTest({NinjaService.class, NinjaController.class})
@AutoConfigureMockMvc
public class NinjaUpdateTests {

  @Autowired
  MockMvc mvc;

  @MockitoBean
  NinjaRepository ninjaRepository;

  @Test
  void updateNinjaInfoSuccess() {
    String payload = "{ \"name\":\"Ieiri\" }";
    Ninja ninja = new Ninja(1l, "name", "village", "clan", RankNinja.GENIN, ChakraNature.EARTH, NinjaStatus.DECEASED, null);

    when(ninjaRepository.findById(Mockito.anyLong()))
      .thenReturn(Optional.of(ninja));

    assertDoesNotThrow(()->mvc.perform(patch("/ninjas/1").contentType(MediaType.APPLICATION_JSON).content(payload)));
  }

}
