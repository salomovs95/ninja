package com.salomovs.ninjacouncil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.salomovs.ninjacouncil.repository.NinjaRepository;
import com.salomovs.ninjacouncil.service.NinjaService;

@Configuration
public class ConfigBean {

  @Bean
  public NinjaService ninjaService(NinjaRepository ninjaRepository) {
    return new NinjaService(ninjaRepository);
  }

}
