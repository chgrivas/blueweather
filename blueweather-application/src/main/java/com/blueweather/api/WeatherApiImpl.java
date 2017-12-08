package com.blueweather.api;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;
import com.blueweather.service.WeatherRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class WeatherApiImpl implements WeatherApi
{
  @Autowired
  private WeatherRetrievalService weatherRetrievalService;

  @Override
  public WeatherResponseDto getDefaultWeather() {
    return weatherRetrievalService.getDailyWeatherSummary(Place.NEW_YORK, Instant.now());
  }
}
