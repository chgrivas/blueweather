package com.blueweather.api;

import com.blueweather.api.dto.WeatherResponseDto;
import com.blueweather.domain.enumeration.Place;
import com.blueweather.service.WeatherRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@RestController
public class WeatherApiImpl implements WeatherApi
{
  private static final String MAX_HUMIDITY_LABEL = "Max percentage humidity";
  private static final String MAX_TEMPERATURE_LABEL = "Max Temp in C";
  private static final String MIN_TEMPERATURE_LABEL = "Min Temp in C";
  private static final String PRECIPATION_LABEL = "Precipation in mm";
  private static final String FILE_KEY_VALUE_SEPARATOR = ": ";

  @Autowired
  private WeatherRetrievalService weatherRetrievalService;

  @Override
  public void getDefaultWeather(HttpServletResponse response) {
    WeatherResponseDto weatherResponseDto = weatherRetrievalService.getDailyWeatherSummary(Place.NEW_YORK, Instant.now());
    constructResponse(response, weatherResponseDto);
  }

  private void constructResponse(HttpServletResponse response, WeatherResponseDto weatherResponseDto) {
    try {

      response.setContentType("text/html");
      response.setHeader("charset", "utf-8");
      response.setHeader("Content-Disposition", "attachment; filename=somefile.txt");

      response.getWriter().println(MAX_HUMIDITY_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMaxHumidity());
      response.getWriter().println(MAX_TEMPERATURE_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMaxTemperatureInCelcius());
      response.getWriter().println(MIN_TEMPERATURE_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getMinTemperatureInCelcius());
      response.getWriter().println(PRECIPATION_LABEL + FILE_KEY_VALUE_SEPARATOR + weatherResponseDto.getPrecipitation());

      response.flushBuffer();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
